package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodList extends SaveAndLoad implements Serializable {
    private List<Food> foodList;
    private transient Scanner in = new Scanner(System.in);

    //MODIFIES this
    //EFFECT sets the actual type of foodList();
    public FoodList() {
        foodList = new ArrayList<>();
    }

    //MODIFIES this
    //EFFECT adds a new food to the foodList

    public void add(Food newFood) {
        foodList.add(newFood);
    }

    //EFFECT returns the size of the foodList
    public int size() {
        return foodList.size();
    }

    //REQUIRES foodList to have a length >=1
    //EFFECT prints out the whole food list in a format
    public void printFoodList() {
        for (int i = 0; i < foodList.size(); i++) {
            foodList.get(i).printString();
        }
    }

    //REQUIRES i to have a length >=0
    //EFFECT returns the Food at index i
    public Food get(int i) {
        return foodList.get(i);
    }

}
