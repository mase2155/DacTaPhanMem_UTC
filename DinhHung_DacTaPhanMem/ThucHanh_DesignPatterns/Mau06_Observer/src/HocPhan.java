import java.util.ArrayList;
import java.util.List;

/**
 * Subject: hoc phan (vi du Dac ta phan mem) gui thong bao cho sinh vien dang ky.
 */
public class HocPhan implements Subject, ThongBaoCapNhat {

	private final List<Observer> observers = new ArrayList<>();
	private String lastMessage;
	private final String tenHocPhan;

	public HocPhan(String tenHocPhan) {
		this.tenHocPhan = tenHocPhan;
	}

	@Override
	public void subscribeObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void unSubscribeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		System.out.println();
		for (Observer observer : observers) {
			observer.update(lastMessage);
		}
	}

	@Override
	public void setMessage(String message) {
		this.lastMessage = message;
		notifyObservers();
	}

	@Override
	public String subjectDetails() {
		return tenHocPhan;
	}
}
