using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BanHangNoiThat.Strategy_DinhHung
{
    public class NoPercent :IDiscount
    {
        public decimal PercentDiscount(decimal SumPrice)
        {
            return 0;
        }
    }
}
