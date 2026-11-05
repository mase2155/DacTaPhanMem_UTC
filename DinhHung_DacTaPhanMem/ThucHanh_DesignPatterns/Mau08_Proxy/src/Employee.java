public class Employee implements Staff {

	private ReportGeneratorProxy proxy;

	@Override
	public boolean isOwner() {
		return false;
	}

	@Override
	public void setReportGenerator(ReportGeneratorProxy proxy) {
		this.proxy = proxy;
	}

	public String generateDailyReport() {
		return proxy.generateDailyReport();
	}
}
