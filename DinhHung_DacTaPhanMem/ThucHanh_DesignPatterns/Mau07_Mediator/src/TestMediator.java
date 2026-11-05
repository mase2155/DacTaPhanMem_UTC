public class TestMediator {

	public static void main(String[] args) {
		WeightSensor can = new WeightSensor();
		Valve valve = new Valve();
		Heater heater = new Heater();
		Motor motor = new Motor();
		Button button = new Button();

		WashingMediator mediator = new WashingMediator(can, valve, heater, motor);

		can.setMediator(mediator);
		valve.setMediator(mediator);
		heater.setMediator(mediator);
		button.setMediator(mediator);

		button.press();

		System.out.println("--- Lan giat 2: quan ao nang hon ---");
		can.setMediator(mediator);
		valve.setMediator(mediator);
		heater.setMediator(mediator);
		can.measure(6);
	}
}
