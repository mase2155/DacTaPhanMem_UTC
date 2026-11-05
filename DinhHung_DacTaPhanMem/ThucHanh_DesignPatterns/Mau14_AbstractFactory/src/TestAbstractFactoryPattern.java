public class TestAbstractFactoryPattern {

	public static void main(String[] args) {
		AbstractDanhGiaFactory factory = DanhGiaFactoryProducer.getFactory("DTPM");
		TuanDanhGiaService service = new TuanDanhGiaService(factory);
		service.chamTuan("Nguyen Van An");

		factory = DanhGiaFactoryProducer.getFactory("TTHCM");
		service = new TuanDanhGiaService(factory);
		service.chamTuan("Tran Thi Binh");
	}
}
