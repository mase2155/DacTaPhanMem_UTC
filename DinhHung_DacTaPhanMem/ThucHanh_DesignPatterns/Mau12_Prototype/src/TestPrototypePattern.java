public class TestPrototypePattern {

	public static void main(String[] args) {
		DanhSachDangKy mauSV1 = DangKyMauProvider.layBanSao("CNTT K20");
		DanhSachDangKy mauSV2 = DangKyMauProvider.layBanSao("CNTT K20");

		SinhVienDangKy svAn = new SinhVienDangKy("Nguyen Van An", mauSV1);
		SinhVienDangKy svBinh = new SinhVienDangKy("Tran Thi Binh", mauSV2);

		System.out.println("=== Truoc khi Binh them mon tu chon ===");
		System.out.println(svAn);
		System.out.println(svBinh);

		svBinh.getDanhSach().themMonTuChon(
				new HocPhan("TA", "Tieng Anh chuyen nganh"), "DANG_KY");

		System.out.println("=== Sau khi Binh them mon (An khong doi) ===");
		System.out.println(svAn);
		System.out.println(svBinh);
	}
}
