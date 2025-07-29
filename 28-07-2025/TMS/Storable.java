import java.io.IOException;

interface Storable {
    void readFromFile (String fileName) throws IOException;
    void writeToFile (String fileName) throws IOException;


}
