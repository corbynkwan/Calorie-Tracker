package placeholder;

import model.BodyBuildingDiet;
import model.Diet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveAndLoadTest {
    Diet d;
    @BeforeEach
    public void runBefore() {
        d = new BodyBuildingDiet();
    }

    @Test
    public void testSaveAndLoad() throws Exception {
        d.setTargetWeight(70);
        ((BodyBuildingDiet) d).save("diet.dat");
        Diet loadDiet = (BodyBuildingDiet) ((BodyBuildingDiet) d).load("diet.dat");
        assertEquals(loadDiet.getTargetWeight(), 70);
    }


}
