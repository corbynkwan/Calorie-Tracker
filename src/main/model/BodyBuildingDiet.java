package model;

import java.io.Serializable;

public class BodyBuildingDiet extends Diet implements Serializable {


    @Override
    public double calculateCal() {
        double calculatedCalories = calculatePro() * 4 + calculateCarbs() * 4 + calculateFats() * 9;
        return calculatedCalories;
        //Think about how to relate this to users.
    }

    @Override
    public double calculatePro() {
        double calculatedProtein = targetWeight * 1.5;
        return calculatedProtein;
    }

    @Override
    public double calculateCarbs() {
        double calculatedCarbs = targetWeight * 1;
        return calculatedCarbs;
    }

    @Override
    public double calculateFats() {
        double calculatedFats = targetWeight * 0.5;
        return calculatedFats;
    }

}



