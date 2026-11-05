public class ThueHandler extends AbstractHandler {

	public ThueHandler() {
		super("Phong Thue");
	}

	@Override
	public void handle(ServiceRequest request) {
		if ("THUE".equalsIgnoreCase(request.getLoai())) {
			System.out.println("[" + tenBoPhan + "] XU LY: khai thue / mien giam.");
			System.out.println("  Ket qua: Da ghi nhan to khai.");
		} else {
			System.out.println("[" + tenBoPhan + "] Khong thuoc trach nhiem.");
			chuyenTiep(request);
		}
	}
}
