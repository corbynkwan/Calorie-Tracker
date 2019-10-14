package placeholder;

import model.BodyBuildingDiet;
import model.Diet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DietTest {
    Diet b;

    @BeforeEach
    public void runBefore() {
        b = new BodyBuildingDiet();
    }

    @Test
    public void testGetAndSetTargetWeight() {
        b.setTargetWeight(70);
        assertEquals(b.getTargetWeight(), 70);
    }
}
