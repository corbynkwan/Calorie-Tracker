package ui;

import java.util.ArrayList;

public class Food {
    private double protein;
    private double carbs;
    private double fats;
    ArrayList<Food> foodList = new ArrayList<Food>;




    public double getProtein(){
        return protein;
    }
    public double getCarbs(){
        return carbs;
    }
    public double getFats(){
        return fats;
    }
    public void setProtein(double newProtein) {
        protein = newProtein;
    }

    public void setCarbs(double newCarbs) {
        carbs = newCarbs;
    }
    public void setFats(double newFats) {
        fats = newFats;
    }


}
