public class TiepNhanCode extends TiepNhanBaoCao {

	@Override
	protected BaoCaoEvaluator taoBoDanhGia() {
		return new CodeEvaluator();
	}
}
