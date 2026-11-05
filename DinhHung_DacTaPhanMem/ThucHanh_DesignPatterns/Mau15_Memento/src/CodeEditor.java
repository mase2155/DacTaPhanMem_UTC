/** Originator: lap trinh vien thu nghiem nhieu phien ban code. */
public class CodeEditor {

	private String code;
	private final CareTaker careTaker;
	private String lastSavepoint;

	public CodeEditor(String initialCode, CareTaker careTaker) {
		this.careTaker = careTaker;
		this.code = initialCode;
		createSavepoint("BAN_DAU");
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void createSavepoint(String name) {
		careTaker.save(new CodeMemento(code), name);
		lastSavepoint = name;
	}

	public void undoLast() {
		restore(lastSavepoint);
	}

	public void restore(String savepointName) {
		CodeMemento mem = careTaker.get(savepointName);
		if (mem != null) {
			this.code = mem.getCode();
		}
	}

	@Override
	public String toString() {
		return "Code hien tai:\n" + code;
	}
}
