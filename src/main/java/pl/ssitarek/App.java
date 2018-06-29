package pl.ssitarek;

import java.io.FileNotFoundException;

public class App {

    public static final String DEFAULT_FILE_NAME_IN = "pla.in";
    public static final String DEFAULT_FILE_NAME_OUT = "pla.out";


    public static void main(String[] args) {

        try {
            PostersOnBuildingsDivideAndWinImpl postersOnBuildings = new PostersOnBuildingsDivideAndWinImpl();

            long millisTimeBeg = System.currentTimeMillis();
            postersOnBuildings.loadListFromFile(DEFAULT_FILE_NAME_IN);
            postersOnBuildings.calculateNumberOfPosters();
            postersOnBuildings.saveResultToFile(DEFAULT_FILE_NAME_OUT);
            long millisTimeEnd = System.currentTimeMillis();
            long diffTime = millisTimeEnd - millisTimeBeg;
            System.out.println("Result has been saved to: " + DEFAULT_FILE_NAME_OUT);
            System.out.println("Total operation time including load and save given in ms: " + diffTime);

        } catch (FileNotFoundException ex) {
            System.out.println("Please Load Proper File");
        } catch (NumberFormatException ex) {
            System.out.println("Please check the content of the file, there should be numbers only");
        }
    }
}
