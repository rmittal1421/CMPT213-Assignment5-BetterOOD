/**
 * Course contains it's course code such as couse code for this course is "CMPT 213"
 * It also contains a hashmap which stores information about all the offerings of this course in a given year of data.
 * Every offering is uniquely defined on the basis of semester and location of the offering. hence the key of
 * hashmap is the same.
 * @author Raghav Mittal
 */
package ca.model.blocks;

import ca.model.blocks.CourseFields.CourseCode;

public class Course {

    public static final int ARBITRARY_PRIME = 17;

    private CourseCode courseCode;
    private OfferingBlock offeringBlock = new OfferingBlock ();

    public Course (String department, String courseCode) {
        this.courseCode = new CourseCode (department, courseCode);
    }

    public void addOffering (String[] csvLine) {
        offeringBlock.add (csvLine);
    }

    public static int getHashCode (String courseCode) {
        return ARBITRARY_PRIME * courseCode.hashCode() + courseCode.length();
    }

    @Override
    public String toString () {
        return "\n" + courseCode +  offeringBlock;
    }
}
