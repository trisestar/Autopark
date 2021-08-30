package by.meshkov.autopark.entity.engine;

public class GasolineEngine extends CombustionEngine{

    public GasolineEngine(double engineCapacity, double fuelConsumptionPer100) {
        super("Gasoline", 1.1, engineCapacity, fuelConsumptionPer100);
    }

    @Override
    public double calculateEngineTaxPerMonth() {
        return 0;
    }
}
