package model;

public abstract class Diet {
    protected double targetWeight;

    public double getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(double newTargetWeight) {
        targetWeight = newTargetWeight;
    }

    public abstract double calculateCal();

    public abstract double calculatePro();

    public abstract double calculateCarbs();

    public abstract double calculateFats();

}
