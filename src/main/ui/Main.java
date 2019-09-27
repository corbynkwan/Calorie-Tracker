package ui;

import model.FoodList;

public class Main {
    public static void main(String[] args) {
        FoodList list = new FoodList();
        list.userInputFoodList();
        list.printFoodList();
    }

}
