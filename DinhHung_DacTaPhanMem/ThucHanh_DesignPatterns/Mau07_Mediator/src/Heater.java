public class Heater implements Colleague {

	private MachineMediator mediator;

	public void heatTo(int tempC) {
		System.out.println("[Suoi] Dun nuoc den " + tempC + " do C");
		if (mediator != null) {
			mediator.startWashing();
		}
	}

	@Override
	public void setMediator(MachineMediator mediator) {
		this.mediator = mediator;
	}
}
