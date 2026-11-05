import java.util.HashMap;
import java.util.Map;

public class CareTaker {

	private final Map<String, CodeMemento> savepoints = new HashMap<>();

	public void save(CodeMemento memento, String name) {
		System.out.println("Luu phuong an: " + name);
		savepoints.put(name, memento);
	}

	public CodeMemento get(String name) {
		System.out.println("Khoi phuc tu: " + name);
		return savepoints.get(name);
	}

	public void clear() {
		savepoints.clear();
	}
}
