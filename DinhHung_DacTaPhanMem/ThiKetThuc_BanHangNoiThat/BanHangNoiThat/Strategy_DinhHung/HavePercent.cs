using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BanHangNoiThat.Strategy_DinhHung
{
    public class HavePercent:IDiscount
    {
        private decimal percent { get; set; }
        private decimal maxMoney { get; set; }
        public HavePercent() { }
        public HavePercent(decimal percent, decimal maxMoney)
        {
            this.percent = percent;
            this.maxMoney = maxMoney;
        }

        public void CheckAvailable(decimal Percent, decimal MaxMoney)
        {
            if(Percent >0 && Percent <100)
            {
                Percent = percent;
                MaxMoney = maxMoney;
            }
            else
            {
                throw new ArgumentException("Phần trăm giảm giá phải lớn hơn 0 và nhỏ hơn hoặc bằng 100 (và mức giảm tối đa nếu có phải lớn hơn 0)");
            }
        }
        public decimal CalculatePercent(decimal percent , decimal maxPercent , decimal SumPrice)
        {
            return (SumPrice * percent) / 100;
        }
        public decimal KeepMaxPrice (decimal maxMoney , )
        public decimal PercentDiscount(decimal SumPrice)
        {
            return 0;
        }
    }
}
