public class Valve implements Colleague {

	private MachineMediator mediator;

	public void openFill(int liters) {
		System.out.println("[Van] Mo van, bom " + liters + " lit nuoc...");
		System.out.println("[Van] Dong van.");
		if (mediator != null) {
			mediator.startHeating(40);
		}
	}

	@Override
	public void setMediator(MachineMediator mediator) {
		this.mediator = mediator;
	}
}
