package ca.model;

import ca.model.blocks.DepartmentBlock;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVreader {
    public final String separatedBy = ",";

    private String filePath;
    private BufferedReader readerFromCSV = null;

    //HashMap struct to store information
    private ca.model.blocks.DepartmentBlock DepartmentBlock = new DepartmentBlock();

    public CSVreader (String filePath) {
        this.filePath = filePath;
        readLineByLine (filePath);
    }

    private void readLineByLine(String filePath) {
        String line;
        try {
            readerFromCSV = new BufferedReader (new FileReader(filePath));

            readerFromCSV.readLine();
            while ((line = readerFromCSV.readLine()) != null) {
                String[] csvLine = line.split (separatedBy);
                FancyTrimObject(csvLine);

                DepartmentBlock.add (csvLine);
            }

            readerFromCSV.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    //Meaning of word Fancy Trim is that it trims all the strings and also does additional work.
    //That is, it removes all the unwanted characters from the strings read such as ".
    private void FancyTrimObject(String[] object) {
        for (int i = 0; i < object.length; i++) {
            object[i] = object[i].replace("\"", "").trim();
        }
    }

    public void printResults() {
        DepartmentBlock.printAllEntries();
    }
}
