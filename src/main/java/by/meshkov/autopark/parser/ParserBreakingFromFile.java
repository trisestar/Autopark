package by.meshkov.autopark.parser;



import by.meshkov.autopark.reader.Reader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;
import java.util.Map;

public class ParserBreakingFromFile {

    public static void deleteOrder(int id) {
        File sourceFile = new File("src\\main\\resources\\orders.csv");
        String data = Reader.readFile("src\\main\\resources\\orders.csv");
        String[] ordersArray = data.split("\n");
        List<String> ordersList = new java.util.ArrayList<>(List.of(ordersArray));
        ordersList.removeIf(order -> Integer.parseInt(order.split(",")[0]) == id);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\main\\resources\\orders.csv"))) {
            sourceFile.delete();
            writer.write(ordersList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void addOrder(int id, Map<String, Integer> details) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\main\\resources\\orders.csv", true))) {
            StringBuilder orderBuf = new StringBuilder();
            orderBuf.append(id);
            orderBuf.append(":");
            for (Map.Entry<String, Integer> entry : details.entrySet()) {
                orderBuf.append(entry.getKey() + "," + entry.getValue() + ",");
            }
            orderBuf.deleteCharAt(orderBuf.length()-1);
            orderBuf.append("\n");
            System.out.println(orderBuf);
            writer.write(String.valueOf(orderBuf));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String findOrder(int id) {

        String data = Reader.readFile("src\\main\\resources\\orders.csv");
        String[] ordersArray = data.split("\n");
        List<String> ordersList = new java.util.ArrayList<>(List.of(ordersArray));
        return String.valueOf(ordersList.stream().filter(order -> Integer.parseInt(order.split(":")[0]) == id).toList()).
                replace("[","").replace("]","");

    }



    public static void main(String[] args) {
/*        Map<String, Integer> details = new HashMap<>();
        details.put("qwe", 2);
        details.put("asd", 3);
        new ParserBreakingFromFile().addOrder(331, details);*/
        String result = new ParserBreakingFromFile().findOrder(332);
        System.out.println(result);
        System.out.println(result.isEmpty());
    }

}
