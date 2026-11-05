/** Observer: sinh vien nhan thong bao tu hoc phan. */
public class SinhVienObserver implements Observer {

	private final Subject subject;
	private final String hoTen;

	public SinhVienObserver(Subject subject, String hoTen) {
		if (subject == null) {
			throw new IllegalArgumentException("Khong co hoc phan.");
		}
		this.subject = subject;
		this.hoTen = hoTen;
	}

	@Override
	public void update(String message) {
		System.out.println("[" + hoTen + "]: " + message);
	}

	@Override
	public void subscribe() {
		System.out.println("Dang ky nhan thong bao: " + hoTen + " <- " + subject.subjectDetails());
		subject.subscribeObserver(this);
	}

	@Override
	public void unSubscribe() {
		System.out.println("Huy dang ky: " + hoTen + " <- " + subject.subjectDetails());
		subject.unSubscribeObserver(this);
	}
}
