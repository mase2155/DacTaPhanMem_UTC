namespace BanHangNoiThat;

public class FormKetQuaGiamGia : Form
{
    public FormKetQuaGiamGia(KhachHangGiam khach, string mucDo, decimal tongTien, decimal tienGiam)
    {
        Text = "Kết quả khuyến mãi";
        StartPosition = FormStartPosition.CenterParent;
        ClientSize = new Size(480, 360);
        FormBorderStyle = FormBorderStyle.FixedDialog;
        MaximizeBox = false;
        MinimizeBox = false;
        Font = new Font("Segoe UI", 11F);
        BackColor = Color.FromArgb(247, 244, 239);

        var tieuDe = new Label
        {
            Text = "Thông tin khách hàng",
            Font = new Font("Segoe UI", 16F, FontStyle.Bold),
            ForeColor = Color.FromArgb(62, 44, 35),
            AutoSize = true,
            Location = new Point(24, 18)
        };

        string email = khach.Email.Length == 0 ? "Không có" : khach.Email;
        string diaChi = khach.DiaChi.Length == 0 ? "Không có" : khach.DiaChi;
        decimal thanhTien = tongTien - tienGiam;

        var chiTiet = new Label
        {
            Text =
                "Tên khách hàng: " + khach.HoTen + "\n" +
                "Số điện thoại: " + khach.SoDienThoai + "\n" +
                "Email: " + email + "\n" +
                "Địa chỉ: " + diaChi + "\n" +
                "Mức khuyến mãi: " + mucDo + "\n\n" +
                "Tổng tiền: " + Tien(tongTien) + "\n" +
                "Tiền giảm: " + Tien(tienGiam) + "\n" +
                "Thành tiền: " + Tien(thanhTien),
            AutoSize = false,
            Location = new Point(24, 64),
            Size = new Size(430, 220),
            ForeColor = Color.FromArgb(42, 36, 32)
        };

        var btn = new Button
        {
            Text = "Đóng",
            Location = new Point(320, 300),
            Size = new Size(130, 40),
            DialogResult = DialogResult.OK,
            FlatStyle = FlatStyle.Flat,
            BackColor = Color.White
        };

        Controls.Add(tieuDe);
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
