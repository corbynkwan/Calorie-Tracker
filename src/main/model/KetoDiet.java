package model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class KetoDiet extends Diet implements Serializable, SaveAndLoad {

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

    @Override
    public void save(String fileName) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            out.writeObject(this);
            out.close();
        }
    }

    @Override
    public Object load(String fileName) throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            return in.readObject();
        }
    }
}
