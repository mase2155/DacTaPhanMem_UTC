/** Flyweight: nen tang Python (chi tao mot lan trong factory). */
public class PythonPlatform implements Platform {

	public PythonPlatform() {
		System.out.println("[Flyweight] Tao MOI doi tuong PythonPlatform (mot lan duy nhat)");
	}

	@Override
	public void execute(Code code) {
		System.out.println("  Dich/chay ma Python: " + code.getSource());
	}
}
