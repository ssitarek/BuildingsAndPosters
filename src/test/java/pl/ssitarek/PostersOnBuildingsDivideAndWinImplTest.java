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
    public void testTheTime(){

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

        long millisTimeBeg = System.currentTimeMillis();
        postersOnBuildings.calculateNumberOfPosters();
        long millisTimeEnd = System.currentTimeMillis();
        long diffTime = millisTimeEnd-millisTimeBeg;
        Assert.assertTrue(diffTime<5000);
    }

    @Test
    public void testTheTimePla10a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla10a.in");
        long millisTimeBeg = System.currentTimeMillis();
        postersOnBuildings.calculateNumberOfPosters();

        long millisTimeEnd = System.currentTimeMillis();
        long diffTime = millisTimeEnd - millisTimeBeg;

        Assert.assertTrue(diffTime<5000);
    }

    @Test
    public void testTheTimePla9a() throws FileNotFoundException {

        postersOnBuildings.loadListFromFile("pla9a.in");
        long millisTimeBeg = System.currentTimeMillis();
        postersOnBuildings.calculateNumberOfPosters();

        long millisTimeEnd = System.currentTimeMillis();
        long diffTime = millisTimeEnd - millisTimeBeg;

        Assert.assertTrue(diffTime<5000);
    }
}