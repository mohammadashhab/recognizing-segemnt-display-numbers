import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * class to read and write to files
 */
public class FileReaderWriter {

    public ArrayList<Sequence> readFile(String fileName) {
        BufferedReader br = null;
        ArrayList<Sequence> sequences = new ArrayList<>();
        try {

            // create file object
            File file = new File(fileName);

            // create BufferedReader object from the File
            br = new BufferedReader(new java.io.FileReader(file));

            String line;
            int counter = 1;
            String[] lines = new String[3];

            // read file line by line
            while ((line = br.readLine()) != null) {
                if (counter == 4){
                    counter = 1;
                    Sequence sequence = new Sequence(Arrays.copyOf(lines, 3));
                    sequences.add(sequence);
                    continue;
                }
                lines[counter - 1] = line;
                ++counter;
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            // Always close the BufferedReader
            if (br != null) {
                try {
                    br.close();
                } catch (Exception ignored) {
                }

            }
        }
        return sequences;

    }

    /**
     *
     * @param fileName output filename
     * @param arr content to write
     */
    public void writeToFile(String fileName, ArrayList<String> arr){
        Path output = Paths.get(fileName);
        try {
            Files.write(output, arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
