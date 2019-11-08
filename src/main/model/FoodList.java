package model;

import java.io.Serializable;
import java.util.*;

public class FoodList extends SaveAndLoad implements Serializable {
    protected List<Food> foodList;
    private PriorityFoodList priorityFoodList;
    private transient Scanner in = new Scanner(System.in);
    HashMap<Character,String> sortedFoodList = new HashMap<Character,String>();

    //MODIFIES this
    //EFFECT sets the actual type of foodList();
    public FoodList() {
        foodList = new ArrayList<>();
    }

    //MODIFIES this
    //EFFECT adds a new food to the foodList
    public void setPriorityFoodList(PriorityFoodList newPriorityFoodList) {
        priorityFoodList = newPriorityFoodList;
    }

    public void add(Food newFood) {
        boolean addFoodList = true;
        if (!foodList.contains(newFood)) {
            foodList.add(newFood);
            priorityFoodList.getPriorityFoodList().add(newFood);
        }

    }

    public void remove(String foodName) {
        for (int i = 0; i < priorityFoodList.priorityFoodList.size(); i++) {
            if (priorityFoodList.priorityFoodList.get(i).getName().equals(foodName)) {
                priorityFoodList.priorityFoodList.remove(i);
            }
        }

        for (int i = 0; i < foodList.size(); i++) {
            if (foodList.get(i).getName().equals(foodName)) {
                foodList.remove(i);
            }
        }
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
