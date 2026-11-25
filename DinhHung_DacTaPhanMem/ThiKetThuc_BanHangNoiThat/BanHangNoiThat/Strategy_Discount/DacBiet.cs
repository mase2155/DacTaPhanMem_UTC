namespace BanHangNoiThat.Strategy;

public class DacBiet : Discount
{
    string Discount.Ten => "Đặc biệt";

    decimal Discount.TyLe => 50;

    decimal Discount.Discount(decimal tongTienDonHang)
    {
        return tongTienDonHang * 50 / 100;
    }
}
