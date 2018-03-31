/**
 * Course contains it's course code such as couse code for this course is "CMPT 213"
 * It also contains a hashmap which stores information about all the offerings of this course in a given year of data.
 * Every offering is uniquely defined on the basis of semester and location of the offering. hence the key of
 * hashmap is the same.
 * @author Raghav Mittal
 */
package ca.model.blocks;

import ca.model.blocks.CourseFields.CourseCode;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.concurrent.atomic.AtomicLong;

public class Course {

    public static final int ARBITRARY_PRIME = 17;
    public static AtomicLong nextID = new AtomicLong();

    private long courseId;
    private CourseCode courseCode;
    private OfferingBlock offeringBlock = new OfferingBlock ();

    public Course (String department, String courseCode, long courseId) {
        this.courseId = courseId;
        this.courseCode = new CourseCode (department, courseCode);
    }

    public void addOffering (String[] csvLine) {
        offeringBlock.add (csvLine);
    }

    public static String getHashCode (String courseCode) {
        return courseCode;
    }

    public static long getNextID () {
        return nextID.incrementAndGet();
    }

    public long getCourseId () {
        return this.courseId;
    }

    public String getCatalogNumber () {
        return courseCode.getSubjectCode();
    }

    @JsonIgnore
    public OfferingBlock getOfferningBlock() {
        return offeringBlock;
    }

    @Override
    public String toString () {
        return "\n" + courseCode +  offeringBlock;
    }
}
