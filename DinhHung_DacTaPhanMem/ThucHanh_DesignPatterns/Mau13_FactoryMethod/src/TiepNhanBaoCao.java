/**
 * Creator: tiep nhan bao cao SV, factory method tao bo cham tuong ung.
 */
public abstract class TiepNhanBaoCao {

	public void xuLy(String tenSV, String noiDung) {
		System.out.println("Tiep nhan tu " + tenSV + "...");
		BaoCaoEvaluator evaluator = taoBoDanhGia();
		String ketQua = evaluator.danhGia(noiDung);
		System.out.println(ketQua);
	}

	protected abstract BaoCaoEvaluator taoBoDanhGia();
}
