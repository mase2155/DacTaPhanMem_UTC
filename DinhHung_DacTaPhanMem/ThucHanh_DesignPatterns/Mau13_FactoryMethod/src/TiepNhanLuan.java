public class TiepNhanLuan extends TiepNhanBaoCao {

	@Override
	protected BaoCaoEvaluator taoBoDanhGia() {
		return new LuanEvaluator();
	}
}
