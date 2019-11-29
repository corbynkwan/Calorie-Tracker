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

    //EFFECTS throws InvalidInputException if newTargetWeight is <0 else newTargetWeight is the new targetWeight
    public void setTargetWeight(double newTargetWeight) throws InvalidInputException {
        if (newTargetWeight < 0) {
            throw new InvalidInputException();
        }
        targetWeight = newTargetWeight; //
    }

    //EFFECTS return the user's target calories
    public abstract double calculateCal();

    //EFFECTS return the user's target protein
    public abstract double calculatePro();

    //EFFECTS return the user's target carbs
    public abstract double calculateCarbs();

    //EFFECTS return the user's target fats
    public abstract double calculateFats();

    //Updates user's target macronutrients when notifyObservers() called
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
