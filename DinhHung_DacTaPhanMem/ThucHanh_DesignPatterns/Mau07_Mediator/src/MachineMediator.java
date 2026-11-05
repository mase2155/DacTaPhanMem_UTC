public interface MachineMediator {

	void startCycle();

	void onClothesWeightMeasured(int kg);

	void fillWater(int liters);

	void startHeating(int tempC);

	void startWashing();
}
