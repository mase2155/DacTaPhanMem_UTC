using BanHangNoiThat.Strategy;
using Microsoft.Data.SqlClient;

namespace BanHangNoiThat;

public class FormGiamGia : Form
{
    private readonly TextBox _txtSdt = new();
    private readonly TextBox _txtTongTien = new();
    private readonly Label _lblLoi = new();

    public FormGiamGia()
    {
        Text = "Giảm giá theo khách hàng";
        StartPosition = FormStartPosition.CenterScreen;
        ClientSize = new Size(480, 300);
        FormBorderStyle = FormBorderStyle.FixedDialog;
        MaximizeBox = false;
        Font = new Font("Segoe UI", 11F);
        BackColor = Color.FromArgb(247, 244, 239);

        var tieuDe = new Label
        {
            Text = "Tra cứu khuyến mãi",
            Font = new Font("Segoe UI", 18F, FontStyle.Bold),
            ForeColor = Color.FromArgb(62, 44, 35),
            AutoSize = true,
            Location = new Point(28, 18)
        };

        var lblSdt = TaoNhan("Số điện thoại", 68);
        _txtSdt.Location = new Point(28, 96);
        _txtSdt.Size = new Size(420, 28);
        _txtSdt.BorderStyle = BorderStyle.FixedSingle;

        var lblTien = TaoNhan("Tổng tiền đơn hàng", 140);
        _txtTongTien.Location = new Point(28, 168);
        _txtTongTien.Size = new Size(420, 28);
        _txtTongTien.BorderStyle = BorderStyle.FixedSingle;

        var btn = new Button
        {
            Text = "Xem khuyến mãi",
            Location = new Point(28, 220),
            Size = new Size(160, 40),
            BackColor = Color.FromArgb(62, 44, 35),
            ForeColor = Color.White,
            FlatStyle = FlatStyle.Flat
        };
        btn.FlatAppearance.BorderSize = 0;
        btn.Click += Btn_Click;

        _lblLoi.Location = new Point(200, 224);
        _lblLoi.Size = new Size(250, 48);
        _lblLoi.ForeColor = Color.FromArgb(168, 56, 40);

        Controls.Add(tieuDe);
        Controls.Add(lblSdt);
        Controls.Add(_txtSdt);
        Controls.Add(lblTien);
        Controls.Add(_txtTongTien);
        Controls.Add(btn);
        Controls.Add(_lblLoi);
        AcceptButton = btn;
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

    private void Btn_Click(object? sender, EventArgs e)
    {
        _lblLoi.Text = "";
        string sdt = _txtSdt.Text.Trim();
        if (sdt.Length == 0)
        {
            _lblLoi.Text = "Nhập số điện thoại.";
            return;
        }

        if (!DocTien(_txtTongTien.Text, out decimal tongTien) || tongTien <= 0)
        {
            _lblLoi.Text = "Tổng tiền đơn phải lớn hơn 0.";
            return;
        }

        KhachHangGiam? khach = TimKhach(sdt);
        if (khach == null)
        {
            _lblLoi.Text = "Không có số điện thoại này trong danh sách khách.";
            return;
        }

        var context = new DiscountContext();
        Discount? cach = TaoCachGiam(khach.LoaiKH);
        decimal tienGiam = 0;
        if (cach != null)
        {
            context.Chon(cach);
            tienGiam = context.ThucHien(tongTien);
        }

        string mucDo = cach == null
            ? "Chưa phân loại"
            : context.Ten + " — giảm " + context.TyLe.ToString("0") + "%";

        var form = new FormKetQuaGiamGia(khach, mucDo, tongTien, tienGiam);
        form.ShowDialog(this);
    }

    private static Discount? TaoCachGiam(string? loaiKh)
    {
        if (string.IsNullOrWhiteSpace(loaiKh))
        {
            return null;
        }

        string loai = loaiKh.Trim().ToLowerInvariant();
        if (loai is "dacbiet" or "đặc biệt")
        {
            return new DacBiet();
        }

        if (loai is "thanthiet" or "thân thiết")
        {
            return new ThanThiet();
        }

        if (loai is "binhthuong" or "bình thường")
        {
            return new BinhThuong();
        }

        return null;
    }

    private static KhachHangGiam? TimKhach(string sdt)
    {
        using SqlConnection ketNoi = CauHinhCSDL.Mo();
        using var lenh = new SqlCommand(
            """
            SELECT HoTen, SoDienThoai, Email, DiaChi, LoaiKH
            FROM dbo.KhachHang
            WHERE SoDienThoai = @Sdt
            """,
            ketNoi);
        lenh.Parameters.AddWithValue("@Sdt", sdt);
        using SqlDataReader doc = lenh.ExecuteReader();
        if (!doc.Read())
        {
            return null;
        }

        return new KhachHangGiam
        {
            HoTen = doc.GetString(0),
            SoDienThoai = doc.GetString(1),
            Email = doc.IsDBNull(2) ? "" : doc.GetString(2),
            DiaChi = doc.IsDBNull(3) ? "" : doc.GetString(3),
            LoaiKH = doc.IsDBNull(4) ? null : doc.GetString(4)
        };
    }

    private static bool DocTien(string text, out decimal so)
    {
        string sach = text.Replace(".", "").Replace(",", "").Replace(" ", "").Trim();
        return decimal.TryParse(sach, out so);
    }
}

public class KhachHangGiam
{
    public string HoTen { get; init; } = "";
    public string SoDienThoai { get; init; } = "";
    public string Email { get; init; } = "";
    public string DiaChi { get; init; } = "";
    public string? LoaiKH { get; init; }
}
