public class TestStatePattern {

	public static void main(String[] args) {
		Robot robot = new Robot();
		System.out.println("=== Robot nau an (co Warm) ===\n");

		robot.walk();
		robot.cook();
		robot.keepWarm();
		robot.walk();
		robot.cook();
		robot.keepWarm();
		robot.off();
	}
}
