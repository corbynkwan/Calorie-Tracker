package exceptions;

import model.BodyBuildingDiet;
import model.Diet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class InvalidInputExceptionTest {
    Diet d;
    @BeforeEach
    public void runBefore() {
        d = new BodyBuildingDiet();
    }

    @Test
    public void testNoInvalidInputException() {
        //Expect no exception to be thrown since the input is positive
        try {
            d.setTargetWeight(0);
        } catch (InvalidInputException e) {
            fail("Got Exception when we shouldn't have");
        }
        assertTrue(d.getTargetWeight() == 0);
    }

    @Test
    public void testYesInvalidInputException() {
        //Expecting the exception to fail when input is negative since you can't have negative weight
        //and for targetWeight to be 0 since that is an int's default value
        try {
            d.setTargetWeight(-1);
        } catch (InvalidInputException e) {
        }
        assertTrue(d.getTargetWeight() == 0);
    }

}
