package ui;

import model.BodyBuildingDiet;
import model.Diet;
import model.User;

//
//
public class Main {
    public static void main(String[] args) throws Exception {
        Diet d = new BodyBuildingDiet();
        User bob = new User("bob",new BodyBuildingDiet(),155);
        bob.setTargetWeight(155);
        System.out.println(d.getTargetWeight());
        SelectUserGUI mainMenu = new SelectUserGUI();

    }
}
