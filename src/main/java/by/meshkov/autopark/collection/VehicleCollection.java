package by.meshkov.autopark.collection;

import by.meshkov.autopark.entity.vehicle.Vehicle;
import by.meshkov.autopark.entity.vehicle.VehicleType;
import by.meshkov.autopark.parser.ParserVehicleFromFile;

import java.util.List;

public class VehicleCollection {
    List<VehicleType> typeList;
    List<Vehicle> vehicleList;
    ParserVehicleFromFile parser;

    void insert(int index, Vehicle vehicle){
        try {
            vehicleList.add(index,vehicle);
        } catch (IndexOutOfBoundsException exception){
            exception.printStackTrace();
            vehicleList.add(vehicle);
        }

    }

    int delete(int index) {
        try {
            vehicleList.remove(index);
            return index;
        } catch (IndexOutOfBoundsException exception){
            exception.printStackTrace();
            return -1;
        }

    }

    double sumTotalProfit(){
        return vehicleList.stream().mapToDouble(Vehicle::getTotalIncome).sum();
    }


    void display( ){
        System.out.println(vehicleList.toString());
    }

    public VehicleCollection(ParserVehicleFromFile parser) {
        this.parser = parser;
    }

    public List<VehicleType> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<VehicleType> typeList) {
        this.typeList = typeList;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public ParserVehicleFromFile getParser() {
        return parser;
    }

    public void setParser(ParserVehicleFromFile parser) {
        this.parser = parser;
    }
}
