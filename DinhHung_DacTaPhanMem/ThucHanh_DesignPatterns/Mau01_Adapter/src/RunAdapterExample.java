public class RunAdapterExample {

	public static void main(String[] args) {
		Xpay xpay = new XpayImpl();
		xpay.setCreditCardNo("4789565874102365");
		xpay.setHoDem("Nguyen Van");
		xpay.setTen("An");
		xpay.setCardExpMonth("09");
		xpay.setCardExpYear("25");
		xpay.setCardCVVNo((short) 235);
		xpay.setAmount(2565.23);

		System.out.println("=== He thong thanh toan PayD (qua Adapter) ===");
		System.out.println("XPay - Ho dem: " + xpay.getHoDem() + " | Ten: " + xpay.getTen());

		PayD payD = new XpayToPayDAdapter(xpay);
		testPayD(payD);
	}

	private static void testPayD(PayD payD) {
		System.out.println("PayD - Ho ten chu the: " + payD.getCardOwnerName());
		System.out.println("So the: " + payD.getCustCardNo());
		System.out.println("Het han: " + payD.getCardExpMonthDate());
		System.out.println("CVV: " + payD.getCVVNo());
		System.out.println("So tien: " + payD.getTotalAmount());
		System.out.println("=== Thanh toan PayD hoat dong OK ===");
	}
}
