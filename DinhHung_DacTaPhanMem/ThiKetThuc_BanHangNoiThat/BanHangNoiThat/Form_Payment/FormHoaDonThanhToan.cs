using BanHangNoiThat.Form_Payment;
using BanHangNoiThat.Strategy;
using Microsoft.Data.SqlClient;

namespace BanHangNoiThat;

public class FormHoaDonThanhToan : Form
{
    private readonly ComboBox _cboSanPham = new() { DropDownStyle = ComboBoxStyle.DropDownList };
    private readonly Label _lblDonGia = new();
    private readonly TextBox _txtKhachTra = new();
    private readonly RadioButton _radTienMat = new();
    private readonly RadioButton _radChuyenKhoan = new();
    private readonly Label _lblLoi = new();
    private readonly Button _btnThanhToan = new();

    public FormHoaDonThanhToan()
    {
        Text = "Thanh toán";
        StartPosition = FormStartPosition.CenterScreen;
        ClientSize = new Size(520, 420);
        FormBorderStyle = FormBorderStyle.FixedDialog;
        MaximizeBox = false;
        Font = new Font("Segoe UI", 11F);
        BackColor = Color.FromArgb(247, 244, 239);

        var tieuDe = new Label
        {
            Text = "Thanh toán sản phẩm",
            Font = new Font("Segoe UI", 18F, FontStyle.Bold),
            ForeColor = Color.FromArgb(62, 44, 35),
            AutoSize = true,
            Location = new Point(28, 18)
        };

        Controls.Add(tieuDe);
        Controls.Add(TaoNhan("Sản phẩm", 64));
        _cboSanPham.Location = new Point(28, 92);
        _cboSanPham.Size = new Size(460, 28);
        _cboSanPham.SelectedIndexChanged += (_, _) => HienDonGia();
        Controls.Add(_cboSanPham);

        _lblDonGia.Text = "Đơn giá: —";
        _lblDonGia.AutoSize = true;
        _lblDonGia.Location = new Point(28, 132);
        _lblDonGia.ForeColor = Color.FromArgb(62, 44, 35);
        _lblDonGia.Font = new Font("Segoe UI", 11F, FontStyle.Bold);
        Controls.Add(_lblDonGia);

        Controls.Add(TaoNhan("Số tiền khách trả", 168));
        _txtKhachTra.Location = new Point(28, 196);
        _txtKhachTra.Size = new Size(460, 28);
        _txtKhachTra.BorderStyle = BorderStyle.FixedSingle;
        Controls.Add(_txtKhachTra);

        Controls.Add(TaoNhan("Cách thanh toán", 240));
        _radTienMat.Text = "Tiền mặt";
        _radTienMat.Location = new Point(28, 268);
        _radTienMat.AutoSize = true;
        _radTienMat.Checked = true;
        _radChuyenKhoan.Text = "Chuyển khoản";
        _radChuyenKhoan.Location = new Point(180, 268);
        _radChuyenKhoan.AutoSize = true;
        Controls.Add(_radTienMat);
        Controls.Add(_radChuyenKhoan);

        _btnThanhToan.Text = "Thanh toán";
        _btnThanhToan.Location = new Point(28, 320);
        _btnThanhToan.Size = new Size(140, 40);
        _btnThanhToan.BackColor = Color.FromArgb(62, 44, 35);
        _btnThanhToan.ForeColor = Color.White;
        _btnThanhToan.FlatStyle = FlatStyle.Flat;
        _btnThanhToan.FlatAppearance.BorderSize = 0;
        _btnThanhToan.Click += Btn_Click;
        Controls.Add(_btnThanhToan);

        _lblLoi.Location = new Point(180, 324);
        _lblLoi.Size = new Size(310, 48);
        _lblLoi.ForeColor = Color.FromArgb(168, 56, 40);
        Controls.Add(_lblLoi);

        AcceptButton = _btnThanhToan;
        Load += (_, _) => TaiSanPham();
    }

    private static Label TaoNhan(string text, int y)
    {
        return new Label
        {
            Text = text,
            AutoSize = true,
            Location = new Point(28, y),
            ForeColor = Color.FromArgb(92, 64, 51)
        };
    }

    private void TaiSanPham()
    {
        try
        {
            using SqlConnection ketNoi = CauHinhCSDL.Mo();
            using var lenh = new SqlCommand(
                "SELECT SanPhamID, MaSP, TenSanPham, DonGia FROM dbo.SanPham ORDER BY TenSanPham",
                ketNoi);
            using SqlDataReader doc = lenh.ExecuteReader();
            while (doc.Read())
            {
                _cboSanPham.Items.Add(new SanPhamChon
                {
                    Id = doc.GetInt32(0),
                    Ma = doc.GetString(1),
                    Ten = doc.GetString(2),
                    DonGia = doc.GetDecimal(3)
                });
            }

            if (_cboSanPham.Items.Count == 0)
            {
                _lblLoi.Text = "Database chưa có sản phẩm.";
                _btnThanhToan.Enabled = false;
                return;
            }

            _cboSanPham.SelectedIndex = 0;
        }
        catch (Exception ex)
        {
            _lblLoi.Text = "Không tải được sản phẩm. " + ex.Message;
            _btnThanhToan.Enabled = false;
        }
    }

    private void HienDonGia()
    {
        if (_cboSanPham.SelectedItem is not SanPhamChon sanPham)
        {
            _lblDonGia.Text = "Đơn giá: —";
            return;
        }

        _lblDonGia.Text = "Đơn giá: " + Tien(sanPham.DonGia);
    }

    private void Btn_Click(object? sender, EventArgs e)
    {
        _lblLoi.Text = "";

        if (_cboSanPham.SelectedItem is not SanPhamChon sanPham)
        {
            _lblLoi.Text = "Hãy chọn một sản phẩm.";
            return;
        }

        if (!DocTien(_txtKhachTra.Text, out decimal khachTra))
        {
            _lblLoi.Text = "Nhập số tiền khách trả.";
            return;
        }

        var context = new PaymentContext();
        IPayment cach = _radTienMat.Checked ? new PayByCash() : new PayByBanking();
        context.Chon(cach);

        KetQuaThanhToan ketQua = context.ThucHien(sanPham.DonGia, khachTra);
        var formKetQua = new FormKetQua(sanPham.ToString(), context.Ten, sanPham.DonGia, khachTra, ketQua);
        formKetQua.ShowDialog(this);
    }

    private static bool DocTien(string text, out decimal so)
    {
        string sach = text.Replace(".", "").Replace(",", "").Replace(" ", "").Trim();
        return decimal.TryParse(sach, out so);
    }

    private static string Tien(decimal so)
    {
        return so.ToString("N0") + " đ";
    }

    private sealed class SanPhamChon
    {
        public int Id { get; init; }
        public string Ma { get; init; } = "";
        public string Ten { get; init; } = "";
        public decimal DonGia { get; init; }
        public override string ToString() => Ma + "  ·  " + Ten;
    }
}
