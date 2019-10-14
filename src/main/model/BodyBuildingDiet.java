package model;

import java.io.Serializable;

public class BodyBuildingDiet extends Diet implements Serializable {


    @Override
    public double calculateCal() {
        double calculatedCalories = targetWeight * 30;
        return calculatedCalories;
        //Think about how to relate this to users.
    }

    @Override
    public double calculatePro() {
        double calculatedProtein = (targetWeight * 0.4) / 10;
        return calculatedProtein;
    }

    @Override
    public double calculateCarbs() {
        double calculatedCarbs = (targetWeight * 0.4) / 10;
        return calculatedCarbs;
    }

    @Override
    public double calculateFats() {
        double calculatedFats = (targetWeight * 0.2) / 10;
        return calculatedFats;
    }

}



