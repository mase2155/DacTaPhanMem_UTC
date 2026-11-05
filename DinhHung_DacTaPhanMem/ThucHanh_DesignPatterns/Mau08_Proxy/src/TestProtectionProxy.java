public class TestProtectionProxy {

	public static void main(String[] args) {
		Owner owner = new Owner();
		owner.setReportGenerator(new ReportGeneratorProtectionProxy(owner));

		Employee employee = new Employee();
		employee.setReportGenerator(new ReportGeneratorProtectionProxy(employee));

		System.out.println("=== Owner (co quyen) ===");
		System.out.println(owner.generateDailyReport());

		System.out.println();

		System.out.println("=== Employee (khong co quyen) ===");
		System.out.println(employee.generateDailyReport());
	}
}
