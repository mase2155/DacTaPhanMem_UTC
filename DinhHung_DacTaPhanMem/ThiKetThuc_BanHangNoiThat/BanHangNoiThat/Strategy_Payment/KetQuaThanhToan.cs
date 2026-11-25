namespace BanHangNoiThat.Strategy;

// Kết quả sau khi thanh toán. Form chỉ cần đọc 3 thông tin này.
public class KetQuaThanhToan
{
    public bool ThanhCong { get; set; }
    public decimal TienThua { get; set; }
    public string ThongBao { get; set; } = "";
}
