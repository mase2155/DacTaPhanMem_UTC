namespace BanHangNoiThat.Strategy;

// Hợp đồng thanh toán.
// Mọi cách trả tiền đều có đúng một hàm Pay.
public interface IPayment
{
    string Ten { get; }

    KetQuaThanhToan Pay(decimal soTienPhaiTra, decimal soTienKhachTra);
}
