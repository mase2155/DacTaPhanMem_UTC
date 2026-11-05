/** Buoc dau: tiep nhan, xep hang doi, chuyen vao day chain. */
public class TiepNhanHandler extends AbstractHandler {

	public TiepNhanHandler() {
		super("Quay tiep nhan mot cua");
	}

	@Override
	public void handle(ServiceRequest request) {
		System.out.println("[" + tenBoPhan + "] Nhan ho so: " + request.getMoTa());
		System.out.println("  Xep vao hang doi...");
		chuyenTiep(request);
	}
}
