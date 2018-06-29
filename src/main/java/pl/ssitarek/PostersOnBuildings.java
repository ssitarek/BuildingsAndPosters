package pl.ssitarek;

import java.io.FileNotFoundException;

public interface PostersOnBuildings {

    void loadListFromFile(String fileName) throws FileNotFoundException;

    void saveResultToFile(String fileName) throws FileNotFoundException;

    int calculateNumberOfPosters();

}
