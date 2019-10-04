package model;

public interface Diet {

    public double getTargetWeight();

    public void setTargetWeight(double newTargetWeight);

    public double calculateCal();

    public double calculatePro();

    public double calculateCarbs();

    public double calculateFats();

}
