public class Robot {

	private RoboticState state = new OffState();

	public void setState(RoboticState state) {
		this.state = state;
		System.out.println(">> Trang thai hien tai: " + this.state.tenTrangThai());
	}

	public void walk() {
		state.walk(this);
	}

	public void cook() {
		state.cook(this);
	}

	public void keepWarm() {
		state.keepWarm(this);
	}

	public void off() {
		state.off(this);
	}
}
