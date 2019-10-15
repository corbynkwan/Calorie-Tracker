package placeholder;

import model.Food;
import model.FoodList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
