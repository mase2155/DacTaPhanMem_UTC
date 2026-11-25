namespace BanHangNoiThat;

public class FormChinh : Form
{
    public FormChinh()
    {
        Text = "Bán hàng đồ nội thất";
        StartPosition = FormStartPosition.CenterScreen;
        ClientSize = new Size(420, 220);
        FormBorderStyle = FormBorderStyle.FixedDialog;
        MaximizeBox = false;
        Font = new Font("Segoe UI", 11F);
        BackColor = Color.FromArgb(247, 244, 239);

        var tieuDe = new Label
        {
            Text = "Chọn nghiệp vụ",
            Font = new Font("Segoe UI", 18F, FontStyle.Bold),
            ForeColor = Color.FromArgb(62, 44, 35),
            AutoSize = true,
            Location = new Point(28, 20)
        };

        var btnThanhToan = TaoNut("Thanh toán", 80);
        btnThanhToan.Click += (_, _) => new FormHoaDonThanhToan().Show();

        var btnGiamGia = TaoNut("Khuyến mãi khách hàng", 135);
        btnGiamGia.Click += (_, _) => new FormGiamGia().Show();

        Controls.Add(tieuDe);
        Controls.Add(btnThanhToan);
        Controls.Add(btnGiamGia);
    }

    private static Button TaoNut(string text, int y)
    {
        var nut = new Button
        {
            Text = text,
            Location = new Point(28, y),
            Size = new Size(360, 40),
            BackColor = Color.FromArgb(62, 44, 35),
            ForeColor = Color.White,
            FlatStyle = FlatStyle.Flat
        };
        nut.FlatAppearance.BorderSize = 0;
        return nut;
    }
}
