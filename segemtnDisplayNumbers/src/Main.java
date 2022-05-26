import java.util.ArrayList;
import java.util.List;


public class Main {


    public static void main(String[] args) {
        String fileName = "C:\\Users\\m7md_\\OneDrive\\Desktop\\input_Q1b  (3) (1) (1).txt";
        FileReaderWriter fileReader = new FileReaderWriter();
        List<Sequence> sequences = fileReader.readFile(fileName);
        ArrayList<String> valueOfSequences = new ArrayList<>();
        for(Sequence seq : sequences){

            char[] chars = seq.getValueOfSequence();
            String val = String.valueOf(chars);
            if (val.contains("?")){
                val += " ILLEGAL";
            }
            valueOfSequences.add(val);
        }
        String outputFile = getOutputName(fileName);
        fileReader.writeToFile(outputFile, valueOfSequences);
    }

    /**
     * creating the output file name
     * @param fileName input file name
     * @return output file name
     */
    private static String getOutputName(String fileName){
        int index = fileName.lastIndexOf('\\');
        return fileName.substring(0, index + 1) + "output" + fileName.substring(index + 1);
    }
}
