package model;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private Diet dietType;
    private double targetWeight;

    public User(String newName, Diet newDietType, double newTargetWeight) {
        name = newName;
        dietType = newDietType;
        targetWeight = newTargetWeight;
        dietType.setTargetWeight(newTargetWeight);
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
    }

    public void printString() {
        System.out.printf("Name:" + "%-10s" + "Calories:" + "%-10.2f" + "Protein:" + "%-10.2f" + "Carbohydrates:"
                + "%-10.2f" + "Fats:" + "%-10.2f \n", name, dietType.calculateCal(),
                dietType.calculatePro(), dietType.calculateCarbs(), dietType.calculateFats());
    }

}
