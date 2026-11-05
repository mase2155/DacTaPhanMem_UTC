/**
 * Cam bien CAN trong luong quan ao (bo sung theo de thuc hanh).
 */
public class WeightSensor implements Colleague {

	private MachineMediator mediator;

	public void measure(int kg) {
		System.out.println("[Can] Trong luong quan ao: " + kg + " kg");
		if (mediator != null) {
			mediator.onClothesWeightMeasured(kg);
		}
	}

	@Override
	public void setMediator(MachineMediator mediator) {
		this.mediator = mediator;
	}
}
