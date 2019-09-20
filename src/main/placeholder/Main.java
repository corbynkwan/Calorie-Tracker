package placeholder;

import ui.Food;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        Food f = new Food();
        f.setProtein(50.0);
        f.setCarbs(10);
        f.setFats(0);

        if (f.getProtein() >= 30) {
            System.out.println("This food has a lot of protein");
        }

        String input = "yes";
        while (input.equals("yes")) {
            System.out.print("Do you want to know the nutritional facts of chicken breast(100g)?");
            input = in.nextLine();
            if(input.equals("yes")) {
                System.out.println(f.getProtein());
                System.out.println(f.getCarbs());
                System.out.println(f.getFats());
            }
        }

    }
}
