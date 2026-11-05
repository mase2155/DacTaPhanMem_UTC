public class TestObserver {

	public static void main(String[] args) {
		HocPhan mon = new HocPhan("Dac ta phan mem - HK1");

		Observer sv1 = new SinhVienObserver(mon, "Nguyen Van An");
		Observer sv2 = new SinhVienObserver(mon, "Tran Thi Binh");

		sv1.subscribe();
		sv2.subscribe();

		mon.setMessage("Lich hoc tuan 10: thuc hanh Design Patterns");
		mon.setMessage("Cap nhat: nop bao cao truoc buoi 8");

		sv2.unSubscribe();

		mon.setMessage("Cong bo diem thi giua ky - An: 8.0, Binh: (khong gui vi da huy DK)");

		Observer sv3 = new SinhVienObserver(mon, "Le Van Cuong");
		sv3.subscribe();

		mon.setMessage("Diem thi Cuong: 7.5");
	}
}
