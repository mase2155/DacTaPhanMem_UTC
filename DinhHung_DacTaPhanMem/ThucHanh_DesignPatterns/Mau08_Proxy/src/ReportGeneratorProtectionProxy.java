/**
 * Protection Proxy: chi Owner duoc xem bao cao.
 */
public class ReportGeneratorProtectionProxy implements ReportGeneratorProxy {

	private final Staff staff;
	private final ReportGenerator realService;

	public ReportGeneratorProtectionProxy(Staff staff) {
		this.staff = staff;
		this.realService = new ReportGeneratorImpl();
	}

	@Override
	public String generateDailyReport() {
		if (staff.isOwner()) {
			return realService.generateDailyReport();
		}
		return "Not Authorized to view report.";
	}
}
