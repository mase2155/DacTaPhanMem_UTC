public interface Handler {

	void setNext(Handler next);

	void handle(ServiceRequest request);

	String getTenBoPhan();
}
