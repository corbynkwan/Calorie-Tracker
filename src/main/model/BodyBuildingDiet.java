package model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BodyBuildingDiet extends Diet implements SaveAndLoad, Serializable {




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

    public Object load(String fileName) throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            return in.readObject();
        }
    }

    public void save(String fileName) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            out.writeObject(this);
            out.close();
        }
    }


}
