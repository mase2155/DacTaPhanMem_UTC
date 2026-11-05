/** Ho so yeu cau dich vu cong (mot cua). */
public class ServiceRequest {

	private final String loai;
	private final String moTa;

	public ServiceRequest(String loai, String moTa) {
		this.loai = loai;
		this.moTa = moTa;
	}

	public String getLoai() {
		return loai;
	}

	public String getMoTa() {
		return moTa;
	}
}
