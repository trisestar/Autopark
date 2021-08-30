package by.meshkov.autopark.parser;

import by.meshkov.autopark.entity.vehicle.Color;
import by.meshkov.autopark.entity.vehicle.Vehicle;
import by.meshkov.autopark.entity.vehicle.VehicleType;
import by.meshkov.autopark.factory.EngineFactory;
import by.meshkov.autopark.entity.rent.Rent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
//todo

public class ParserVehicleFromFile {

    static String mda = """
            "
            """;
    static String file = """
            1,1,Volkswagen Crafter,5427 AX-7,2022,2015,376000,Blue,Gasoline,2,75,"8.1"
            2,1,Volkswagen Crafter,6427 AA-7,2500,2014,227010,White,Gasoline,"2.18",75,"8.5"
            3,1,Electric Bus E321,6785 BA-7,12080,2019,20145,Green,Electrical,,150,50
            4,2,Golf 5,8682 AX-7,1200,2006,230451,Gray,Diesel,"1.6",55,"7.2"
            5,2,Tesla Model S 70D,E001 AA-7,2200,2019,10454,White,Electrical,,70,25
            6,3,Hamm HD 12 VV,,3000,2016,122,Yellow,Diesel,"3.2",20,25
            7,4,МТЗ Белару-1025.4,1145 AB-7,1200,2020,109,Red,Deisel,"4.75",135,"20.1"
            """;

    public static void main(String[] args) {
        List <Vehicle> list = new ParserVehicleFromFile().loadVehicles(file);
        list.forEach((Vehicle vehicle) -> System.out.println(vehicle));
    }



    List<VehicleType> loadTypes(String inFile){


        return new ArrayList<>();
    }



    List<Rent> loadRents(String inFile){
        return new ArrayList<>();
    }



    List<Vehicle> loadVehicles(String inFile){
        inFile = inFile.replaceAll("\"", "");
        String[] splited = inFile.split("\n");
        Arrays.stream(splited).forEach((String str) -> System.out.println(str));
        List <Vehicle> vehicleList = new ArrayList<>();
        for (String s : splited) {
            vehicleList.add(createVehicle(s));
        }
        return vehicleList;
    }



    VehicleType createType(String csvString){
        String[] vehicles = csvString.split(",");

        return new VehicleType();
    }



    Vehicle createVehicle (String csvString){
        String[] vehicle = csvString.split(",");
        return new Vehicle(Integer.parseInt(vehicle[0]),new VehicleType(1),vehicle[2],vehicle[3],Double.parseDouble(vehicle[4]),Integer.parseInt(vehicle[5]),
                Integer.parseInt(vehicle[6]), Color.valueOf(vehicle[7].toUpperCase(Locale.ROOT)),new EngineFactory().createEngine(vehicle[8],vehicle[9],vehicle[10],vehicle[11]));
    }
}
