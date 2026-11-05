/**
 * He thong thanh toan cu: ho dem va ten tach rieng.
 */
public interface Xpay {

	String getCreditCardNo();

	String getHoDem();

	String getTen();

	String getCardExpMonth();

	String getCardExpYear();

	Short getCardCVVNo();

	Double getAmount();

	void setCreditCardNo(String creditCardNo);

	void setHoDem(String hoDem);

	void setTen(String ten);

	void setCardExpMonth(String cardExpMonth);

	void setCardExpYear(String cardExpYear);

	void setCardCVVNo(Short cardCVVNo);

	void setAmount(Double amount);
}
