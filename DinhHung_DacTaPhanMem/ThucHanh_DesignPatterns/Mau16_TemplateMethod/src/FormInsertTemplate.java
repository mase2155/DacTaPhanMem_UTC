/**
 * Template Method: khung nhap mot ban ghi moi vao bang.
 */
public abstract class FormInsertTemplate {

	public final void nhapBanGhiMoi() {
		ketNoiCSDL();
		xacThucNguoiDung();
		moPhien();
		moBang();
		taoBanGhiMoi();
		insertVaCommit();
		dongPhien();
		dongCSDL();
		inThanhCong();
	}

	protected void ketNoiCSDL() {
		System.out.println("[1] Ket noi co so du lieu...");
	}

	protected void xacThucNguoiDung() {
		System.out.println("[2] Xac thuc nguoi dung (mac dinh: OK)");
	}

	protected void moPhien() {
		System.out.println("[3] Mo phien lam viec...");
	}

	protected abstract void moBang();

	protected abstract void taoBanGhiMoi();

	protected void insertVaCommit() {
		System.out.println("[6] INSERT vao bang + COMMIT");
	}

	protected void dongPhien() {
		System.out.println("[7] Dong phien");
	}

	protected void dongCSDL() {
		System.out.println("[8] Dong ket noi CSDL");
	}

	protected void inThanhCong() {
		System.out.println("=== Hoan tat nhap ban ghi ===\n");
	}
}
