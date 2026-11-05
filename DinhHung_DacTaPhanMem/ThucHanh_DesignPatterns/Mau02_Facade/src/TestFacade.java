public class TestFacade {

	public static void main(String[] args) {
		ScheduleServer scheduleServer = new ScheduleServer();
		ScheduleServerFacade facade = new ScheduleServerFacade(scheduleServer);

		System.out.println("=== Dung Facade: startServer() ===");
		facade.startServer();

		System.out.println("Start working......");
		System.out.println("After work done.........");

		System.out.println("=== Dung Facade: stopServer() ===");
		facade.stopServer();
		System.out.println("=== Ket thuc ===");
	}
}
