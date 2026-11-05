public class Button implements Colleague {

	private MachineMediator mediator;

	public void press() {
		System.out.println("[Nut] Bam START");
		if (mediator != null) {
			mediator.startCycle();
		}
	}

	@Override
	public void setMediator(MachineMediator mediator) {
		this.mediator = mediator;
	}
}
