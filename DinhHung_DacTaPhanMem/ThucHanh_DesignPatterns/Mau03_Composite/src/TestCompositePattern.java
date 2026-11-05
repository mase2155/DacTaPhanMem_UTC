public class TestCompositePattern {

	public static void main(String[] args) {
		Contact sv1 = new IndividualContact("An", "an@sv.edu.vn");
		Contact sv2 = new IndividualContact("Binh", "binh@sv.edu.vn");
		Contact gv = new IndividualContact("Co Lan", "lan@gv.edu.vn");

		GroupContact lopCntt = new GroupContact("Lop CNTT K20");
		lopCntt.add(sv1);
		lopCntt.add(sv2);

		GroupContact lopGv = new GroupContact("Giao vien phu trach");
		lopGv.add(gv);

		GroupContact toanLop = new GroupContact("Thong bao toan lop");
		toanLop.add(lopCntt);
		toanLop.add(lopGv);

		System.out.println("--- Gui cho mot ca nhan ---");
		sv1.sendMail("Diem thi", "Ban dat 8.5 diem");

		System.out.println("--- Gui cho ca nhom (composite) ---");
		toanLop.sendMail("Lich thi Dac ta PM", "Thi vao tuan 15, phong A1");
	}
}
