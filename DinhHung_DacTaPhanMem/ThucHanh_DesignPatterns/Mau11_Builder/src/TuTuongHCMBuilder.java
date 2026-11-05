public class TuTuongHCMBuilder implements CourseWebsiteBuilder {

	private final CourseWebsite website = new CourseWebsite("Tu tuong Ho Chi Minh");

	@Override
	public void buildDeCuong() {
		website.setDeCuong("He thong tu tuong, dao duc, phong cach HCM");
	}

	@Override
	public void buildBaiGiang() {
		website.setBaiGiang("Bai 1-5: khai niem, noi dung tu tuong HCM");
	}

	@Override
	public void buildThucHanh() {
		website.setThucHanh("Seminar, thao luan tinh huong");
	}

	@Override
	public void buildBaiTap() {
		website.setBaiTap("Bai luan ngan, trac nghiem");
	}

	@Override
	public void buildDanhGia() {
		website.setDanhGia("Diem TP + thi ket thuc hoc phan");
	}

	@Override
	public CourseWebsite getWebsite() {
		return website;
	}
}
