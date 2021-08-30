package by.meshkov.autopark.factory;

import by.meshkov.autopark.entity.engine.AbstractEngine;
import by.meshkov.autopark.entity.engine.DieselEngine;
import by.meshkov.autopark.entity.engine.ElectricalEngine;
import by.meshkov.autopark.entity.engine.GasolineEngine;

public class EngineFactory {
    public AbstractEngine createEngine(String type, String param1, String param2, String param3){
        switch (type){
            case "Diesel":{
                return new DieselEngine(Double.parseDouble(param2), Double.parseDouble(param3));
            }
            case "Gasoline":{
                return new GasolineEngine(Double.parseDouble(param2), Double.parseDouble(param3));
            }
            case "Electrical":{
                return new ElectricalEngine(Double.parseDouble(param2), Double.parseDouble(param3));
            }
            default:{
                return null;
            }
        }
    }
}
