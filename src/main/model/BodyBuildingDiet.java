package model;

import java.io.Serializable;

public class BodyBuildingDiet extends Diet implements Serializable {

    //EFFECTS return the user's target calories
    @Override
    public double calculateCal() {
        double calculatedCalories = calculatePro() * 4 + calculateCarbs() * 4 + calculateFats() * 9;
        return calculatedCalories;
        //Think about how to relate this to users.
    }

    //EFFECTS return the user's target protein
    @Override
    public double calculatePro() {
        double calculatedProtein = targetWeight * 1.5;
        return calculatedProtein;
    }

    //EFFECTS return the user's target carbs
    @Override
    public double calculateCarbs() {
        double calculatedCarbs = targetWeight * 1;
        return calculatedCarbs;
    }

    //EFFECTS return the user's target fats
    @Override
    public double calculateFats() {
        double calculatedFats = targetWeight * 0.5;
        return calculatedFats;
    }

}



