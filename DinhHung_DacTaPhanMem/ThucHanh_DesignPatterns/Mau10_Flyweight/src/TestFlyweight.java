public class TestFlyweight {

	public static void main(String[] args) {
		Code code = new Code();

		System.out.println("=== Lan 1: dich Python ===");
		code.setSource("print('Hello Python')");
		Platform py1 = PlatformFactory.getPlatformInstance("PYTHON");
		py1.execute(code);
		System.out.println("  instance hash: " + System.identityHashCode(py1));

		System.out.println("\n=== Lan 2: dich Python (cung nen tang) ===");
		code.setSource("print('Lan 2')");
		Platform py2 = PlatformFactory.getPlatformInstance("PYTHON");
		py2.execute(code);
		System.out.println("  instance hash: " + System.identityHashCode(py2));
		System.out.println("  py1 == py2: " + (py1 == py2));

		System.out.println("\n=== Java (nen tang khac) ===");
		code.setSource("System.out.println(\"Hi\");");
		Platform java = PlatformFactory.getPlatformInstance("JAVA");
		java.execute(code);
	}
}
