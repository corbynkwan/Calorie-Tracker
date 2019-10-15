package placeholder;

import model.BodyBuildingDiet;
import model.Diet;
import model.KetoDiet;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    User u;
    Diet d;
    @BeforeEach
    void runBefore() {
        d = new BodyBuildingDiet();
        u = new User("Dave", d, 155);
    }
    @Test
    public void testConstructor() {
        assertEquals("Dave", u.getName());
        assertEquals(d, u.getDietType());
        assertEquals(155, u.getTargetWeight());
    }
    @Test
    void getName() {
        assertEquals("Dave", u.getName());
    }

    @Test
    void getDietType() {
        assertEquals(d, u.getDietType());
    }

    @Test
    void getTargetWeight() {
        assertEquals(155, u.getTargetWeight());
    }

    @Test
    void setName() {
        u.setName("almond");
        assertEquals("almond", u.getName());
    }

    @Test
    void setDietType() {
        Diet d2 = new KetoDiet();
        u.setDietType(d2);
        assertEquals(d2, u.getDietType());
    }

    @Test
    void setTargetWeight() {
        u.setTargetWeight(120);
        assertEquals(120, u.getTargetWeight());
    }

    @Test
    void printString() {
        u.printString();
    }
}