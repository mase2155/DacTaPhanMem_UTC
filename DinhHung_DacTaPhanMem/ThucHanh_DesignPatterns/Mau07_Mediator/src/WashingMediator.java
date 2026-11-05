/**
 * Mediator: dieu phoi can, van, suoi, motor — tinh muc nuoc theo kg.
 */
public class WashingMediator implements MachineMediator {

	private final WeightSensor weightSensor;
	private final Valve valve;
	private final Heater heater;
	private final Motor motor;

	public WashingMediator(WeightSensor weightSensor, Valve valve, Heater heater, Motor motor) {
		this.weightSensor = weightSensor;
		this.valve = valve;
		this.heater = heater;
		this.motor = motor;
	}

	@Override
	public void startCycle() {
		System.out.println("=== Bat dau chuong trinh giat ===");
		weightSensor.measure(3);
	}

	@Override
	public void onClothesWeightMeasured(int kg) {
		int liters = kg * 5;
		System.out.println("[Mediator] Tinh muc nuoc: " + kg + " kg x 5 = " + liters + " lit");
		fillWater(liters);
	}

	@Override
	public void fillWater(int liters) {
		valve.openFill(liters);
	}

	@Override
	public void startHeating(int tempC) {
		heater.heatTo(tempC);
	}

	@Override
	public void startWashing() {
		motor.wash(700);
		System.out.println("=== Ket thuc chuong trinh giat ===\n");
	}
}
