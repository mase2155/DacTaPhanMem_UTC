namespace BanHangNoiThat.Strategy;

// Hợp đồng giảm giá. Mỗi loại khách có một cách tính riêng.
public interface Discount
{
    string Ten { get; }

    decimal TyLe { get; }

    decimal Discount(decimal tongTienDonHang);
}
