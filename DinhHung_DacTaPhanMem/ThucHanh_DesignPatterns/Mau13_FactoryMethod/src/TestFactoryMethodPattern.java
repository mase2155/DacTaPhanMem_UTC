public class TestFactoryMethodPattern {

	public static void main(String[] args) {
		TiepNhanBaoCao tiepNhan;

		tiepNhan = new TiepNhanTracNghiem();
		tiepNhan.xuLy("SV An", "Bai quiz tuan 5 (20 cau)");

		System.out.println();

		tiepNhan = new TiepNhanCode();
		tiepNhan.xuLy("SV Binh", "Nop project Adapter.java");

		System.out.println();

		tiepNhan = new TiepNhanLuan();
		tiepNhan.xuLy("SV Cuong", "Bai luan Design Patterns");
	}
}
