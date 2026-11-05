public class CookState implements RoboticState {

	@Override
	public void walk(Robot robot) {
		System.out.println("Dang nau — khong di lai duoc.");
	}

	@Override
	public void cook(Robot robot) {
		System.out.println("Tiep tuc nau mon...");
	}

	@Override
	public void keepWarm(Robot robot) {
		System.out.println("Chuyen sang GIU NONG (Warm)...");
		robot.setState(new WarmState());
	}

	@Override
	public void off(Robot robot) {
		System.out.println("Khong tat khi dang nau.");
	}

	@Override
	public String tenTrangThai() {
		return "COOK";
	}
}
