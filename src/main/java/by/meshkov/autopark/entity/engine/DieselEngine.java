package by.meshkov.autopark.entity.engine;

public class DieselEngine extends CombustionEngine {
    public DieselEngine(double engineCapacity,double
            fuelConsumptionPer100) {
        super("Diesel", 1.2, engineCapacity, fuelConsumptionPer100);
    }

    @Override
    public double calculateEngineTaxPerMonth() {
        return 0;
    }
}
