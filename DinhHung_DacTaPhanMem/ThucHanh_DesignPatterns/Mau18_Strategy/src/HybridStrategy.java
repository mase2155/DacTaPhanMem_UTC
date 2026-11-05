public class HybridStrategy implements DesignStrategy {

	@Override
	public void thietKe(String tenDuAn) {
		System.out.println("[Hybrid] " + tenDuAn + ": ket hop top-down (kien truc) + bottom-up (tung module).");
	}
}
