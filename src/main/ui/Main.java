package ui;

import exceptions.InvalidInputException;

public class Main {
    public static void main(String[] args) throws Exception {

        try {
            UserInterface ui = new UserInterface();
            ui.start();
        } catch (InvalidInputException e) {
            System.out.println("Invalid input");
        } finally {
            System.out.println("finally");
        }

    }

}
