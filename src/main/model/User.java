package model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class User implements Serializable, SaveAndLoad {
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


    @Override
    public void save(String fileName) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            out.writeObject(this);
        }
    }

    @Override
    public Object load(String fileName) throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            return in.readObject();
        }
    }
}
