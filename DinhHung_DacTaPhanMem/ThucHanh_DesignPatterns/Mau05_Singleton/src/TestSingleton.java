public class TestSingleton {

	public static void main(String[] args) {
		System.out.println("=== Kiem tra Singleton (Database) ===");

		Singleton db1 = Singleton.getInstance();
		Singleton db2 = Singleton.getInstance();

		System.out.println("db1 == db2: " + (db1 == db2));
		System.out.println("Connection: " + db1.getConnectionInfo());

		db1.query("SELECT * FROM SinhVien");
		db2.query("SELECT COUNT(*) FROM Lop");

		System.out.println("=== Chi co mot instance — lan goi getInstance() sau khong tao moi ===");
		Singleton db3 = Singleton.getInstance();
		System.out.println("db3 == db1: " + (db3 == db1));
	}
}
