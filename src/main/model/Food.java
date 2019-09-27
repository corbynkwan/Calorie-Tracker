package model;

import java.util.Scanner;

public class Food {
    private String name;
    private double calories;
    private double protein;
    private double carbs;
    private double fats;
    Scanner in = new Scanner(System.in);
    //REQUIRES double parameters to be >=0
    //MODIFIES this
    //EFFECT sets the default variables values on this object

    public Food() {
        name = "";
        calories = 0;
        protein = 0;
        carbs = 0;
        fats = 0;
    }

    //REQUIRES double parameters to be >=0
    //MODIFIES this
    //EFFECT sets the variables values on this object
    public Food(String newName, double newCalories, double newProtein, double newCarbs, double newFats) {
        name = newName;
        calories = newCalories;
        protein = newProtein;
        carbs = newCarbs;
        fats = newFats;
    }

    //EFFECT returns the name of this object

    public String getName() {
        return name;
    }

    //EFFECT returns the calories of this object
    public double getCalories() {
        return calories;
    }

    //EFFECT returns the protein of this object
    public double getProtein() {
        return protein;
    }

    //EFFECT returns the carbs of this object
    public double getCarbs() {
        return carbs;
    }

    //EFFECT returns the fats of this object
    public double getFats() {
        return fats;
    }

    //MODIFIES this
    //EFFECT sets the name of this object
    public void setName(String newName) {
        name = newName;
    }

    //REQUIRES parameter newCalories to be >=0
    //MODIFIES this
    //EFFECT sets the calories of this object
    public void setCalories(double newCalories) {
        calories = newCalories;
    }

    //REQUIRES parameter newProtein to be >=0
    //MODIFIES this
    //EFFECT sets the protein of this object
    public void setProtein(double newProtein) {
        protein = newProtein;
    }

    //REQUIRES parameter newCarbs to be >=0
    //MODIFIES this
    //EFFECT sets the carbs of this object
    public void setCarbs(double newCarbs) {
        carbs = newCarbs;
    }

    //REQUIRES parameter newFats to be >=0
    //MODIFIES this
    //EFFECT sets the fats of this object
    public void setFats(double newFats) {
        fats = newFats;
    }

    //EFFECT prints out the variables of the food in a specific format.
    public void printString() {
        System.out.printf("Name:" + "%-10s" + "Calories:" + "%-10.2f" + "Protein:" + "%-10.2f" + "Carbohydrates:"
                + "%-10.2f" + "Fats:" + "%-10.2f \n", name, calories, protein, carbs, fats);
    }


}
