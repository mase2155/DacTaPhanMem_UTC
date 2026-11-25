using BanHangNoiThat.Strategy;

namespace BanHangNoiThat.Form_Payment;

public class FormKetQua : Form
{
    public FormKetQua(string tenSanPham, string tenCach, decimal phaiTra, decimal khachTra, KetQuaThanhToan ketQua)
    {
        Text = "Kết quả thanh toán";
        StartPosition = FormStartPosition.CenterParent;
        ClientSize = new Size(460, 340);
        FormBorderStyle = FormBorderStyle.FixedDialog;
        MaximizeBox = false;
        MinimizeBox = false;
        Font = new Font("Segoe UI", 11F);

        Color nen = ketQua.ThanhCong
            ? Color.FromArgb(232, 244, 236)
            : Color.FromArgb(252, 232, 228);
        Color chu = ketQua.ThanhCong
            ? Color.FromArgb(36, 110, 74)
            : Color.FromArgb(168, 56, 40);
        BackColor = nen;

        var tieuDe = new Label
        {
            Text = ketQua.ThanhCong ? "Thanh toán thành công" : "Thanh toán không thành công",
            Font = new Font("Segoe UI", 16F, FontStyle.Bold),
            ForeColor = chu,
            AutoSize = true,
            Location = new Point(24, 20)
        };

        var thongBao = new Label
        {
            Text = ketQua.ThongBao,
            Font = new Font("Segoe UI", 12F),
            ForeColor = chu,
            AutoSize = false,
            Location = new Point(24, 64),
            Size = new Size(410, 48)
        };

        var chiTiet = new Label
        {
            Text =
                "Sản phẩm: " + tenSanPham + "\n" +
                "Cách thanh toán: " + tenCach + "\n" +
                "Phải trả: " + Tien(phaiTra) + "\n" +
                "Khách trả: " + Tien(khachTra) + "\n" +
                "Tiền thừa: " + Tien(ketQua.TienThua),
            AutoSize = false,
            Location = new Point(24, 120),
            Size = new Size(410, 130),
            ForeColor = Color.FromArgb(42, 36, 32)
        };

        var btn = new Button
        {
            Text = "Đóng",
            Location = new Point(300, 276),
            Size = new Size(130, 40),
            DialogResult = DialogResult.OK,
            FlatStyle = FlatStyle.Flat,
            BackColor = Color.White
        };

        Controls.Add(tieuDe);
        Controls.Add(thongBao);
        Controls.Add(chiTiet);
        Controls.Add(btn);
        AcceptButton = btn;
        CancelButton = btn;
    }

    private static string Tien(decimal so)
    {
        return so.ToString("N0") + " đ";
    }
}
