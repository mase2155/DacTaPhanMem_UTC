namespace BanHangNoiThat.Strategy;

public class BinhThuong : Discount
{
    string Discount.Ten => "Bình thường";

    decimal Discount.TyLe => 10;

    decimal Discount.Discount(decimal tongTienDonHang)
    {
        return tongTienDonHang * 10 / 100;
    }
}
