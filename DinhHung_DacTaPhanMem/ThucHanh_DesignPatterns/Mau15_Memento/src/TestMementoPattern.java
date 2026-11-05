public class TestMementoPattern {

	public static void main(String[] args) {
		CareTaker careTaker = new CareTaker();
		CodeEditor editor = new CodeEditor("void main() { print('v1'); }", careTaker);

		System.out.println(editor);
		System.out.println("--- Thu phuong an 2 ---");
		editor.setCode("void main() { new Adapter(); }");
		editor.createSavepoint("PHUONG_AN_2");

		System.out.println(editor);
		System.out.println("--- Thu phuong an 3 (that bai) ---");
		editor.setCode("void main() { broken syntax !!!");
		System.out.println(editor);

		System.out.println("--- Quay lai PHUONG_AN_2 ---");
		editor.restore("PHUONG_AN_2");
		System.out.println(editor);

		System.out.println("--- Quay lai BAN_DAU ---");
		editor.restore("BAN_DAU");
		System.out.println(editor);
	}
}
