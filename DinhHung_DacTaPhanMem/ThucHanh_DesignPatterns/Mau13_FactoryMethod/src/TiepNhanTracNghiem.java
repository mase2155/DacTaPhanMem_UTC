public class TiepNhanTracNghiem extends TiepNhanBaoCao {

	@Override
	protected BaoCaoEvaluator taoBoDanhGia() {
		return new TracNghiemEvaluator();
	}
}
