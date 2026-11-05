public class TestStrategyPattern {

	public static void main(String[] args) {
		DesignTeam team = new DesignTeam();
		String duAn = "He thong dang ky hoc phan";

		team.setStrategy(new TopDownStrategy());
		team.thucHienThietKe(duAn);

		System.out.println();

		team.setStrategy(new BottomUpStrategy());
		team.thucHienThietKe(duAn);

		System.out.println();

		team.setStrategy(new HybridStrategy());
		team.thucHienThietKe(duAn);
	}
}
