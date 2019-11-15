package model;

import exceptions.InvalidInputException;

import java.io.Serializable;
import java.util.Observable;

public class User extends Observable implements Serializable {
    private String name;
    private Diet dietType;
    private double targetWeight;

    public User(String newName, Diet newDietType, double newTargetWeight) throws InvalidInputException {
        name = newName;
        dietType = newDietType;
        targetWeight = newTargetWeight;
        dietType.setTargetWeight(newTargetWeight);
        addObserver(dietType); //Why is this a bad thing? Why do I need to implement the observer in another class
        dietType.setTargetWeight(targetWeight);
    }

    public String getName() {
        return name;
    }

    public Diet getDietType() {
        return dietType;
    }

    public double getTargetWeight() {
        return targetWeight;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setDietType(Diet newDietType) {
        dietType = newDietType;
    }

    public void setTargetWeight(double newTargetWeight) {
        targetWeight = newTargetWeight;
        setChanged();//Makes change true so that it will notify observers
        notifyObservers(this);//Passes current user as a parameter to Observer in this case Diet
                                   //So that Diet can access the User object.
    }


    public void printString() {
        System.out.printf("Name:" + "%-10s" + "Calories:" + "%-10.2f" + "Protein:" + "%-10.2f" + "Carbohydrates:"
                + "%-10.2f" + "Fats:" + "%-10.2f \n", name, dietType.calculateCal(),
                dietType.calculatePro(), dietType.calculateCarbs(), dietType.calculateFats());
    }

}
