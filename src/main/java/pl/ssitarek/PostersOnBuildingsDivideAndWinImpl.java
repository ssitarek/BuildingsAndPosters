package pl.ssitarek;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PostersOnBuildingsDivideAndWinImpl implements PostersOnBuildings {

    private int numberOfBuildings = 0;
    private int numberOfPosters = 0;

    private List<Building> buildingArrayList = new ArrayList<>();

    @Override
    public void loadListFromFile(String fileName) throws FileNotFoundException {


        Scanner s = new Scanner(new File(fileName));
        String singleLine = s.nextLine();
        int totalNumber = Integer.parseInt(singleLine);
        for (int i = 0; i < totalNumber; i++) {
            singleLine = s.nextLine();
            String[] strings = singleLine.split(" ");
            if (strings.length == 2) {
                int width = Integer.parseInt(strings[0]);
                int height = Integer.parseInt(strings[1]);
                buildingArrayList.add(new Building(width, height));
            }
        }
        numberOfBuildings = buildingArrayList.size();
    }

    @Override
    public void saveResultToFile(String fileName) throws FileNotFoundException {

        PrintWriter printWriter = new PrintWriter(fileName);
        printWriter.println(Integer.toString(numberOfPosters));
        printWriter.close();
    }

    /**
     * calculate the total number of posters using divide and win method
     */

    @Override
    public int calculateNumberOfPosters() {

        if (numberOfBuildings <= 0) {
            return 0;
        }
        //in case of one building do not calculate, just return single poster
        if (numberOfBuildings == 1) {
            return 1;
        }
        if (numberOfBuildings == 2) {
            if (buildingArrayList.get(0).getHeight() != buildingArrayList.get(1).getHeight()) {
                return 2;
            }
            return 1;
        }


        List<List<Integer>> listArrayList = new ArrayList<>();
        listArrayList.add(getAllBuildingHeights());
        while (listArrayList.size() != 0) {

            List<List<Integer>> splittedHeightsList = splitTheList(listArrayList.get(0));
            for (int i = 0; i < splittedHeightsList.size(); i++) {
                listArrayList.add(splittedHeightsList.get(i));
            }
            listArrayList.remove(0);
            numberOfPosters++;
        }
        return numberOfPosters;
    }

    /**
     * gets all heights from buildingArrayList
     *
     * @return list of heights of buildings
     */
    private List<Integer> getAllBuildingHeights() {

        List<Integer> heightList = new ArrayList<>(buildingArrayList.size());
        for (int i = 0; i < buildingArrayList.size(); i++) {
            heightList.add(buildingArrayList.get(i).getHeight());
        }
        return heightList;
    }

    /**
     * split a list of buildings into the parts, the condition is that their heights are higher than minimum value
     *
     * @param inputList list of neighbour buildings heights
     * @return list of the top of the buildings
     */
    private List<List<Integer>> splitTheList(List<Integer> inputList) {

        List<List<Integer>> splitedList = new ArrayList<>();
        int minOfList = Collections.min(inputList);
        int ind = inputList.indexOf(minOfList);

        while (ind != -1) {
            if (ind != 0) {
                List<Integer> subList = inputList.subList(0, ind);
                splitedList.add(subList);

            }
            inputList = inputList.subList(ind + 1, inputList.size());
            ind = inputList.indexOf(minOfList);
        }
        if ((ind == -1) && (inputList.size() >= 1)) {
            splitedList.add(inputList);

        }
        return splitedList;
    }

    public int getNumberOfBuildings() {
        return numberOfBuildings;
    }

    public int getNumberOfPosters() {
        return numberOfPosters;
    }

    public void setBuildingArrayList(List<Building> buildingArrayList) {
        this.buildingArrayList = buildingArrayList;
        this.numberOfBuildings = buildingArrayList.size();
    }
}
