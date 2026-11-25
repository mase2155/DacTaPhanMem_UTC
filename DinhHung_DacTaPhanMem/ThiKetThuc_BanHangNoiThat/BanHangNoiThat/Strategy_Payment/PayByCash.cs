namespace BanHangNoiThat.Strategy;

// Khách đưa tiền mặt. Được thừa tiền. Không được thiếu.
public class PayByCash : IPayment
{
    public string Ten => "Tiền mặt";

    public KetQuaThanhToan Pay(decimal soTienPhaiTra, decimal soTienKhachTra)
    {
        if (soTienKhachTra < soTienPhaiTra)
        {
            return new KetQuaThanhToan
            {
                ThanhCong = false,
                TienThua = 0,
                ThongBao = "Tiền mặt chưa đủ để thanh toán."
            };
        }

        decimal tienThua = soTienKhachTra - soTienPhaiTra;

        return new KetQuaThanhToan
        {
            ThanhCong = true,
            TienThua = tienThua,
            ThongBao = "Thanh toán tiền mặt thành công."
        };
    }
}
