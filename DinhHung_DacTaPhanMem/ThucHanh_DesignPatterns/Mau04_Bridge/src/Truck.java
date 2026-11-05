/**
 * Refined abstraction: o to TAI (theo de thuc hanh).
 */
public class Truck extends Car {

	public Truck(Product product, String carType) {
		super(product, carType);
	}

	@Override
	public void assemble() {
		System.out.println("Lap rap " + product.productName() + " len xe TAI " + carType);
	}

	@Override
	public void produceProduct() {
		product.produce();
		System.out.println("Dieu chinh khoa cho thung xe / tai trong lon: " + carType);
	}
}
