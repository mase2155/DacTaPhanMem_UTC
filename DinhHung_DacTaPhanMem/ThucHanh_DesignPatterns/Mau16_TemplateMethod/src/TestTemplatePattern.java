public class TestTemplatePattern {

	public static void main(String[] args) {
		System.out.println("--- Form Sinh vien ---");
		FormInsertTemplate form = new FormNhapSinhVien();
		form.nhapBanGhiMoi();

		System.out.println("--- Form San pham ---");
		form = new FormNhapSanPham();
		form.nhapBanGhiMoi();
	}
}
