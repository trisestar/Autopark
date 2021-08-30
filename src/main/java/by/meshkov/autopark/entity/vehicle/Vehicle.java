package by.meshkov.autopark.entity.vehicle;

import by.meshkov.autopark.entity.engine.AbstractEngine;
import by.meshkov.autopark.exception.NotVehicleException;
import by.meshkov.autopark.entity.rent.Rent;
import by.meshkov.autopark.service.TechnicalSpecialist;

import java.util.List;
import java.util.Objects;


public class Vehicle implements Comparable<Vehicle> {


    private final VehicleType vehicleType;
    private final String modelName;
    private final int manufactureYear;
    private String registrationNumber;
    private double weight;
    private int mileage;
    private Color color;
    private double tankVolume;
    private AbstractEngine engine;

    private int id;
    private List<Rent> rentList;

    public Vehicle(int id, VehicleType vehicleType, String modelName, String registrationNumber, double weight,
                   int manufactureYear, int mileage, Color color, AbstractEngine engine) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.modelName = modelName;
        this.registrationNumber = registrationNumber;
        this.weight = weight;
        this.manufactureYear = manufactureYear;
        this.mileage = mileage;
        this.color = color;
        this.engine = engine;
    }

    public Vehicle() {
        this.vehicleType = null;
        this.modelName = null;
        this.manufactureYear = 0;
    }

    public Vehicle(VehicleType type, String modelName, int manufactureYear) {
        this.vehicleType = type;
        this.modelName = modelName;
        this.manufactureYear = manufactureYear;
    }

    public Vehicle(VehicleType type, String modelName, String registrationNumber, double weight, int manufactureYear, int mileage,
                   Color color, double tankVolume, AbstractEngine engine) throws NotVehicleException {

        if (TechnicalSpecialist.validateVehicleType(type) && TechnicalSpecialist.validateModelName(modelName) && TechnicalSpecialist.validateRegistrationNumber(registrationNumber) &&
                TechnicalSpecialist.validateWeight(weight) && TechnicalSpecialist.validateManufactureYear(manufactureYear) && TechnicalSpecialist.validateMileage(mileage) &&
                TechnicalSpecialist.validateColorString(getColor().name()) && TechnicalSpecialist.validateTankVolume(tankVolume) && TechnicalSpecialist.validateEngine(engine) ){
            this.vehicleType = type;
            this.modelName = modelName;
            this.registrationNumber = registrationNumber;
            this.weight = weight;
            this.manufactureYear = manufactureYear;
            this.mileage = mileage;
            this.color = color;
            this.tankVolume = tankVolume;
            this.engine = engine;
        } else {
            this.vehicleType = null;
            this.modelName = null;
            this.manufactureYear = 0;
            throw new NotVehicleException("Wrong data");
        }


    }



    public double getTotalIncome( ){
        double totalIncome = 0;
        for (Rent rent :rentList){
            totalIncome+=rent.getCost();
        }

        return totalIncome;
    }

    public double getTotalProfit( ){

        return getTotalIncome( ) - getCalcTaxPerMonth( );

    }

    public double getCalcTaxPerMonth() {
        return (weight * 0.0013) + (engine.calculateEngineTaxPerMonth() * vehicleType.getTaxCoefficient() * 30) + 5;
    }


    public AbstractEngine getEngine() {
        return engine;
    }

    public void setEngine(AbstractEngine engine) {
        this.engine = engine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getModelName() {
        return modelName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (TechnicalSpecialist.validateRegistrationNumber(registrationNumber)) {
            this.registrationNumber = registrationNumber;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (TechnicalSpecialist.validateWeight(weight)) {
            this.weight = weight;
        }
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        if (TechnicalSpecialist.validateMileage(mileage)) {
            this.mileage = mileage;
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (TechnicalSpecialist.validateColorString(color.name())) {
            this.color = color;
        }
    }

    public double getTankVolume() {
        return tankVolume;
    }

    public void setTankVolume(double tankVolume) {
        if (TechnicalSpecialist.validateTankVolume(tankVolume)) {
            this.tankVolume = tankVolume;
        }
    }

    @Override
    public String toString() {
        return vehicleType.getTypeName() +
                "," + vehicleType.getTaxCoefficient() +
                "," + modelName +
                "," + registrationNumber +
                "," + weight +
                "," + manufactureYear +
                "," + mileage +
                "," + color +
                "," + tankVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return vehicleType.equals(vehicle.vehicleType) && modelName.equals(vehicle.modelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleType, modelName);


    }

    @Override
    public int compareTo(Vehicle obj) {
        int result = this.getManufactureYear() - obj.getManufactureYear();
        if (result == 0) {
            return this.getMileage() - obj.getMileage();
        } else {
            return result;
        }
    }
}
