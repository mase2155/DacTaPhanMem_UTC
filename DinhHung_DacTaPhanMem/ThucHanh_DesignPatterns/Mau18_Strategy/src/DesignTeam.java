public class DesignTeam {

	private DesignStrategy strategy;

	public void setStrategy(DesignStrategy strategy) {
		this.strategy = strategy;
	}

	public void thucHienThietKe(String tenDuAn) {
		if (strategy == null) {
			System.out.println("Chua chon chien luoc thiet ke.");
			return;
		}
		strategy.thietKe(tenDuAn);
	}
}
