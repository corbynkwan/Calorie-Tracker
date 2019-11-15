package ui;

import exceptions.InvalidInputException;
import model.BodyBuildingDiet;
import network.FoodSummary;
import model.User;

public class Main {
    public static void main(String[] args) throws Exception {
        //Did try and catch for Y and N for askFood
        //Did try and catch for loading and saving files @ constructor of UserInterface()
        //Did try and catch for Diet set weight @ Diet class
        User u = new User("bob", new BodyBuildingDiet(), 155);
        System.out.println(u.getTargetWeight());
        System.out.println(u.getDietType().getTargetWeight());
        u.setTargetWeight(55);
        System.out.println(u.getTargetWeight());
        System.out.println(u.getDietType().getTargetWeight());
        FoodSummary fs = new FoodSummary();


        System.out.println(fs.fetchFirstParagraph("chicken_as_food"));
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
