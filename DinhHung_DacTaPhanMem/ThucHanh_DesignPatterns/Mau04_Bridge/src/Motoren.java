/** O to con (vi du them loai xe khac). */
public class Motoren extends Car {

	public Motoren(Product product, String carType) {
		super(product, carType);
	}

	@Override
	public void assemble() {
		System.out.println("Lap rap " + product.productName() + " len xe con " + carType);
	}

	@Override
	public void produceProduct() {
		product.produce();
		System.out.println("Dieu chinh khoa cho xe con: " + carType);
	}
}
