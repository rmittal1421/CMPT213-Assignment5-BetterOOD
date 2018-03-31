/**
 * Every course has different offerings which are stored in offering block and each offering contains all the
 * information about that course's offering such as semester and location of that offering, who offered the course
 * and what was the enrollement like for different component codes such as LEC, TUT etc.
 * @author Raghav Mittal
 */
package ca.model.blocks;

import ca.model.blocks.CourseFields.*;

import java.util.concurrent.atomic.AtomicLong;

public class Offering {

    public static AtomicLong nextID = new AtomicLong();

    private long offeringId;
    private Semester semester;
    private YearAndLocation yearAndLocation;
    private Professor professors = new Professor();
    private ComponentCode compCode = new ComponentCode();

    public Offering (String semester, String location, long offeringId) {
        this.offeringId = offeringId;
        this.semester = new Semester (semester);
        yearAndLocation = new YearAndLocation (semester, location);
    }

    public static String hash (String semester, String location) {
        return (semester + location);
    }

    public void add(String[] csvLine) {

        for (int index = 6; index < csvLine.length - 1; index++) {
            professors.add (csvLine [index]);
        }

        int enrollCapacity = Integer.parseInt(csvLine[4]);
        int enrollTotal = Integer.parseInt(csvLine[5]);

        compCode.add(csvLine[csvLine.length - 1], new Enrollment(enrollCapacity, enrollTotal));
    }

    public static long getNextID () {
        return nextID.incrementAndGet();
    }

    public long getOfferingId() {
        return offeringId;
    }

    public String getLocation () {
        return yearAndLocation.getLocation();
    }

    public Professor getProfessors() {
        return professors;
    }

    public Semester getSemester() {
        return semester;
    }

    @Override
    public String toString () {
        return yearAndLocation + " by " + professors + compCode;
    }
}
