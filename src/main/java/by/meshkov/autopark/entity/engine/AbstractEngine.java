package by.meshkov.autopark.entity.engine;

import java.util.Objects;

public abstract class AbstractEngine implements Startable {
    private String engineName;
    private double engineTaxCoefficient;

    public AbstractEngine(String engineName, double engineTaxCoefficient) {
        this.engineName = engineName;
        this.engineTaxCoefficient = engineTaxCoefficient;
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public double getEngineTaxCoefficient() {
        return engineTaxCoefficient;
    }

    public void setEngineTaxCoefficient(double engineTaxCoefficient) {
        this.engineTaxCoefficient = engineTaxCoefficient;
    }

    @Override
    public String toString() {
        return engineName + "," + engineTaxCoefficient;
    }
}
