package by.meshkov.autopark.service;

import by.meshkov.autopark.entity.vehicle.Vehicle;
import by.meshkov.autopark.parser.ParserBreakingFromFile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MechanicService implements Fixer {

    static String[] details = {"Фильтр", "Втулка", "Вал", "Ось", "Свеча", "Масло", "ГРМ", "ШРУС"};
    private ParserBreakingFromFile parser;

    public MechanicService(ParserBreakingFromFile parser) {
        this.parser = parser;
    }


    @Override
    public Map<String, Integer> detectBreaking(Vehicle vehicle) {

        double random = new Random().nextDouble()*7;
        String randomDetail = Arrays.stream(details).toList().get((int) random);
        System.out.println(randomDetail);
        random = new Random().nextDouble()*4;
        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put(randomDetail, (int) random);
        return resultMap;
    }

    public static void main(String[] args) {
        new MechanicService(new ParserBreakingFromFile()).detectBreaking(new Vehicle());
    }

    @Override
    public void repair(Vehicle vehicle){
        ParserBreakingFromFile.deleteOrder(vehicle.getId());
    }

    @Override
    public boolean detectAndRepair(Vehicle vehicle) {
        return Fixer.super.detectAndRepair(vehicle);
    }

    @Override
    public boolean isBroken(Vehicle vehicle){
        String order = ParserBreakingFromFile.findOrder(vehicle.getId());
        if (order.isEmpty()){
            return false;
        }
        return true;
    }
}
