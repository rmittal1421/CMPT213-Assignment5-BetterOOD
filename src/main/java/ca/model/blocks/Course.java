package ca.model.blocks;

import ca.model.blocks.CourseFields.CourseCode;

import java.util.concurrent.atomic.AtomicInteger;

public class Course {

    private static AtomicInteger nextID = new AtomicInteger();

    private CourseCode courseCode;
    private int courseID;
    private OfferingBlock offeringBlock = new OfferingBlock ();

    public Course (String department, String courseCode) {
        courseID = nextID.incrementAndGet();
        this.courseCode = new CourseCode (department, courseCode);
    }

    public void addOffering (String[] csvLine) {
        offeringBlock.add (csvLine);
    }

    public CourseCode getCourseCode() {
        return courseCode;
    }

    public static int getHashCode (String courseCode) {
        return 17 * courseCode.hashCode() + courseCode.length();
    }

    public void print () {
        courseCode.print();
        offeringBlock.print ();
    }

//    @Override
//    public int hashCode () {
//        return getHashCode ();
//    }
}
