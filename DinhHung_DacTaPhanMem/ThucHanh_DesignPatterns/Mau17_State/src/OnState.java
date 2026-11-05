public class OnState implements RoboticState {

	@Override
	public void walk(Robot robot) {
		System.out.println("Robot dang di lai...");
	}

	@Override
	public void cook(Robot robot) {
		System.out.println("Bat dau nau...");
		robot.setState(new CookState());
	}

	@Override
	public void keepWarm(Robot robot) {
		System.out.println("Chua co mon — can cook truoc.");
	}

	@Override
	public void off(Robot robot) {
		System.out.println("Tat robot.");
		robot.setState(new OffState());
	}

	@Override
	public String tenTrangThai() {
		return "ON";
	}
}
