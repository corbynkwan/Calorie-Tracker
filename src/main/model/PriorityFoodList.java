package model;

import java.util.ArrayList;
import java.util.List;

public class PriorityFoodList extends FoodList {
    private FoodList foodList;
    protected List<Food> priorityFoodList;

    public PriorityFoodList() {
        priorityFoodList = new ArrayList<>();
    }

    public List<Food> getPriorityFoodList() {
        return priorityFoodList;
    }

    public void setFoodList(FoodList newFoodList) {
        foodList = newFoodList;
    }

    public void remove(String foodName) {
        for (int i = 0; i < priorityFoodList.size(); i++) {
            if (priorityFoodList.get(i).getName().equals(foodName)) {
                priorityFoodList.remove(i);
            }
        }

        for (int i = 0; i < foodList.foodList.size(); i++) {
            if (foodList.foodList.get(i).getName().equals(foodName)) {
                foodList.foodList.remove(i);
            }
        }
    }

    public void add(Food newFood) {
        if (!priorityFoodList.contains(newFood)) {
            priorityFoodList.add(newFood);
            foodList.getFoodList().add(newFood);
        }
    }

    public void printFoodList() {
        for (int i = 0; i < priorityFoodList.size(); i++) {
            priorityFoodList.get(i).printString();
        }
    }
}
