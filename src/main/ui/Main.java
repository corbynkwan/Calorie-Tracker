package ui;

public class Main {
    public static void main(String[] args) throws Exception {
/*        FoodList list = new FoodList();
        //list.userInputFoodList();
        list.add(new Food("chicken",200,200,200,200));
        list.add(new Food("beef",300,300,300,300));
        list.add(new Food("red",300,300,300,300));
        list.printFoodList();
        list.save("foodList.dat");
        System.out.println();
        FoodList load = (FoodList) list.load("foodList.dat");
        load.printFoodList();


        User user1 = new User("Johnn", new BodyBuildingDiet(), 128);
        User user2 = new User("Johnn", new KetoDiet(), 128);

        UserList userList = new UserList();
        userList.add(user1);
        userList.add(user2);
        userList.printUserList();*/

        UserInterface ui = new UserInterface();
        ui.start();

    }

}
