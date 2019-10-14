package ui;

public class Main {
    public static void main(String[] args) throws Exception {


        UserInterface ui = new UserInterface();
        ui = (UserInterface) ui.load("User.dat");
        ui.start();


    }

}
