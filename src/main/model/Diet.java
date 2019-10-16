package model;

import exceptions.InvalidInputException;

import java.io.Serializable;

public abstract class Diet extends SaveAndLoad implements Serializable {
    protected double targetWeight;

    public double getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(double newTargetWeight) throws InvalidInputException {
        if (newTargetWeight < 0) {
            throw new InvalidInputException();
        }
        targetWeight = newTargetWeight;
    }

    public abstract double calculateCal();

    public abstract double calculatePro();

    public abstract double calculateCarbs();

    public abstract double calculateFats();


}
