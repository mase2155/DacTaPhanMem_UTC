/** Mon hoc / hoc phan (khoa trong HashTable quyen). */
public class HocPhan implements Cloneable {

	private final String ma;
	private final String ten;

	public HocPhan(String ma, String ten) {
		this.ma = ma;
		this.ten = ten;
	}

	public String getMa() {
		return ma;
	}

	public String getTen() {
		return ten;
	}

	public HocPhan copy() {
		return new HocPhan(ma, ten);
	}

	@Override
	public String toString() {
		return ma + " - " + ten;
	}
}
