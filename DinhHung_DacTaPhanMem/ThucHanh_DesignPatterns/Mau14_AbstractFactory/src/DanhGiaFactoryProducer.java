public final class DanhGiaFactoryProducer {

	private DanhGiaFactoryProducer() {
	}

	public static AbstractDanhGiaFactory getFactory(String loaiMon) {
		switch (loaiMon) {
			case "DTPM":
				return new DacTaPhanMemDanhGiaFactory();
			case "TTHCM":
				return new TuTuongHCMDanhGiaFactory();
			default:
				throw new IllegalArgumentException("Chua co factory: " + loaiMon);
		}
	}
}
