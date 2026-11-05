public class TestBridgePattern {

	public static void main(String[] args) {
		Product khoaTrungTam = new CentralLocking("Khoa trung tam");
		Product khoaBanhrang = new GearLocking("Khoa banh rang");

		System.out.println("=== O TO TAI + khoa trung tam ===");
		Car xe = new Truck(khoaTrungTam, "Howo 8 tan");
		xe.produceProduct();
		xe.assemble();
		xe.printDetails();

		System.out.println();

		System.out.println("=== O TO TAI + khoa banh rang ===");
		xe = new Truck(khoaBanhrang, "Howo 8 tan");
		xe.produceProduct();
		xe.assemble();
		xe.printDetails();

		System.out.println("-----------------------------------------------------");

		System.out.println("=== Xe con + khoa trung tam ===");
		xe = new Motoren(khoaTrungTam, "Motoren LM");
		xe.produceProduct();
		xe.assemble();
		xe.printDetails();
	}
}
