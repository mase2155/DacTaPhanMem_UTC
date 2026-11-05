public class HoKhauHandler extends AbstractHandler {

	public HoKhauHandler() {
		super("Phong Ho khau");
	}

	@Override
	public void handle(ServiceRequest request) {
		if ("HOKHAU".equalsIgnoreCase(request.getLoai())) {
			System.out.println("[" + tenBoPhan + "] XU LY: cap giay tam tru / ho khau.");
			System.out.println("  Ket qua: Da cap nhan xet, tra ket qua trong 3 ngay.");
		} else {
			System.out.println("[" + tenBoPhan + "] Khong thuoc trach nhiem.");
			chuyenTiep(request);
		}
	}
}
