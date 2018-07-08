package pl.ssitarek;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class PostersOnBuildingsDivideAndWinImplTest {


    private PostersOnBuildingsDivideAndWinImpl postersOnBuildings;

    @Before
    public void setUp() {
        postersOnBuildings = new PostersOnBuildingsDivideAndWinImpl();
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
    public void testNoBuildings() {

        List<Building> buildingArrayList = new ArrayList<>();

        postersOnBuildings.setBuildingArrayList(buildingArrayList);

        Assert.assertEquals(0, postersOnBuildings.getNumberOfBuildings());
        Assert.assertEquals(0, postersOnBuildings.calculateNumberOfPosters());
    }

    @Test
    public void testOneBuilding() {

        Building building = new Building(1, 1);

        List<Building> buildingArrayList = new ArrayList<>();
        buildingArrayList.add(building);

        postersOnBuildings.setBuildingArrayList(buildingArrayList);

        Assert.assertEquals(1, postersOnBuildings.getNumberOfBuildings());
        Assert.assertEquals(1, postersOnBuildings.calculateNumberOfPosters());
    }

    @Test
    public void testTwoBuildingsDifferentHeight() {

        Building building1 = new Building(1, 1);
        Building building2 = new Building(1, 2);

        List<Building> buildingArrayList = new ArrayList<>();
        buildingArrayList.add(building1);
        buildingArrayList.add(building2);

        postersOnBuildings.setBuildingArrayList(buildingArrayList);

        Assert.assertEquals(2, postersOnBuildings.getNumberOfBuildings());
        Assert.assertEquals(2, postersOnBuildings.calculateNumberOfPosters());
    }

    @Test
    public void testTwoBuildingsDifferentWidth() {

        Building building1 = new Building(1, 1);
        Building building2 = new Building(2, 1);

        List<Building> buildingArrayList = new ArrayList<>();
        buildingArrayList.add(building1);
        buildingArrayList.add(building2);

        postersOnBuildings.setBuildingArrayList(buildingArrayList);

        Assert.assertEquals(2, postersOnBuildings.getNumberOfBuildings());
        Assert.assertEquals(1, postersOnBuildings.calculateNumberOfPosters());
    }

    @Test
    public void testTwoBuildingsDifferentSizes() {

        Building building1 = new Building(1, 2);
        Building building2 = new Building(2, 1);

        List<Building> buildingArrayList = new ArrayList<>();
        buildingArrayList.add(building1);
        buildingArrayList.add(building2);

        postersOnBuildings.setBuildingArrayList(buildingArrayList);

        Assert.assertEquals(2, postersOnBuildings.getNumberOfBuildings());
        Assert.assertEquals(2, postersOnBuildings.calculateNumberOfPosters());
    }

    @Test
    public void testThreeBuildingsDifferentSizes01() {

        Building building1 = new Building(1, 1);
        Building building2 = new Building(1, 2);
        Building building3 = new Building(1, 3);

        List<Building> buildingArrayList = new ArrayList<>();
        buildingArrayList.add(building1);
        buildingArrayList.add(building2);
        buildingArrayList.add(building3);

        postersOnBuildings.setBuildingArrayList(buildingArrayList);

        Assert.assertEquals(3, postersOnBuildings.getNumberOfBuildings());
        Assert.assertEquals(3, postersOnBuildings.calculateNumberOfPosters());
    }

    @Test
    public void testThreeBuildingsDifferentSizes02() {

        Building building1 = new Building(1, 3);
        Building building2 = new Building(1, 2);
        Building building3 = new Building(1, 1);

        List<Building> buildingArrayList = new ArrayList<>();
        buildingArrayList.add(building1);
        buildingArrayList.add(building2);
        buildingArrayList.add(building3);

        postersOnBuildings.setBuildingArrayList(buildingArrayList);

        Assert.assertEquals(3, postersOnBuildings.getNumberOfBuildings());
        Assert.assertEquals(3, postersOnBuildings.calculateNumberOfPosters());
    }

    @Test
    public void testThreeBuildingsDifferentSizes03() {

        Building building1 = new Building(1, 1);
        Building building2 = new Building(1, 2);
        Building building3 = new Building(1, 1);

        List<Building> buildingArrayList = new ArrayList<>();
        buildingArrayList.add(building1);
        buildingArrayList.add(building2);
        buildingArrayList.add(building3);

        postersOnBuildings.setBuildingArrayList(buildingArrayList);

        Assert.assertEquals(3, postersOnBuildings.getNumberOfBuildings());
        Assert.assertEquals(2, postersOnBuildings.calculateNumberOfPosters());
    }

    @Test
    public void testThreeBuildingsDifferentSizes04() {

        Building building1 = new Building(1, 2);
        Building building2 = new Building(1, 1);
        Building building3 = new Building(1, 2);

        List<Building> buildingArrayList = new ArrayList<>();
        buildingArrayList.add(building1);
        buildingArrayList.add(building2);
        buildingArrayList.add(building3);

        postersOnBuildings.setBuildingArrayList(buildingArrayList);

        Assert.assertEquals(3, postersOnBuildings.getNumberOfBuildings());
        Assert.assertEquals(3, postersOnBuildings.calculateNumberOfPosters());
    }

    @Test
    public void testFiveBuildings() {

        Building building1 = new Building(1, 2);
        Building building2 = new Building(1, 3);
        Building building3 = new Building(2, 2);
        Building building4 = new Building(2, 5);
        Building building5 = new Building(1, 4);

        List<Building> buildingArrayList = new ArrayList<>();
        buildingArrayList.add(building1);
        buildingArrayList.add(building2);
        buildingArrayList.add(building3);
        buildingArrayList.add(building4);
        buildingArrayList.add(building5);


        postersOnBuildings.setBuildingArrayList(buildingArrayList);

        Assert.assertEquals(5, postersOnBuildings.getNumberOfBuildings());
        Assert.assertEquals(4, postersOnBuildings.calculateNumberOfPosters());
    }

    @Test
    public void testNineBuildings01() {

        Building building1 = new Building(1, 1);
        Building building2 = new Building(1, 2);
        Building building3 = new Building(2, 3);
        Building building4 = new Building(2, 5);
        Building building5 = new Building(1, 3);
        Building building6 = new Building(1, 5);
        Building building7 = new Building(1, 3);
        Building building8 = new Building(1, 2);
        Building building9 = new Building(1, 1);

        List<Building> buildingArrayList = new ArrayList<>();
        buildingArrayList.add(building1);
        buildingArrayList.add(building2);
        buildingArrayList.add(building3);
        buildingArrayList.add(building4);
        buildingArrayList.add(building5);
        buildingArrayList.add(building6);
        buildingArrayList.add(building7);
        buildingArrayList.add(building8);
        buildingArrayList.add(building9);


        postersOnBuildings.setBuildingArrayList(buildingArrayList);

        Assert.assertEquals(9, postersOnBuildings.getNumberOfBuildings());
        Assert.assertEquals(5, postersOnBuildings.calculateNumberOfPosters());
    }

    @Test
    public void testNineBuildings02() {

        Building building1 = new Building(1, 1);
        Building building2 = new Building(1, 2);
        Building building3 = new Building(2, 3);
        Building building4 = new Building(2, 5);
        Building building5 = new Building(1, 4);
        Building building6 = new Building(1, 5);
        Building building7 = new Building(1, 3);
        Building building8 = new Building(1, 2);
        Building building9 = new Building(1, 1);

        List<Building> buildingArrayList = new ArrayList<>();
        buildingArrayList.add(building1);
        buildingArrayList.add(building2);
        buildingArrayList.add(building3);
        buildingArrayList.add(building4);
        buildingArrayList.add(building5);
        buildingArrayList.add(building6);
        buildingArrayList.add(building7);
        buildingArrayList.add(building8);
        buildingArrayList.add(building9);

        postersOnBuildings.setBuildingArrayList(buildingArrayList);

        Assert.assertEquals(9, postersOnBuildings.getNumberOfBuildings());
        Assert.assertEquals(6, postersOnBuildings.calculateNumberOfPosters());
    }

    @Test
    public void testPyramid01() {

        Building building1 = new Building(1, 1);
        Building building2 = new Building(1, 2);
        Building building3 = new Building(1, 3);
        Building building4 = new Building(1, 4);
        Building building5 = new Building(1, 5);
        Building building6 = new Building(1, 4);
        Building building7 = new Building(1, 3);
        Building building8 = new Building(1, 2);
        Building building9 = new Building(1, 1);

        List<Building> buildingArrayList = new ArrayList<>();
        buildingArrayList.add(building1);
        buildingArrayList.add(building2);
        buildingArrayList.add(building3);
        buildingArrayList.add(building4);
        buildingArrayList.add(building5);
        buildingArrayList.add(building6);
        buildingArrayList.add(building7);
        buildingArrayList.add(building8);
        buildingArrayList.add(building9);


        postersOnBuildings.setBuildingArrayList(buildingArrayList);

        Assert.assertEquals(9, postersOnBuildings.getNumberOfBuildings());
        Assert.assertEquals(5, postersOnBuildings.calculateNumberOfPosters());
    }

    //section of tests of the singleBuildingVec files
    @Test
    public void testPla0() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla0.in");
        int expectedValue = 4;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla1a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla1a.in");
        int expectedValue = 41;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla1b() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla1b.in");
        int expectedValue = 105;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla1c() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla1c.in");
        int expectedValue = 1;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla2a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla2a.in");
        int expectedValue = 718;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla2b() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla2b.in");
        int expectedValue = 662;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla2c() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla2c.in");
        int expectedValue = 4;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla3a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla3a.in");
        int expectedValue = 1190;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla3b() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla3b.in");
        int expectedValue = 2105;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla3c() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla3c.in");
        int expectedValue = 1705;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla4a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla4a.in");
        int expectedValue = 2201;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla4b() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla4b.in");
        int expectedValue = 3449;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla5a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla5a.in");
        int expectedValue = 105834;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime < 5000);
    }

    @Test
    public void testPla5b() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla5b.in");
        int expectedValue = 107570;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime < 5000);
    }
