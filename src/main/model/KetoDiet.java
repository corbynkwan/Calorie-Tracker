package model;

import java.io.Serializable;

public class KetoDiet extends Diet implements Serializable {

    @Override
    public double calculateCal() {
        double calculatedCalories = targetWeight * 30;
        return calculatedCalories;
    }

    @Override
    public double calculatePro() {
        double calculatedProtein = (targetWeight * 0.25) / 10;;
        return calculatedProtein;
    }

    @Override
    public double calculateCarbs() {
        double calculatedCarbs = (targetWeight * 0.05) / 10;
        return calculatedCarbs;
    }

    @Override
    public double calculateFats() {
        double calculatedFats = (targetWeight * 0.7) / 10;
        return calculatedFats;
    }


}
