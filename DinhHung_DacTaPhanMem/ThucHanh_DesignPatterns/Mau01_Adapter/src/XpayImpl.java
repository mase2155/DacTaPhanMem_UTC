public class XpayImpl implements Xpay {

	private String creditCardNo;
	private String hoDem;
	private String ten;
	private String cardExpMonth;
	private String cardExpYear;
	private Short cardCVVNo;
	private Double amount;

	@Override
	public String getCreditCardNo() {
		return creditCardNo;
	}

	@Override
	public String getHoDem() {
		return hoDem;
	}

	@Override
	public String getTen() {
		return ten;
	}

	@Override
	public String getCardExpMonth() {
		return cardExpMonth;
	}

	@Override
	public String getCardExpYear() {
		return cardExpYear;
	}

	@Override
	public Short getCardCVVNo() {
		return cardCVVNo;
	}

	@Override
	public Double getAmount() {
		return amount;
	}

	@Override
	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}

	@Override
	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	@Override
	public void setTen(String ten) {
		this.ten = ten;
	}

	@Override
	public void setCardExpMonth(String cardExpMonth) {
		this.cardExpMonth = cardExpMonth;
	}

	@Override
	public void setCardExpYear(String cardExpYear) {
		this.cardExpYear = cardExpYear;
	}

	@Override
	public void setCardCVVNo(Short cardCVVNo) {
		this.cardCVVNo = cardCVVNo;
	}

	@Override
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
