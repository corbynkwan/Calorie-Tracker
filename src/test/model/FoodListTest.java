package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FoodListTest {
    FoodList foodList;
    Food f;
    @BeforeEach
    public void runBefore() {
        foodList =  new FoodList();
    }
    @Test
    public void testAdd() {
        f = new Food();
        foodList.add(f);
        assertEquals(f.toString(), foodList.get(0).toString());
    }
    @Test
    public void testGet() {
        f = new Food();
        assertEquals(f.toString(), foodList.get(0).toString());
    }

    @Test
    public void testRemove() {
        f = new Food("cod",51,51,51,51);
        foodList.add(f);
        foodList.remove(f);
        assertTrue(foodList.size() == 0);

        foodList.add(f);

        foodList.remove("cod");

    }

    @Test
    void testGetSize() {
        assertEquals(0, foodList.size());
    }
    @Test
    void testPrintFoodList() {
        foodList.printFoodList();
        f = new Food();
        foodList.add(f);
        foodList.printFoodList();
    }

}
