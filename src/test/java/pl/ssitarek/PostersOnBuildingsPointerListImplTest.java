package pl.ssitarek;

import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class PostersOnBuildingsPointerListImplTest {

    private PostersOnBuildingsPointerListImpl postersOnBuildings;

    @Before
    public void setUp() {
        postersOnBuildings = new PostersOnBuildingsPointerListImpl();
    }


    @Test(expected = FileNotFoundException.class)
    public void testEmptyFileName() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("");
    }

    @Test(expected = FileNotFoundException.class)
    public void testMissingLetterInFileName() throws FileNotFoundException {
        postersOnBuildings.loadListFromFile("plaa.in");
    }

    @Test(expected = NumberFormatException.class)
    public void testWrongContentInFileName() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("WrongContentPla.in");
    }

    @Test
    public void testNoBuildings01() {

        SingleBuilding[] buildingsVec = { };

        postersOnBuildings.setSingleBuildingsArray(buildingsVec);

        assertEquals(0, postersOnBuildings.getNumberOfBuildings());
        assertEquals(0, postersOnBuildings.calculateNumberOfPosters());
    }

    @Test(expected = RuntimeException.class)
    public void testNoBuildings02() {

        SingleBuilding[] buildingsVec = { null };

        postersOnBuildings.setSingleBuildingsArray(buildingsVec);

        assertEquals(1, postersOnBuildings.getNumberOfBuildings());
        assertEquals(0, postersOnBuildings.calculateNumberOfPosters());
    }


    @Test
    public void testOneBuilding() {

        SingleBuilding singleBuilding = new SingleBuilding(1, 1);
        SingleBuilding[] buildingsVec = { singleBuilding };
        postersOnBuildings.setSingleBuildingsArray(buildingsVec);

        assertEquals(1, postersOnBuildings.getNumberOfBuildings());
        assertEquals(1, postersOnBuildings.calculateNumberOfPosters());
    }


    @Test
    public void testTwoBuildingsDifferentHeight01() {

        SingleBuilding singleBuilding1 = new SingleBuilding(1, 1);
        SingleBuilding singleBuilding2 = new SingleBuilding(2, 2);
        SingleBuilding[] buildingsVec = { singleBuilding1, singleBuilding2 };
        postersOnBuildings.setSingleBuildingsArray(buildingsVec);

        assertEquals(2, postersOnBuildings.getNumberOfBuildings());
        assertEquals(2, postersOnBuildings.calculateNumberOfPosters());
    }


    @Test
    public void testTwoBuildingsDifferentHeight02() {

        SingleBuilding singleBuilding1 = new SingleBuilding(1, 2);
        SingleBuilding singleBuilding2 = new SingleBuilding(2, 1);
        SingleBuilding[] buildingsVec = { singleBuilding1, singleBuilding2 };
        postersOnBuildings.setSingleBuildingsArray(buildingsVec);

        assertEquals(2, postersOnBuildings.getNumberOfBuildings());
        assertEquals(2, postersOnBuildings.calculateNumberOfPosters());
    }


    @Test
    public void testTwoBuildingsEqualHeight() {

        SingleBuilding singleBuilding1 = new SingleBuilding(1, 1);
        SingleBuilding singleBuilding2 = new SingleBuilding(2, 1);
        SingleBuilding[] buildingsVec = { singleBuilding1, singleBuilding2 };
        postersOnBuildings.setSingleBuildingsArray(buildingsVec);

        assertEquals(2, postersOnBuildings.getNumberOfBuildings());
        assertEquals(1, postersOnBuildings.calculateNumberOfPosters());
    }


    @Test
    public void testThreeBuildingsDifferentHeight01() {

        SingleBuilding singleBuilding1 = new SingleBuilding(1, 1);
        SingleBuilding singleBuilding2 = new SingleBuilding(2, 2);
        SingleBuilding singleBuilding3 = new SingleBuilding(3, 3);
        SingleBuilding[] buildingsVec = { singleBuilding1, singleBuilding2, singleBuilding3 };
        postersOnBuildings.setSingleBuildingsArray(buildingsVec);

        assertEquals(3, postersOnBuildings.getNumberOfBuildings());
        assertEquals(3, postersOnBuildings.calculateNumberOfPosters());
    }

    @Test
    public void testThreeBuildingsDifferentHeight02() {

        SingleBuilding singleBuilding1 = new SingleBuilding(1, 3);
        SingleBuilding singleBuilding2 = new SingleBuilding(2, 2);
        SingleBuilding singleBuilding3 = new SingleBuilding(3, 1);
        SingleBuilding[] buildingsVec = { singleBuilding1, singleBuilding2, singleBuilding3 };
        postersOnBuildings.setSingleBuildingsArray(buildingsVec);


        assertEquals(3, postersOnBuildings.getNumberOfBuildings());
        assertEquals(3, postersOnBuildings.calculateNumberOfPosters());
    }

    @Test
    public void testThreeBuildingsDifferentHeight03() {

        SingleBuilding singleBuilding1 = new SingleBuilding(1, 1);
        SingleBuilding singleBuilding2 = new SingleBuilding(2, 2);
        SingleBuilding singleBuilding3 = new SingleBuilding(3, 1);
        SingleBuilding[] buildingsVec = { singleBuilding1, singleBuilding2, singleBuilding3 };
        postersOnBuildings.setSingleBuildingsArray(buildingsVec);


        assertEquals(3, postersOnBuildings.getNumberOfBuildings());
        assertEquals(2, postersOnBuildings.calculateNumberOfPosters());
    }

    @Test
    public void testThreeBuildingsDifferentHeight04() {

        SingleBuilding singleBuilding1 = new SingleBuilding(1, 2);
        SingleBuilding singleBuilding2 = new SingleBuilding(2, 1);
        SingleBuilding singleBuilding3 = new SingleBuilding(3, 2);
        SingleBuilding[] buildingsVec = { singleBuilding1, singleBuilding2, singleBuilding3 };
        postersOnBuildings.setSingleBuildingsArray(buildingsVec);


        assertEquals(3, postersOnBuildings.getNumberOfBuildings());
        assertEquals(3, postersOnBuildings.calculateNumberOfPosters());
    }

    @Test
    public void testThreeBuildingsDifferentHeight05() {

        SingleBuilding singleBuilding1 = new SingleBuilding(1, 1);
        SingleBuilding singleBuilding2 = new SingleBuilding(2, 1);
        SingleBuilding singleBuilding3 = new SingleBuilding(3, 2);
        SingleBuilding[] buildingsVec = { singleBuilding1, singleBuilding2, singleBuilding3 };
        postersOnBuildings.setSingleBuildingsArray(buildingsVec);


        assertEquals(3, postersOnBuildings.getNumberOfBuildings());
        assertEquals(2, postersOnBuildings.calculateNumberOfPosters());
    }

    @Test
    public void testFiveBuildings() {

        SingleBuilding singleBuilding1 = new SingleBuilding(1, 2);
        SingleBuilding singleBuilding2 = new SingleBuilding(2, 3);
        SingleBuilding singleBuilding3 = new SingleBuilding(3, 2);
        SingleBuilding singleBuilding4 = new SingleBuilding(4, 5);
        SingleBuilding singleBuilding5 = new SingleBuilding(5, 4);
        SingleBuilding[] buildingsVec = { singleBuilding1, singleBuilding2, singleBuilding3, singleBuilding4, singleBuilding5 };
        postersOnBuildings.setSingleBuildingsArray(buildingsVec);

        assertEquals(5, postersOnBuildings.getNumberOfBuildings());
        assertEquals(4, postersOnBuildings.calculateNumberOfPosters());
    }

    @Test
    public void testNineBuildings01() {

        SingleBuilding singleBuilding1 = new SingleBuilding(1, 1);
        SingleBuilding singleBuilding2 = new SingleBuilding(2, 2);
        SingleBuilding singleBuilding3 = new SingleBuilding(3, 3);
        SingleBuilding singleBuilding4 = new SingleBuilding(4, 5);
        SingleBuilding singleBuilding5 = new SingleBuilding(5, 3);
        SingleBuilding singleBuilding6 = new SingleBuilding(6, 5);
        SingleBuilding singleBuilding7 = new SingleBuilding(7, 3);
        SingleBuilding singleBuilding8 = new SingleBuilding(8, 2);
        SingleBuilding singleBuilding9 = new SingleBuilding(9, 1);
        SingleBuilding[] buildingsVec = { singleBuilding1, singleBuilding2, singleBuilding3, singleBuilding4, singleBuilding5,
                                          singleBuilding6, singleBuilding7, singleBuilding8, singleBuilding9 };
        postersOnBuildings.setSingleBuildingsArray(buildingsVec);

        assertEquals(9, postersOnBuildings.getNumberOfBuildings());
        assertEquals(5, postersOnBuildings.calculateNumberOfPosters());
    }


    @Test
    public void testNineBuildings02() {

        SingleBuilding singleBuilding1 = new SingleBuilding(1, 1);
        SingleBuilding singleBuilding2 = new SingleBuilding(2, 2);
        SingleBuilding singleBuilding3 = new SingleBuilding(3, 3);
        SingleBuilding singleBuilding4 = new SingleBuilding(4, 5);
        SingleBuilding singleBuilding5 = new SingleBuilding(5, 4);
        SingleBuilding singleBuilding6 = new SingleBuilding(6, 5);
        SingleBuilding singleBuilding7 = new SingleBuilding(7, 3);
        SingleBuilding singleBuilding8 = new SingleBuilding(8, 2);
        SingleBuilding singleBuilding9 = new SingleBuilding(9, 1);
        SingleBuilding[] buildingsVec = { singleBuilding1, singleBuilding2, singleBuilding3, singleBuilding4, singleBuilding5,
                                          singleBuilding6, singleBuilding7, singleBuilding8, singleBuilding9 };
        postersOnBuildings.setSingleBuildingsArray(buildingsVec);

        assertEquals(9, postersOnBuildings.getNumberOfBuildings());
        assertEquals(6, postersOnBuildings.calculateNumberOfPosters());
    }

    @Test
    public void testPyramid() {

        SingleBuilding singleBuilding1 = new SingleBuilding(1, 1);
        SingleBuilding singleBuilding2 = new SingleBuilding(2, 2);
        SingleBuilding singleBuilding3 = new SingleBuilding(3, 3);
        SingleBuilding singleBuilding4 = new SingleBuilding(4, 4);
        SingleBuilding singleBuilding5 = new SingleBuilding(5, 5);
        SingleBuilding singleBuilding6 = new SingleBuilding(6, 4);
        SingleBuilding singleBuilding7 = new SingleBuilding(7, 3);
        SingleBuilding singleBuilding8 = new SingleBuilding(8, 2);
        SingleBuilding singleBuilding9 = new SingleBuilding(9, 1);
        SingleBuilding[] buildingsVec = { singleBuilding1, singleBuilding2, singleBuilding3, singleBuilding4, singleBuilding5,
                                          singleBuilding6, singleBuilding7, singleBuilding8, singleBuilding9 };
        postersOnBuildings.setSingleBuildingsArray(buildingsVec);

        assertEquals(9, postersOnBuildings.getNumberOfBuildings());
        assertEquals(5, postersOnBuildings.calculateNumberOfPosters());
    }


    //section of tests of buildings from files
    @Test
    public void testPla0() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla0.in");
        int expectedValue = 4;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla1a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla1a.in");
        int expectedValue = 41;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla1b() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla1b.in");
        int expectedValue = 105;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla1c() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla1c.in");
        int expectedValue = 1;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla2a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla2a.in");
        int expectedValue = 718;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla2b() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla2b.in");
        int expectedValue = 662;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla2c() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla2c.in");
        int expectedValue = 4;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla3a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla3a.in");
        int expectedValue = 1190;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla3b() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla3b.in");
        int expectedValue = 2105;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla3c() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla3c.in");
        int expectedValue = 1705;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla4a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla4a.in");
        int expectedValue = 2201;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla4b() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla4b.in");
        int expectedValue = 3449;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime < 5000);
    }


    @Test
    public void testPla5a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla5a.in");
        int expectedValue = 105834;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime<5000);
    }

    @Test
    public void testPla5b() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla5b.in");
        int expectedValue = 107570;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime<5000);
    }

    @Test
    public void testPla6a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla6a.in");
        int expectedValue = 122285;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime<5000);
    }

    @Test
    public void testPla6b() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla6b.in");
        int expectedValue = 130604;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime<5000);
    }

    @Test
    public void testPla7a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla7a.in");
        int expectedValue = 133315;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime<5000);
    }

    @Test
    public void testPla7b() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla7b.in");
        int expectedValue = 149362;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime<5000);
    }

    @Test
    public void testPla8a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla8a.in");
        int expectedValue = 112754;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime<5000);
    }

    @Test
    public void testPla8b() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla8b.in");
        int expectedValue = 150254;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime<5000);
    }

    @Test
    public void testPla9a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla9a.in");
        int expectedValue = 174118;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime<5000);
    }

    @Test
    public void testPla9b() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla9b.in");
        int expectedValue = 148540;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime<5000);
    }

    @Test
    public void testPla10a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla10a.in");
        int expectedValue = 159396;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime<5000);
    }

    @Test
    public void testPla10b() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla10b.in");
        int expectedValue = 155393;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        assertTrue(diffTime<5000);
    }

}