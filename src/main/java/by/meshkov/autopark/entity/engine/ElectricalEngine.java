package by.meshkov.autopark.entity.engine;

public class ElectricalEngine extends AbstractEngine {
    double batterySize;
    double electricityConsumption;

    public ElectricalEngine(double batterySize, double electricityConsumption) {
        super("Electrical", 0.1);
        this.batterySize = batterySize;
        this.electricityConsumption = electricityConsumption;
    }

    public double getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(double batterySize) {
        this.batterySize = batterySize;
    }

    public double getElectricityConsumption() {
        return electricityConsumption;
    }

    public void setElectricityConsumption(double electricityConsumption) {
        this.electricityConsumption = electricityConsumption;
    }

    @Override
    public double calculateEngineTaxPerMonth() {
        return this.getEngineTaxCoefficient();
    }

    @Override
    public double calculateMaxKilometers() {
        //todo обязательно ли здесь использовать this. ?
        return this.batterySize / this.electricityConsumption;
    }
}
