package ui;

import model.Food;
import model.FoodList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        FoodList list = new FoodList();
        Food newFood = null;
        System.out.println("Do you want to enter a new food (100g)? (Y for yes N for no)");
        String input = in.nextLine();
        do {
            if (input.equals("Y") || input.equals("N")) {

                list.add(newFood);
                System.out.println("Do you want to enter another food? (Y for yes N for no)");
                in.nextLine();//Moves cursor down.
                input = in.nextLine();
            }
        } while (input.equals("Y"));
        list.printFoodList();

    }


}
