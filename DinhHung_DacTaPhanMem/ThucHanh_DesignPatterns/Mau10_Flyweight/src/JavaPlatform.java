public class JavaPlatform implements Platform {

	public JavaPlatform() {
		System.out.println("[Flyweight] Tao MOI doi tuong JavaPlatform");
	}

	@Override
	public void execute(Code code) {
		System.out.println("  Bien dich Java: " + code.getSource());
	}
}
