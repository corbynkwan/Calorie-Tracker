package ui;

import exceptions.InvalidInputException;
import model.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class UserInterface extends SaveAndLoad implements Serializable {
    private transient Scanner in = new Scanner(System.in);
    private UserList userList;
    private FoodList foodList;

    UserInterface() {
        try {
            //How to go back the file
            userList = (UserList) load("userList.dat");
            foodList = (FoodList) load("foodList.dat");
        } catch (IOException e) {
            System.out.println("Files couldn't be loaded so new file for UserList and FoodList are created");
//            e.getStackTrace();
            userList = new UserList();
            foodList = new FoodList();
            //When we reach user interactivibility just make it so that the user can select their file
            //and redirect the default filepath to that file by setting a private variable on the top
            //called private String userListFilePath
        } catch (ClassNotFoundException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void start() throws InvalidInputException {
        printUserItems();
        int menuOption = in.nextInt();
        in.nextLine();
        switch (menuOption) {
            case 1: menu1();
            break;
            case 3: menu3();
            break;
            case 6: menu6();
            break;
            case 7: menu7();
            break;
            case 8: menu8();
            break;
            case 10: System.exit(0);
            break;
            default: throw new InvalidInputException(); //System.out.println("invalid input");
        }
    }

    public void printUserItems() {
        System.out.println("Enter Option");
        System.out.println("1: Add User");
        System.out.println("2: Delete User");
        System.out.println("3: Add Food");
        System.out.println("4: Delete Food");
        System.out.println("5: Add Diet");
        System.out.println("6: View Food List");
        System.out.println("7: View User List");
        System.out.println("8: Save");
        System.out.println("10: Exit");

        //   System.out.println("6: Change Diet");
    }

    public void menu1() throws InvalidInputException {
        Diet diet = null;
        System.out.println("Enter your name");
        String name = in.nextLine();
        System.out.println("Enter your diet type: bodybuilding or keto");
        String dietInput = in.nextLine();
        if (dietInput.equalsIgnoreCase("bodybuilding")) {
            diet = new BodyBuildingDiet();
        } else if (dietInput.equalsIgnoreCase("keto")) {
            diet = new KetoDiet();
        } else {
            System.out.println("Invalid User Input");
        }
        System.out.println("Enter your targetWeight");
        double weight = in.nextDouble();
        User newUser = new User(name, diet, weight);
        userList.add(newUser);
        System.out.println("User added");
        start();
    }

    public void menu3() throws InvalidInputException {
        userInputFoodList();
        start();

    }

    public void menu6() throws InvalidInputException {
        foodList.printFoodList();
        System.out.println("Food List printed");
        start();
    }

    public void menu7() throws InvalidInputException {
        userList.printUserList();
        start();
    }

    public void menu8() throws InvalidInputException {
        try {
            save("C:/Users/corby/Documents/project_i3b3b/data/foodList.dat");
            save("C:Users/corby/Documents/project_i3b3b/data/userList.dat");
        } catch (Exception e) {
            System.out.println("Error: Unable to save \n");
            e.printStackTrace();
        }
        start();
    }

    //UI Food/FoodList methods
    //EFFECT ask the user for input and adds a food to the food list
    public void userInputFoodList() throws InvalidInputException {
        Food newFood;
        System.out.println("Do you want to enter a new food (100g)? (Y for yes N for no)");
        String input = in.nextLine();
        do {
            if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N")) {
                newFood = askFood();
                foodList.add(newFood);
                System.out.println("Do you want to enter another food? (Y for yes N for no)");
                in.nextLine();//Moves cursor down.
                input = in.nextLine();
                if (!(input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N"))) {
                    throw new InvalidInputException();
                }
            } else {
                throw new InvalidInputException();
            }
        } while (input.equals("Y"));
    }

    //EFFECT ask the the questions for userInputFoodList() method

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

