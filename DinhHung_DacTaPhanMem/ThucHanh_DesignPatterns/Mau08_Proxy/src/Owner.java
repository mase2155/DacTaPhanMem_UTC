public class Owner implements Staff {

	private ReportGeneratorProxy proxy;

	@Override
	public boolean isOwner() {
		return true;
	}

	@Override
	public void setReportGenerator(ReportGeneratorProxy proxy) {
		this.proxy = proxy;
	}

	public String generateDailyReport() {
		return proxy.generateDailyReport();
	}
}
