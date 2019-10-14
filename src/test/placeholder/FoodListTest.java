package placeholder;

import model.Food;
import model.FoodList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FoodListTest {
    FoodList list;
    Food f;
    @BeforeEach
    public void runBefore() {
        list =  new FoodList();
    }
    @Test
    public void testAdd() {
        f = new Food();
        list.add(f);
        assertEquals(f.toString(), list.get(0).toString());
    }
    @Test
    public void testGet() {
        f = new Food();
        assertEquals(f.toString(), list.get(0).toString());
    }


    @Test
    void testGetFoodList() {
        assertEquals(list,list.getFoodList());
    }

    @Test
    void testGetSize() {
        assertEquals(0,list.size());
    }
    @Test
    void testPrintFoodList() {
        list.printFoodList();
    }

}
