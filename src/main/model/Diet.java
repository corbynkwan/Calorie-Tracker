package model;

import exceptions.InvalidInputException;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public abstract class Diet extends SaveAndLoad implements Serializable, Observer {
    protected double targetWeight;
    private double calories;
    private double protein;
    private double carbs;
    private double fats;

    public double getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(double newTargetWeight) throws InvalidInputException {
        if (newTargetWeight < 0) {
            throw new InvalidInputException();
        }
        targetWeight = newTargetWeight; //
    }

    public abstract double calculateCal();

    public abstract double calculatePro();

    public abstract double calculateCarbs();

    public abstract double calculateFats();

    @Override
    public void update(Observable o, Object arg) {
        User updatedUser = (User)o;
        targetWeight = updatedUser.getTargetWeight();
        calories = updatedUser.getDietType().calculateCal();
        protein = updatedUser.getDietType().calculatePro();
        carbs = updatedUser.getDietType().calculateCarbs();
        fats = updatedUser.getDietType().calculateFats();
        System.out.println("I have updated");
    }

}
