public class FormNhapSinhVien extends FormInsertTemplate {

	@Override
	protected void moBang() {
		System.out.println("[4] Mo bang SinhVien");
	}

	@Override
	protected void taoBanGhiMoi() {
		System.out.println("[5] Nhap: maSV, hoTen, lop, email...");
	}
}
