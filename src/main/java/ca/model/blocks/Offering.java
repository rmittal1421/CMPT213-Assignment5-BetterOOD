package ca.model.blocks;

import ca.model.blocks.CourseFields.*;

import java.util.concurrent.atomic.AtomicInteger;

public class Offering {

    private static AtomicInteger offeringID = new AtomicInteger();

    private Semester semester;
    private YearAndLocation yearAndLocation;
    private Professor professors = new Professor();
    private ComponentCode compCode = new ComponentCode();

    public Offering (String semester, String location) {
        this.semester = new Semester (semester);
        yearAndLocation = new YearAndLocation (semester, location);
    }

    public static int getHashCode (String semester, String location) {
        return 17 * semester.hashCode() + location.hashCode();
    }

    public void add(String[] csvLine) {

        for (int index = 6; index < csvLine.length - 1; index++) {
            professors.add (csvLine [index]);
        }

        int enrollCapacity = Integer.parseInt(csvLine[4]);
        int enrollTotal = Integer.parseInt(csvLine[5]);

        compCode.add(csvLine[csvLine.length - 1], new Enrollment(enrollCapacity, enrollTotal));
    }

    public void print() {
        semester.print();
        System.out.print (" by ");
        professors.print();
        compCode.print();
    }
}
