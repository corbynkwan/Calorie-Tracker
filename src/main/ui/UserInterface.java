package ui;

import model.*;

import java.util.Scanner;

public class UserInterface {
    private transient Scanner in = new Scanner(System.in);
    private UserList userList;

    UserInterface() {
        userList = new UserList(); //Why is this bad practice? Why can't I just put it on top.
    }

    public void start() {
        System.out.println("Enter Option");
        System.out.println("1: Add User");
        System.out.println("2: Delete User");
        System.out.println("3: Add Food");
        System.out.println("4: Delete Food");
        System.out.println("5: Add Diet");
        System.out.println("6: Change Diet");
        int menuOption = in.nextInt();

        switch (menuOption) {
            case 1: menu1();
            break;
/*            case 2: menu2();
            case 3: menu3();
            case 4: menu4();
            case 5: menu5();*/
            default: System.out.println("invalid input");
        }
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

}

