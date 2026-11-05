public class FormNhapSanPham extends FormInsertTemplate {

	@Override
	protected void xacThucNguoiDung() {
		System.out.println("[2] Xac thuc quyen ADMIN (San pham)");
	}

	@Override
	protected void moBang() {
		System.out.println("[4] Mo bang SanPham");
	}

	@Override
	protected void taoBanGhiMoi() {
		System.out.println("[5] Nhap: maSP, ten, gia, hinh anh, mo ta...");
	}
}
