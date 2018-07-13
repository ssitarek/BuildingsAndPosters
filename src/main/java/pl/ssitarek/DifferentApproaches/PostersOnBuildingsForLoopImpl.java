package pl.ssitarek;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PostersOnBuildingsForLoopImpl implements PostersOnBuildings {

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


    @Override
    public int calculateNumberOfPosters() {

        if (buildingArrayList.size() == 0) {
            return 0;
        }
        if (buildingArrayList.size() == 1) {
            return 1;
        }
        if (buildingArrayList.size() == 2) {
            if (buildingArrayList.get(0).getHeight() != buildingArrayList.get(1).getHeight()) {
                return 2;
            }
            return 1;
        }
        int[]buildingVec = getAllBuildingHeights();

        int[] sorted = buildingVec.clone();
        Arrays.sort(sorted);
        int minValue = sorted[0];

        for (int i = 0; i < buildingVec.length; i++) {
            buildingVec[i] -= minValue;
        }
        numberOfPosters++;

        for (int i = 0; i < buildingVec.length; i++) {
            while (buildingVec[i] != 0) {
                //find new min

                minValue = sorted[sorted.length - 1];
                for (int j = i; j < buildingVec.length; j++) {
                    if ((buildingVec[j] != 0) && (buildingVec[j] <= minValue)) {
                        minValue = buildingVec[j];
                    }
                    if (buildingVec[j] == 0) {
                        break;
                    }
                }
                for (int j = i; j < buildingVec.length; j++) {
                    if (buildingVec[j] == 0) {
                        break;
                    }
                    if (buildingVec[j] != 0) {
                        buildingVec[j] -= minValue;
                    }
                }
                numberOfPosters++;
            }
        }
        return numberOfPosters;
    }

    /**
     * gets all heights from buildingArrayList
     *
     * @return list of heights of buildings
     */
    private int[] getAllBuildingHeights() {

        int[] heightList = new int[buildingArrayList.size()];
        for (int i = 0; i < buildingArrayList.size(); i++) {
            heightList[i] =buildingArrayList.get(i).getHeight();
        }
        return heightList;
    }

    public int getNumberOfBuildings() {
        return numberOfBuildings;
    }

    public int getNumberOfPosters() {
        return numberOfPosters;
    }

    public void setNumberOfBuildings(int numberOfBuildings) {
        this.numberOfBuildings = numberOfBuildings;
    }

    public void setNumberOfPosters(int numberOfPosters) {
        this.numberOfPosters = numberOfPosters;
    }

    public void setBuildingArrayList(List<Building> buildingArrayList) {
        this.buildingArrayList = buildingArrayList;
        this.numberOfBuildings = buildingArrayList.size();
    }
}
