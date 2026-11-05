import java.util.HashMap;
import java.util.Map;

/** Prototype registry: mau dang ky mac dinh theo lop (chi tao mot lan). */
public class DangKyMauProvider {

	private static final Map<String, DanhSachDangKy> mauGoc = new HashMap<>();

	static {
		System.out.println("[Provider] Tao mau dang ky mac dinh cho cac lop...");
		DanhSachDangKy cntt = new DanhSachDangKy("CNTT K20");
		cntt.themHocPhan(new HocPhan("DTPM", "Dac ta phan mem"), "DANG_KY|SUA|HUY");
		cntt.themHocPhan(new HocPhan("CSDL", "Co so du lieu"), "DANG_KY|SUA");
		cntt.themHocPhan(new HocPhan("JAVA", "Lap trinh Java"), "DANG_KY");
		mauGoc.put("CNTT K20", cntt);
	}

	public static DanhSachDangKy layBanSao(String tenLop) {
		DanhSachDangKy goc = mauGoc.get(tenLop);
		if (goc == null) {
			return null;
		}
		System.out.println("[Provider] Deep clone mau dang ky cho lop " + tenLop);
		return goc.deepClone();
	}
}
