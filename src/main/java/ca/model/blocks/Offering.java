/**
 * Every course has different offerings which are stored in offering block and each offering contains all the
 * information about that course's offering such as semester and location of that offering, who offered the course
 * and what was the enrollement like for different component codes such as LEC, TUT etc.
 * @author Raghav Mittal
 */
package ca.model.blocks;

import ca.model.blocks.CourseFields.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Offering {

    public static AtomicLong nextID = new AtomicLong();

    private long courseOfferingId;
    private Semester semester;
    private YearAndLocation yearAndLocation;
    private Professor instructors = new Professor();
    private ComponentCode compCode = new ComponentCode();

    public Offering (String semester, String location, long courseOfferingId) {
        this.courseOfferingId = courseOfferingId;
        this.semester = new Semester (semester);
        yearAndLocation = new YearAndLocation (semester, location);
    }

    public static String hash (String semester, String location) {
        return (semester + location);
    }

    public void add(String[] csvLine) {

        for (int index = 6; index < csvLine.length - 1; index++) {
            instructors.add (csvLine [index]);
        }

        int enrollCapacity = Integer.parseInt(csvLine[4]);
        int enrollTotal = Integer.parseInt(csvLine[5]);

        String componentCode = csvLine [csvLine.length - 1];
        compCode.add (componentCode, new Enrollment(componentCode, enrollCapacity, enrollTotal));
    }

    public static long getNextID () {
        return nextID.incrementAndGet();
    }

    public long getCourseOfferingId() {
        return courseOfferingId;
    }

    public String getLocation () {
        return yearAndLocation.getLocation();
    }

    public String getInstructors() {
        return "" + instructors;
    }

    public int getyear() {
        return semester.getYear();
    }

    public int getSemesterCode () {
        return semester.getSemesterCode()*10 + semester.getSfuSemester();
    }

    public String getTerm () {
        return semester.getTerm();
    }

    @JsonIgnore
    public List<Enrollment> getCompCode () {
        return compCode.getEnrollment();
    }

    @Override
    public String toString () {
        return yearAndLocation + " by " + instructors + compCode;
    }
}
