namespace BanHangNoiThat.Strategy;

// Khách chuyển khoản. Phải chuyển đúng số tiền trên hóa đơn.
public class PayByBanking : IPayment
{
    public string Ten => "Chuyển khoản";

    public KetQuaThanhToan Pay(decimal soTienPhaiTra, decimal soTienKhachTra)
    {
        if (soTienKhachTra < soTienPhaiTra)
        {
            return new KetQuaThanhToan
            {
                ThanhCong = false,
                TienThua = 0,
                ThongBao = "Số tiền chuyển khoản chưa đủ."
            };
        }

        if (soTienKhachTra > soTienPhaiTra)
        {
            return new KetQuaThanhToan
            {
                ThanhCong = false,
                TienThua = 0,
                ThongBao = "Chuyển khoản phải đúng số tiền hóa đơn, không chuyển dư."
            };
        }

        return new KetQuaThanhToan
        {
            ThanhCong = true,
            TienThua = 0,
            ThongBao = "Chuyển khoản thành công."
        };
    }
}
