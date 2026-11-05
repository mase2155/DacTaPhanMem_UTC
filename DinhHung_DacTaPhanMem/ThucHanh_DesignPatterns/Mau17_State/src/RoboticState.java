public interface RoboticState {

	void walk(Robot robot);

	void cook(Robot robot);

	void keepWarm(Robot robot);

	void off(Robot robot);

	String tenTrangThai();
}
