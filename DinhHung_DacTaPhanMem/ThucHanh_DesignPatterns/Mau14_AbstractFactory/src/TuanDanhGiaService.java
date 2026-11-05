/** Su dung Abstract Factory de cham ca 3 loai bai trong tuan. */
public class TuanDanhGiaService {

	private final AbstractDanhGiaFactory factory;

	public TuanDanhGiaService(AbstractDanhGiaFactory factory) {
		this.factory = factory;
	}

	public void chamTuan(String tenSV) {
		System.out.println("=== Hoc phan: " + factory.getTenHocPhan() + " | SV: " + tenSV + " ===");
		System.out.println(factory.createTracNghiemEvaluator().danhGia("Quiz tuan"));
		System.out.println(factory.createCodeEvaluator().danhGia("Bai code tuan"));
		System.out.println(factory.createLuanEvaluator().danhGia("Bai luan tuan"));
		System.out.println();
	}
}
