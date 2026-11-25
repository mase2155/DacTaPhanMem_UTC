using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BanHangNoiThat.Strategy_DinhHung
{
    public interface IDiscount
    {
        decimal PercentDiscount(decimal SumPrice);
    }
}
