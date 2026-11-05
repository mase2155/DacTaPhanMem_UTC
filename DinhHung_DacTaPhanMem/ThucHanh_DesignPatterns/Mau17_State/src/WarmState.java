/** Trang thai Warm: giu nong — khong walk; co the cook hoac off. */
public class WarmState implements RoboticState {

	@Override
	public void walk(Robot robot) {
		System.out.println("Warm: KHONG duoc walk (theo de thuc hanh).");
	}

	@Override
	public void cook(Robot robot) {
		System.out.println("Warm -> nau tiep, chuyen COOK");
		robot.setState(new CookState());
	}

	@Override
	public void keepWarm(Robot robot) {
		System.out.println("Van dang giu nong mon an.");
	}

	@Override
	public void off(Robot robot) {
		System.out.println("Warm -> OFF");
		robot.setState(new OffState());
	}

	@Override
	public String tenTrangThai() {
		return "WARM";
	}
}
