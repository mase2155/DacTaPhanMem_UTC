public class DatDaiHandler extends AbstractHandler {

	public DatDaiHandler() {
		super("Phong Dat dai");
	}

	@Override
	public void handle(ServiceRequest request) {
		if ("DATDAI".equalsIgnoreCase(request.getLoai())) {
			System.out.println("[" + tenBoPhan + "] XU LY: cap so do / chuyen nhuong dat.");
			System.out.println("  Ket qua: Hen tra ho so ngay 20/12.");
		} else {
			System.out.println("[" + tenBoPhan + "] Khong thuoc trach nhiem.");
			chuyenTiep(request);
		}
	}
}
