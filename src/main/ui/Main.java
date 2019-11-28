package ui;

import model.*;

import java.util.ArrayList;

//
//
public class Main {
    public static void main(String[] args) throws Exception {
        UserList userList = new UserList();
        User bob = new User("Bob",new BodyBuildingDiet(),155);
        userList.add(bob);
        userList.add(new User("newbee",new BodyBuildingDiet(),155));
        User bob2 = new User("Bob",new BodyBuildingDiet(),155);
        System.out.println(userList.contains(bob2));
        System.out.println(bob.equals(bob2));
        userList.save("userList.dat");
        FoodList bobFoodList = new FoodList();
        bobFoodList.add(new Food("Chicken",5,5,5,5));
        bobFoodList.add(new Food("Beef",5,5,5,5));
        bobFoodList.save("BobFoodList.dat");
        userList.remove(bob);
        userList.printUserList();
        //Object[][] foodArray = new ArrayList[10][5];

        ArrayList<ArrayList<Object>> foodArray = new ArrayList<ArrayList<Object>>();
        for (int i = 0; i < bobFoodList.size();i++) {
            ArrayList<Object> a = new ArrayList<>();
            a.add(bobFoodList.get(i).getName());
            a.add(bobFoodList.get(i).getCalories());
            a.add(bobFoodList.get(i).getProtein());
            a.add(bobFoodList.get(i).getCarbs());
            a.add(bobFoodList.get(i).getFats());
            foodArray.add(a);
            a = new ArrayList<>();
        }
        for (int i = 0; i < foodArray.size();i++) {
            System.out.println(foodArray.get(i).get(0));

            System.out.println(foodArray.get(i).get(1));
            System.out.println(foodArray.get(i).get(2));
            System.out.println(foodArray.get(i).get(3));
            System.out.println(foodArray.get(i).get(4));
            //Stuff to do
            // Re-do the calculation of keto diet and bodybuilding diet in the KetoDiet and BodyBuildingDiet class.
            // Re-edit the user'ss weight target and diet type. Make a new EditUserGUI
            //Re-read the project requirements to ensure you get 4 points
            //Put the name of the GUI on the title frame
            //Make the name of food inlude grams? Or make the user enter the amount of grams.
            //Show Food List
        }




             SelectUserGUI mainMenu = new SelectUserGUI();

    }

}
