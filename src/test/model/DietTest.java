package model;

import exceptions.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DietTest {
    Diet b;
    Diet k;
    @BeforeEach
    public void runBefore() {
        b = new BodyBuildingDiet();
    }

    @Test
    public void testGetAndSetTargetWeight() throws InvalidInputException {
        b.setTargetWeight(70);
        assertEquals(b.getTargetWeight(), 70);
    }
}
