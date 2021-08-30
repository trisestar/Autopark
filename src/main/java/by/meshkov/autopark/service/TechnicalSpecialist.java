package by.meshkov.autopark.service;

import by.meshkov.autopark.entity.engine.AbstractEngine;
import by.meshkov.autopark.entity.engine.DieselEngine;
import by.meshkov.autopark.entity.engine.ElectricalEngine;
import by.meshkov.autopark.entity.engine.GasolineEngine;
import by.meshkov.autopark.entity.vehicle.Color;
import by.meshkov.autopark.entity.vehicle.VehicleType;

public class TechnicalSpecialist {
    public static final int LOWER_LIMIT_MANUFACTURE_YEAR = 1886;

    public static boolean validateManufactureYear(int year) {
        return year >= LOWER_LIMIT_MANUFACTURE_YEAR && year <= 9999;
    }

    public static boolean validateMileage(int mileage) {
        return mileage > -1;
    }

    static public boolean validateWeight(double weight) {
        return weight > -1;
    }

    static public boolean validateColorString(String color) {
        try {
            Color.valueOf(color);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // DDDD LL-D
    static public boolean validateRegistrationNumber(String number) {
        final String REGISTRATION_NUMBER_REGEX = "\\d{4} \\p{Upper}{2}-\\d";
        return number.matches(REGISTRATION_NUMBER_REGEX);
    }

    static public boolean validateModelName(String name) {
        return !name.isEmpty();
    }

    static public boolean validateVehicleType(VehicleType type) {
        return type.getTaxCoefficient() > 0 && !type.getTypeName().isEmpty();

    }

    static public boolean validateTankVolume(double volume) {
        return volume > 0;
    }

    static public boolean validateEngine(AbstractEngine engine){

        switch (engine.getClass().getSimpleName()){
            case "DieselEngine":{
                return validateDieselEngine((DieselEngine) engine);
            }
            case "GasolineEngine":{
                return validateGasolineEngine((GasolineEngine) engine);
            }
            case "ElectricalEngine":{
                return validateElectricalEngine((ElectricalEngine) engine);
            }
            default:{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(DieselEngine.class.getSimpleName());
    }

    static public boolean validateDieselEngine(DieselEngine engine){
        return !engine.getEngineName().isEmpty() && !engine.getTypeName().isEmpty() && engine.getTaxCoefficient()>0 &&
                engine.getEngineTaxCoefficient()>0 && engine.getFuelConsumptionPer100()>0 && engine.getFuelTankCapacity()>0;

    }

    static public boolean validateGasolineEngine(GasolineEngine engine){
        return !engine.getEngineName().isEmpty() && !engine.getTypeName().isEmpty() && engine.getTaxCoefficient()>0 &&
                engine.getEngineTaxCoefficient()>0 && engine.getFuelConsumptionPer100()>0 && engine.getFuelTankCapacity()>0;

    }

    static public boolean validateElectricalEngine(ElectricalEngine engine){
        return !engine.getEngineName().isEmpty() && engine.getEngineTaxCoefficient()>0 && engine.getBatterySize()>0 && engine.getElectricityConsumption()>0;
    }


}
