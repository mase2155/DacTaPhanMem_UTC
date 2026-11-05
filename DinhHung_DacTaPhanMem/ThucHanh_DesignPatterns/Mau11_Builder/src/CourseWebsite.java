/** San pham: website mon hoc. */
public class CourseWebsite {

	private final String tenMon;
	private String deCuong;
	private String baiGiang;
	private String thucHanh;
	private String baiTap;
	private String danhGia;

	public CourseWebsite(String tenMon) {
		this.tenMon = tenMon;
	}

	public void setDeCuong(String deCuong) {
		this.deCuong = deCuong;
	}

	public void setBaiGiang(String baiGiang) {
		this.baiGiang = baiGiang;
	}

	public void setThucHanh(String thucHanh) {
		this.thucHanh = thucHanh;
	}

	public void setBaiTap(String baiTap) {
		this.baiTap = baiTap;
	}

	public void setDanhGia(String danhGia) {
		this.danhGia = danhGia;
	}

	@Override
	public String toString() {
		return "=== Website: " + tenMon + " ===\n"
				+ "De cuong: " + deCuong + "\n"
				+ "Bai giang: " + baiGiang + "\n"
				+ "Thuc hanh: " + thucHanh + "\n"
				+ "Bai tap: " + baiTap + "\n"
				+ "Danh gia: " + danhGia;
	}
}
