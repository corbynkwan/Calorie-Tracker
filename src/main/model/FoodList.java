package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodList {
    private List<Food> foodList;
    private Scanner in = new Scanner(System.in);

    public FoodList() {
        foodList = new ArrayList<>();
    }
    //MODIFIES this
    //EFFECT adds a new food to the foodList

    public void add(Food newFood) {
        foodList.add(newFood);
    }

    //EFFECT returns the foodList
    public List<Food> getFoodList() {
        return foodList;
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

    public void userInputFoodList() {
        Food newFood;
        System.out.println("Do you want to enter a new food (100g)? (Y for yes N for no)");
        String input = in.nextLine();
        do {
            if (input.equals("Y") || input.equals("N")) {
                newFood = askFood();
                add(newFood);
                System.out.println("Do you want to enter another food? (Y for yes N for no)");
                in.nextLine();//Moves cursor down.
                input = in.nextLine();
            }
        } while (input.equals("Y"));
    }

    public Food askFood() {
        System.out.println("What's the name of your food?");
        String name = in.nextLine();
        System.out.println("How much calories does " + name + " have?");
        double calories = in.nextDouble();
        System.out.println("How much protein does " + name + " have?");
        double protein = in.nextDouble();
        System.out.println("How much carbs does " + name + " have?");
        double carbs = in.nextDouble();
        System.out.println("How much fats does " + name + " have?");
        double fats = in.nextDouble();
        return new Food(name, calories, protein, carbs, fats);
    }
}
