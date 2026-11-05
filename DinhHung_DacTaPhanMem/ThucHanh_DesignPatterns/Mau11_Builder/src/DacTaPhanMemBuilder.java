public class DacTaPhanMemBuilder implements CourseWebsiteBuilder {

	private final CourseWebsite website = new CourseWebsite("Dac ta phan mem");

	@Override
	public void buildDeCuong() {
		website.setDeCuong("Muc tieu mon, ERD, dac ta chuc nang, Design Patterns");
	}

	@Override
	public void buildBaiGiang() {
		website.setBaiGiang("Chuong 1-3: yeu cau, phan tich, thiet ke");
	}

	@Override
	public void buildThucHanh() {
		website.setThucHanh("18 mau thiet ke Java/BlueJ, CSDL, Form nhap lieu");
	}

	@Override
	public void buildBaiTap() {
		website.setBaiTap("Bai tap dac ta module, ve so do UML");
	}

	@Override
	public void buildDanhGia() {
		website.setDanhGia("Diem TP: thuc hanh + diem danh; Thi: bao cao ~15 trang + demo");
	}

	@Override
	public CourseWebsite getWebsite() {
		return website;
	}
}