/*
    @Test
    public void testPla6a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla6a.in");
        int expectedValue = 122285;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime<5000);
    }

    @Test
    public void testPla6b() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla6b.in");
        int expectedValue = 130604;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime<5000);
    }

    @Test
    public void testPla7a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla7a.in");
        int expectedValue = 133315;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime<5000);
    }

    @Test
    public void testPla7b() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla7b.in");
        int expectedValue = 149362;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime<5000);
    }

    @Test
    public void testPla8a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla8a.in");
        int expectedValue = 112754;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime<5000);
    }

    @Test
    public void testPla8b() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla8b.in");
        int expectedValue = 150254;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime<5000);
    }

    @Test
    public void testPla9a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla9a.in");
        int expectedValue = 174118;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime<5000);
    }

    @Test
    public void testPla9b() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla9b.in");
        int expectedValue = 148540;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime<5000);
    }

    @Test
    public void testPla10a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla10a.in");
        int expectedValue = 159396;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime<5000);
    }

    @Test
    public void testPla10b() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla10b.in");
        int expectedValue = 155393;

        long millisTimeBeg = System.currentTimeMillis();
        int result = postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();

        Assert.assertEquals(expectedValue, result);

        long diffTime = millisTimeEnd - millisTimeBeg;
        Assert.assertTrue(diffTime<5000);
    }
    */
}