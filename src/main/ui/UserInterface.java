package ui;

import model.*;

import java.util.Scanner;

public class UserInterface {
    private transient Scanner in = new Scanner(System.in);
    private UserList userList;
    private FoodList foodList;

    UserInterface() {
        try {
            userList = (UserList) userList.load("userList.dat");
            foodList = (FoodList) foodList.load("foodList.dat");
        } catch (Exception e) {
            userList = new UserList();
            foodList = new FoodList();
        }
    }

    public void start() {
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
            default: System.out.println("invalid input");
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

    public void menu1() {
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

    public void menu3() {
        foodList.userInputFoodList();
        start();

    }

    public void menu6() {
        foodList.printFoodList();
        System.out.println("Food List printed");
        start();
    }

    public void menu7() {
        userList.printUserList();
        start();
    }

    public void menu8() {
        try {
            foodList.save("foodList.dat");
            userList.save("userList.dat");
        } catch (Exception e) {
            System.out.println("Error: Unable to save \n");
            e.printStackTrace();
            //Why do I need to handle Exception here? Didn't I handle it in this method?
        }
    }

}

