package pl.ssitarek;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingleBuildingTest {

    @Test
    public void compareBuildingsDifferentHeights() {

        SingleBuilding building1 = new SingleBuilding(1, 50);
        SingleBuilding building2 = new SingleBuilding(2, 30);

        int result = building1.compareTo(building2);
        assertEquals(-20, result);

        result = building2.compareTo(building1);
        assertEquals(20, result);
    }

    @Test
    public void compareBuildingsEqualHeights() {

        SingleBuilding building1 = new SingleBuilding(1, 30);
        SingleBuilding building2 = new SingleBuilding(2, 30);

        int result = building1.compareTo(building2);
        assertEquals(-1, result);
    }

    @Test(expected = NullPointerException.class)
    public void compareBuildingMissing01() {

        SingleBuilding building1 = new SingleBuilding(1, 30);
        SingleBuilding building2 = null;

        building1.compareTo(building2);
    }

    @Test(expected = NullPointerException.class)
    public void compareBuildingMissing02() {

        SingleBuilding building1 = new SingleBuilding(1, 30);
        SingleBuilding building2 = null;

        building2.compareTo(building1);
    }
}