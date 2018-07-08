package pl.ssitarek;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class PostersOnBuildingsPointerListImpl implements PostersOnBuildings {

    private Element[] elementsArray;
    private SingleBuilding[] singleBuildingsArray;
    private int numberOfPosters;
    private int numberOfBuildings;

    //constructor is not necessary due to the fact that an empty constructor is default one

    private void createElementsArray() {

        elementsArray = new Element[numberOfBuildings + 2];
        elementsArray[0] = new Element(-1, 1, 0);
        for (int i = 1; i <= numberOfBuildings; ++i) {
            elementsArray[i] = new Element(singleBuildingsArray[i - 1].getHeight(), i + 1, i - 1);
        }
        elementsArray[numberOfBuildings + 1] = new Element(-1, numberOfBuildings + 1, numberOfBuildings);
    }

    private int getNextElementValue(int inElementNumber) {

        Element thisElement = elementsArray[inElementNumber];
        return elementsArray[thisElement.getNext()].getValue();
    }

    private void makeElementInactive(int inElementNumber) {

        Element thisElement = elementsArray[inElementNumber];
        //set new value of the nextElement.previous field
        elementsArray[thisElement.getNext()].setPrevious(thisElement.getPrevious());
        //set new value of the previousElement.next field
        elementsArray[thisElement.getPrevious()].setNext(thisElement.getNext());
    }


    /**
     * method calculates total number of posters
     * using pointerList implementation
     *
     * @return numberOfPosters that are necessary to cover all buildings
     *
     * in case of calculations done, it is possible to get numberOfPosters
     * using proper "get" method i.e. getNumberOfPosters
     */

    @Override
    public int calculateNumberOfPosters() {

        try {
            createElementsArray();
            Arrays.sort(singleBuildingsArray);

            for (int i = 0; i < numberOfBuildings; ++i) {
                int elementNumber = singleBuildingsArray[i].getNumber();
                if (elementsArray[elementNumber].getValue() != getNextElementValue(elementNumber)) {
                    numberOfPosters++;
                }
                makeElementInactive(elementNumber);
            }
            return numberOfPosters;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * method loads the file with the data from the hard drive
     *
     * @param fileName the name of the file that contains proper data
     * @throws FileNotFoundException in case of file not exists
     */

    @Override
    public void loadListFromFile(String fileName) throws FileNotFoundException {

        Scanner s = new Scanner(new File(fileName));
        String singleLine = s.nextLine();
        numberOfBuildings = Integer.parseInt(singleLine);
        singleBuildingsArray = new SingleBuilding[numberOfBuildings];
        for (int i = 0; i < numberOfBuildings; i++) {
            singleLine = s.nextLine();
            String[] strings = singleLine.split(" ");
            if (strings.length == 2) {
                singleBuildingsArray[i] = new SingleBuilding(i + 1, Integer.parseInt(strings[1]));
            }
        }
    }


    /**
     * method saves the file with the result
     *
     * @param fileName the name of the file with result
     * @throws FileNotFoundException  in case of file not exists
     */

    @Override
    public void saveResultToFile(String fileName) throws FileNotFoundException {

        PrintWriter printWriter = new PrintWriter(fileName);
        printWriter.println(Integer.toString(numberOfPosters));
        printWriter.close();
    }

    public void setSingleBuildingsArray(SingleBuilding[] singleBuildingsArray) {

        this.singleBuildingsArray = singleBuildingsArray;
        this.numberOfBuildings = singleBuildingsArray.length;
    }

    public int getNumberOfBuildings() {

        return numberOfBuildings;
    }

    public int getNumberOfPosters() {

        return numberOfPosters;
    }
}
