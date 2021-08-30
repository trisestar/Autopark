package by.meshkov.autopark.entity.engine;

public abstract class CombustionEngine extends AbstractEngine{
    String typeName;
    double taxCoefficient;
    double fuelTankCapacity;
    double fuelConsumptionPer100;

    public CombustionEngine(String typeName, double taxCoefficient, double fuelTankCapacity, double fuelConsumptionPer100) {
        super(typeName, taxCoefficient);
        this.fuelTankCapacity = fuelTankCapacity;
        this.fuelConsumptionPer100 = fuelConsumptionPer100;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public double getTaxCoefficient() {
        return taxCoefficient;
    }

    public void setTaxCoefficient(double taxCoefficient) {
        this.taxCoefficient = taxCoefficient;
    }

    public double getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(double fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public double getFuelConsumptionPer100() {
        return fuelConsumptionPer100;
    }

    public void setFuelConsumptionPer100(double fuelConsumptionPer100) {
        this.fuelConsumptionPer100 = fuelConsumptionPer100;
    }

    public double calculateMaxKilometers(){
        return fuelTankCapacity * 100 / fuelConsumptionPer100;
    }
}
