namespace BanHangNoiThat.Strategy;

// Giữ cách thanh toán đang chọn, rồi gọi Pay của cách đó.
// Đổi cách thanh toán bằng Chon, không sửa công thức bên trong.
public class PaymentContext
{
    private IPayment? cachThanhToan;

    public string Ten => cachThanhToan == null ? "" : cachThanhToan.Ten;

    public void Chon(IPayment cach)
    {
        cachThanhToan = cach;
    }

    public KetQuaThanhToan ThucHien(decimal soTienPhaiTra, decimal soTienKhachTra)
    {
        if (cachThanhToan == null)
        {
            return new KetQuaThanhToan
            {
                ThanhCong = false,
                TienThua = 0,
                ThongBao = "Chưa chọn cách thanh toán."
            };
        }

        if (soTienPhaiTra <= 0)
        {
            return new KetQuaThanhToan
            {
                ThanhCong = false,
                TienThua = 0,
                ThongBao = "Số tiền phải trả phải lớn hơn 0."
            };
        }

        return cachThanhToan.Pay(soTienPhaiTra, soTienKhachTra);
    }
}
