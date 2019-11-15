package ui;

import exceptions.InvalidInputException;
import model.BodyBuildingDiet;
import network.FoodSummary;
import model.User;

public class Main {
    public static void main(String[] args) throws Exception {
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
