namespace BanHangNoiThat.Strategy;

// Giữ loại giảm giá đang chọn, rồi gọi Discount của loại đó.
public class DiscountContext
{
    private Discount? cachGiam;

    public string Ten
    {
        get
        {
            if (cachGiam == null)
            {
                return "";
            }
            else
            {
                return cachGiam.Ten;
            }
        }
    }

    public decimal TyLe
    {
        get
        {
            if (cachGiam == null)
            {
                return 0;
            }
            else
            {
                return cachGiam.TyLe;
            }
        }
    }

    public void Chon(Discount cach)
    {
        cachGiam = cach;
    }

    public decimal ThucHien(decimal tongTienDonHang)
    {
        if (cachGiam == null)
        {
            return 0;
        }

        return cachGiam.Discount(tongTienDonHang);
    }
}
