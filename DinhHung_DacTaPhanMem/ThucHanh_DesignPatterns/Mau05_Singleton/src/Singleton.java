/**
 * Chi mot doi tuong ket noi CSDL cho ca ung dung (Singleton).
 */
public class Singleton {

	private static Singleton instance;

	private final String connectionInfo;

	private Singleton() {
		connectionInfo = "jdbc:sqlserver://localhost;database=AppDB";
		System.out.println("[Singleton] Tao MOT ket noi CSDL duy nhat.");
	}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	public String getConnectionInfo() {
		return connectionInfo;
	}

	public void query(String sql) {
		System.out.println("[Query tren ket noi duy nhat] " + sql);
	}
}
