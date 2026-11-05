public class OffState implements RoboticState {

	@Override
	public void walk(Robot robot) {
		System.out.println("Bat nguon va di lai...");
		robot.setState(new OnState());
	}

	@Override
	public void cook(Robot robot) {
		System.out.println("Khong nau khi dang OFF — bat may truoc.");
	}

	@Override
	public void keepWarm(Robot robot) {
		System.out.println("Khong co mon de giu nong.");
	}

	@Override
	public void off(Robot robot) {
		System.out.println("Robot da OFF.");
	}

	@Override
	public String tenTrangThai() {
		return "OFF";
	}
}
