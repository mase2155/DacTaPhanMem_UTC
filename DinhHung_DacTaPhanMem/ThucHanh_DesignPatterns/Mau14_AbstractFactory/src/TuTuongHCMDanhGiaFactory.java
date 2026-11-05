public class TuTuongHCMDanhGiaFactory implements AbstractDanhGiaFactory {

	@Override
	public BaoCaoEvaluator createTracNghiemEvaluator() {
		return noiDung -> "[TTHCM/Quiz] Trac nghiem ly thuyet (trong so cao) -> 8.5/10";
	}

	@Override
	public BaoCaoEvaluator createCodeEvaluator() {
		return noiDung -> "[TTHCM/Code] Khong ap dung — nop bai luan thay the";
	}

	@Override
	public BaoCaoEvaluator createLuanEvaluator() {
		return noiDung -> "[TTHCM/Luan] Cham bai luan tu tuong: " + noiDung + " -> 9.5/10";
	}

	@Override
	public String getTenHocPhan() {
		return "Tu tuong Ho Chi Minh";
	}
}
