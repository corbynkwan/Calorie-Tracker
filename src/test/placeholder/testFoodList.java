package placeholder;

import model.Food;
import model.FoodList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testFoodList {
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


}
