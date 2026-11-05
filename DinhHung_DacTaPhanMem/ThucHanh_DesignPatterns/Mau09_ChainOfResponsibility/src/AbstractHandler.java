public abstract class AbstractHandler implements Handler {

	protected Handler next;
	protected final String tenBoPhan;

	protected AbstractHandler(String tenBoPhan) {
		this.tenBoPhan = tenBoPhan;
	}

	@Override
	public void setNext(Handler next) {
		this.next = next;
	}

	@Override
	public String getTenBoPhan() {
		return tenBoPhan;
	}

	protected void chuyenTiep(ServiceRequest request) {
		if (next != null) {
			System.out.println("  -> Chuyen tiep den " + next.getTenBoPhan());
			next.handle(request);
		} else {
			System.out.println("  -> Khong bo phan nao xu ly duoc ho so.");
		}
	}
}
