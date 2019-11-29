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
        addObserver(dietType);
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

    //MODIFIES dietType
    //EFFECTS Sets new targetWeight and notifies dietType to update macronutrient target values.
    public void setTargetWeight(double newTargetWeight) {    //newTarget<0 is handled in the consutructor
        targetWeight = newTargetWeight;
        setChanged();//Makes change true so that it will notify observers
        notifyObservers(this);//Passes current user as a parameter to Observer in this case Diet
                                   //So that Diet can access the User object.
    }

    //EFFECTS prints a String of the user's fields
    public void printString() {
        System.out.printf("Name:" + "%-10s" + "Calories:" + "%-10.2f" + "Protein:" + "%-10.2f" + "Carbohydrates:"
                + "%-10.2f" + "Fats:" + "%-10.2f \n", name, dietType.calculateCal(),
                dietType.calculatePro(), dietType.calculateCarbs(), dietType.calculateFats());
    }

    //REQUIRES obj to be of type User
    //EFFECTS returns a boolean value to see if the user's name is the same as the other user's name
    @Override
    public boolean equals(Object obj) {
        User other = (User)obj;
        return getName().equals(other.getName());
    }
}
