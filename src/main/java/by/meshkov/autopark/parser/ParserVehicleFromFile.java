package by.meshkov.autopark.parser;

import by.meshkov.autopark.entity.rent.Rent;
import by.meshkov.autopark.entity.vehicle.Color;
import by.meshkov.autopark.entity.vehicle.Vehicle;
import by.meshkov.autopark.entity.vehicle.VehicleType;
import by.meshkov.autopark.factory.EngineFactory;
import by.meshkov.autopark.reader.Reader;

import java.util.*;

public class ParserVehicleFromFile {


    List<VehicleType> loadTypes(String inFile) {

        inFile = inFile.replace("\"", "");
        String[] rents = inFile.split("\n");
        Arrays.stream(rents).forEach(System.out::println);
        List<VehicleType> typeList = new ArrayList<>();
        for (String s : rents) {
            typeList.add(createType(s));
        }
        return typeList;
    }


    List<Rent> loadRents(String inFile) {
        inFile = inFile.replace("\"", "");
        String[] rents = inFile.split("\n");
        Arrays.stream(rents).forEach(System.out::println);
        List<Rent> rentList = new ArrayList<>();
        for (String s : rents) {
            rentList.add(createRent(s));
        }
        return rentList;

    }


    List<Vehicle> loadVehicles(String inFile) {
        inFile = inFile.replace("\"", "");
        String[] vehicles = inFile.split("\n");
        Arrays.stream(vehicles).forEach(System.out::println);
        List<Vehicle> vehicleList = new ArrayList<>();
        for (String s : vehicles) {
            vehicleList.add(createVehicle(s));
        }
        return vehicleList;
    }


    VehicleType createType(String csvString) {
        String[] vehicleType = csvString.split(",");
        return new VehicleType(Integer.parseInt(vehicleType[0]), vehicleType[1], Double.parseDouble(vehicleType[2]));
    }


    Vehicle createVehicle(String csvString) {
        String[] vehicle = csvString.split(",");
        return new Vehicle(Integer.parseInt(vehicle[0]), new VehicleType(1), vehicle[2], vehicle[3], Double.parseDouble(vehicle[4]), Integer.parseInt(vehicle[5]),
                Integer.parseInt(vehicle[6]), Color.valueOf(vehicle[7].toUpperCase(Locale.ROOT)), new EngineFactory().createEngine(vehicle[8], vehicle[9], vehicle[10], vehicle[11]));
    }

    Rent createRent(String csvString) {
        String[] rent = csvString.split(",");
        return new Rent(new Date(rent[1]), Double.parseDouble(rent[2]));
    }
}
