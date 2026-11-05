/**
 * Abstract Factory: bo san pham danh gia theo tung hoc phan.
 */
public interface AbstractDanhGiaFactory {

	BaoCaoEvaluator createTracNghiemEvaluator();

	BaoCaoEvaluator createCodeEvaluator();

	BaoCaoEvaluator createLuanEvaluator();

	String getTenHocPhan();
}
