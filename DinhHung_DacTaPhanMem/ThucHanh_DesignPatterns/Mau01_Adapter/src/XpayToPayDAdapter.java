/**
 * Adapter: chuyen XPay (ho dem + ten) sang PayD (ho ten day du).
 */
public class XpayToPayDAdapter implements PayD {

	private String custCardNo;
	private String cardOwnerName;
	private String cardExpMonthDate;
	private Integer cVVNo;
	private Double totalAmount;

	private final Xpay xpay;

	public XpayToPayDAdapter(Xpay xpay) {
		this.xpay = xpay;
		copyFromXpay();
	}

	@Override
	public String getCustCardNo() {
		return custCardNo;
	}

	@Override
	public String getCardOwnerName() {
		return cardOwnerName;
	}

	@Override
	public String getCardExpMonthDate() {
		return cardExpMonthDate;
	}

	@Override
	public Integer getCVVNo() {
		return cVVNo;
	}

	@Override
	public Double getTotalAmount() {
		return totalAmount;
	}

	@Override
	public void setCustCardNo(String custCardNo) {
		this.custCardNo = custCardNo;
	}

	@Override
	public void setCardOwnerName(String cardOwnerName) {
		this.cardOwnerName = cardOwnerName;
	}

	@Override
	public void setCardExpMonthDate(String cardExpMonthDate) {
		this.cardExpMonthDate = cardExpMonthDate;
	}

	@Override
	public void setCVVNo(Integer cVVNo) {
		this.cVVNo = cVVNo;
	}

	@Override
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	private void copyFromXpay() {
		setCardOwnerName(buildFullName(xpay.getHoDem(), xpay.getTen()));
		setCustCardNo(xpay.getCreditCardNo());
		setCardExpMonthDate(xpay.getCardExpMonth() + "/" + xpay.getCardExpYear());
		setCVVNo(xpay.getCardCVVNo().intValue());
		setTotalAmount(xpay.getAmount());
	}

	static String buildFullName(String hoDem, String ten) {
		String h = hoDem == null ? "" : hoDem.trim();
		String t = ten == null ? "" : ten.trim();
		if (h.isEmpty()) {
			return t;
		}
		if (t.isEmpty()) {
			return h;
		}
		return h + " " + t;
	}
}
