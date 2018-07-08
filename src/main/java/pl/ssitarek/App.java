package pl.ssitarek;

import java.io.FileNotFoundException;

public class App {

    public static final String DEFAULT_FILE_NAME_IN = "pla.in";
    public static final String DEFAULT_FILE_NAME_OUT = "pla.out";


    public static void main(String[] args) {

        try {
            PostersOnBuildingsPointerListImpl postersOnBuildings = new PostersOnBuildingsPointerListImpl();

            postersOnBuildings.loadListFromFile(DEFAULT_FILE_NAME_IN);

            long millisTimeBeg = System.currentTimeMillis();
            postersOnBuildings.calculateNumberOfPosters();
            long millisTimeEnd = System.currentTimeMillis();
            long diffTime = millisTimeEnd - millisTimeBeg;

            postersOnBuildings.saveResultToFile(DEFAULT_FILE_NAME_OUT);
            System.out.println(String.format("Loaded file: \"%s\"", DEFAULT_FILE_NAME_IN));
            System.out.println(String.format("Number of posters: %d", postersOnBuildings.getNumberOfPosters()));
            System.out.println(String.format("Result has been saved to: \"%s\"", DEFAULT_FILE_NAME_OUT));
            System.out.println(String.format("Total operation time without load and save given in ms: %d", diffTime));

        } catch (FileNotFoundException ex) {
            System.out.println("Please Load Proper File");
        } catch (NumberFormatException ex) {
            System.out.println("Please check the content of the file, there should be numbers only");
        }
    }
}
