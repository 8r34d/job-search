package spencer.dean.jobsearch;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Data {

    public static Iterator<String[]> getIteratorCsv(String csvFile) {
        return getIteratorCsvSkipLine(csvFile, CSVReader.DEFAULT_SKIP_LINES);
    }

    public static Iterator<String[]> getIteratorCsvSkipLine(String csvFile, int skipLine) {
        CSVReader reader = null;
        List<String[]> data = null;
        try {
            reader = new CSVReader(new FileReader(csvFile), ',', '\'', skipLine);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            data = reader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return (Iterator<String[]>) data.iterator();
    }
}