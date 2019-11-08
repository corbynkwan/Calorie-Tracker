package ui;

import exceptions.InvalidInputException;
import model.Food;
import model.FoodList;
import model.PriorityFoodList;

public class Main {
    public static void main(String[] args) throws Exception {
        //Did try and catch for Y and N for askFood
        //Did try and catch for loading and saving files @ constructor of UserInterface()
        //Did try and catch for Diet set weight @ Diet class

        FoodList testFoodList = new FoodList();
        PriorityFoodList testPriorityFoodList = new PriorityFoodList();
        testFoodList.setPriorityFoodList(testPriorityFoodList);
        testPriorityFoodList.setFoodList(testFoodList);
        testFoodList.add(new Food("chicken",5,4,3,2));
        testFoodList.printFoodList();
        testPriorityFoodList.printFoodList();

        testFoodList.remove("chicken");
        testFoodList.printFoodList();
        testPriorityFoodList.printFoodList();

        try {
            UserInterface ui = new UserInterface();
            ui.start();
        } catch (InvalidInputException e) {
            System.out.println("Invalid input");
        } finally {
            System.out.println("finally");//
        }

    }

}
