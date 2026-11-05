public class SinhVienDangKy {

	private final String hoTen;
	private final DanhSachDangKy danhSach;

	public SinhVienDangKy(String hoTen, DanhSachDangKy danhSach) {
		this.hoTen = hoTen;
		this.danhSach = danhSach;
	}

	public DanhSachDangKy getDanhSach() {
		return danhSach;
	}

	@Override
	public String toString() {
		return "SV: " + hoTen + "\n" + danhSach;
	}
}
