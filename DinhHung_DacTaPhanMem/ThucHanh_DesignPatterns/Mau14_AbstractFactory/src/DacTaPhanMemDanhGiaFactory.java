public class DacTaPhanMemDanhGiaFactory implements AbstractDanhGiaFactory {

	@Override
	public BaoCaoEvaluator createTracNghiemEvaluator() {
		return noiDung -> "[DTPM/Quiz] Tu dong cham UML & dac ta -> 8/10";
	}

	@Override
	public BaoCaoEvaluator createCodeEvaluator() {
		return noiDung -> "[DTPM/Code] Cham Java/BlueJ + Design Pattern: " + noiDung + " -> 7/10";
	}

	@Override
	public BaoCaoEvaluator createLuanEvaluator() {
		return noiDung -> "[DTPM/Luan] Cham so do + tai lieu: " + noiDung + " -> 9/10";
	}

	@Override
	public String getTenHocPhan() {
		return "Dac ta phan mem";
	}
}
