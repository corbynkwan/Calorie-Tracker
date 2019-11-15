package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityFoodListTest {
    PriorityFoodList priorityFoodList;
    Food f = new Food("chicken",5,5,5,5);
    FoodList foodList ;

    @BeforeEach
    void runBefore() {
        priorityFoodList = new PriorityFoodList();
        priorityFoodList.setFoodList(foodList);
        foodList = new FoodList();
    }
    @Test
    void getPriorityFoodList() {
        priorityFoodList.getPriorityFoodList();
    }

    @Test
    void setFoodList() {
        priorityFoodList.setFoodList(foodList);
    }

    @Test
    void remove() {
        priorityFoodList.add(f);
        priorityFoodList.remove("chicken");
    }

    @Test
    void add() {
        priorityFoodList.add(f);

    }

    @Test
    void printFoodList() {
        foodList.printFoodList();
    }
}