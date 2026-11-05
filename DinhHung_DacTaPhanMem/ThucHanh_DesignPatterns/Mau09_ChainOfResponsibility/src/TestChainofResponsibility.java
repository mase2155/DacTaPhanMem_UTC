public class TestChainofResponsibility {

	public static void main(String[] args) {
		Handler tiepNhan = new TiepNhanHandler();
		Handler hoKhau = new HoKhauHandler();
		Handler datDai = new DatDaiHandler();
		Handler thue = new ThueHandler();

		tiepNhan.setNext(hoKhau);
		hoKhau.setNext(datDai);
		datDai.setNext(thue);

		System.out.println("=== Ho so 1 ===");
		tiepNhan.handle(new ServiceRequest("HOKHAU", "Dang ky tam tru cho SV"));

		System.out.println("\n=== Ho so 2 ===");
		tiepNhan.handle(new ServiceRequest("DATDAI", "Cap ban sao so do"));

		System.out.println("\n=== Ho so 3 ===");
		tiepNhan.handle(new ServiceRequest("THUE", "Khai thue TNCN"));

		System.out.println("\n=== Ho so 4 (khong co bo phan nhan) ===");
		tiepNhan.handle(new ServiceRequest("XAYDUNG", "Cap phep xay dung"));
	}
}
