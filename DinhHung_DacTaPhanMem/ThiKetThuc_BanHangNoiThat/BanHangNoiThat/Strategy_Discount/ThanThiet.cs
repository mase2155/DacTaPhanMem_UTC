namespace BanHangNoiThat.Strategy;

public class ThanThiet : Discount
{
    string Discount.Ten => "Thân thiết";

    decimal Discount.TyLe => 30;

    decimal Discount.Discount(decimal tongTienDonHang)
    {
        return tongTienDonHang * 30 / 100;
    }
}
