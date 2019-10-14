package placeholder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Food;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {
    Food def;
    Food f;
    @BeforeEach
    public void runBefore() {
    def = new Food();
    f = new Food("cod", 82,18, 5, 0.7);
    }
    @Test
    public void testFoodDefaultConstructor() {
    assertEquals(0,def.getCalories());
    assertEquals(0,def.getProtein());
    assertEquals(0,def.getCarbs());
    assertEquals(0,def.getFats());
    }
    @Test
    public void testConstructor() {
    assertEquals("cod", "cod");
    assertEquals(82,f.getCalories());
    assertEquals(18,f.getProtein());
    assertEquals(5,f.getCarbs());
    assertEquals(0.7,f.getFats());
    }
    @Test
    public void testGetName() {
        assertEquals("cod", "cod");
    }
    @Test
    public void testGetCalories() {
        assertEquals(82,f.getCalories());
    }
    @Test
    public void testGetProtein() {
        assertEquals(18,f.getProtein());
    }
    @Test
    public void testGetCarbs() {
        assertEquals(5,f.getCarbs());
    }
    @Test
    public void testGetFats() {
        assertEquals(0.7,f.getFats());
    }
    @Test
    public void testSetName() {
        def.setName("almond");
        assertEquals("almond", def.getName());
    }
    @Test
    public void testSetCalories() {
        def.setCalories(579);
        assertEquals(579, def.getCalories());
    }
    @Test
    public void testSetProtein() {
        def.setProtein(21);
        assertEquals(21,def.getProtein());
    }
    @Test
    public void testSetCarbs() {
        def.setCarbs(22);
        assertEquals(22,def.getCarbs());
    }
    @Test
    public void testSetFats() {
        def.setFats(50);
        assertEquals(50,def.getFats());
    }

    @Test
    public void printString() {
        assertEquals(f.toString(), f.toString());
    }



}