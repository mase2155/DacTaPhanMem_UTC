import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Danh sach hoc phan mac dinh cua lop — clone sau (deep) cho tung sinh vien.
 */
public class DanhSachDangKy implements Prototype {

	private final String tenLop;
	private final List<HocPhan> hocPhanList;
	private final HashMap<HocPhan, String> thaoTacTheoMon;

	public DanhSachDangKy(String tenLop) {
		this.tenLop = tenLop;
		this.hocPhanList = new ArrayList<>();
		this.thaoTacTheoMon = new HashMap<>();
	}

	public void themHocPhan(HocPhan hp, String thaoTac) {
		hocPhanList.add(hp);
		thaoTacTheoMon.put(hp, thaoTac);
	}

	public void themMonTuChon(HocPhan hp, String thaoTac) {
		hocPhanList.add(hp);
		thaoTacTheoMon.put(hp, thaoTac);
	}

	public String getTenLop() {
		return tenLop;
	}

	public List<HocPhan> getHocPhanList() {
		return hocPhanList;
	}

	@Override
	public DanhSachDangKy deepClone() {
		DanhSachDangKy copy = new DanhSachDangKy(tenLop);
		HashMap<HocPhan, HocPhan> oldToNew = new HashMap<>();
		for (HocPhan hp : hocPhanList) {
			HocPhan hpCopy = hp.copy();
			oldToNew.put(hp, hpCopy);
			copy.hocPhanList.add(hpCopy);
		}
		for (Map.Entry<HocPhan, String> e : thaoTacTheoMon.entrySet()) {
			HocPhan keyCopy = oldToNew.get(e.getKey());
			copy.thaoTacTheoMon.put(keyCopy, e.getValue());
		}
		return copy;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Lop " + tenLop + " | So mon: " + hocPhanList.size() + "\n");
		for (HocPhan hp : hocPhanList) {
			sb.append("  - ").append(hp).append(" [").append(thaoTacTheoMon.get(hp)).append("]\n");
		}
		return sb.toString();
	}
}
