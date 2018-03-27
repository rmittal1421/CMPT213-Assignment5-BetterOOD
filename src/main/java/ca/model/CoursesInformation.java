package ca.model;

public class CoursesInformation {

    public static void main (String[] args) {
        CSVreader csvFile = new CSVreader ("/Users/rmittal/Desktop/MY_SFU/CMPT213/Assignment5/Project/docs/course_data_2018.csv");
        csvFile.printResults();
    }
}
