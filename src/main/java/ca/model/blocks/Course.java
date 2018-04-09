/**
 * Course contains it's course code such as couse code for this course is "CMPT 213"
 * It also contains a hashmap which stores information about all the offerings of this course in a given year of data.
 * Every offering is uniquely defined on the basis of semester and location of the offering. hence the key of
 * hashmap is the same.
 * @author Raghav Mittal & Akansha Vaish
 */
package ca.model.blocks;

import ca.courseInfo.contollers.NoSuchResourceAvailable;
import ca.model.blocks.CourseFields.CourseCode;
import ca.model.blocks.CourseFields.Enrollment;
import ca.model.blocks.CourseFields.Semester;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Course implements Subject {

    public static final int ENROLL_CAP_INDEX = 4;
    public static final int ENROLL_TOTAL_INDEX = 5;
    public static final int SEMESTER_INDEX = 0;
    public static AtomicLong nextID = new AtomicLong();

    private long courseId;
    private CourseCode catalogNumber;
    private OfferingBlock offeringBlock = new OfferingBlock ();
    private List<Observer> listOfObservers = new ArrayList<>();

    public Course (String department, String catalogNumber, long courseId) {
        this.courseId = courseId;
        this.catalogNumber = new CourseCode (department, catalogNumber);
    }

    public void addOffering (String[] csvLine) {
        offeringBlock.add (csvLine);

        Enrollment enrollment = new Enrollment (csvLine [csvLine.length - 1],
                                                csvLine [ENROLL_CAP_INDEX],
                                                csvLine [ENROLL_TOTAL_INDEX]);

        Semester semester = new Semester (csvLine [SEMESTER_INDEX]);
        notifyObservers (enrollment, semester);
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
        return catalogNumber.getSubjectCode();
    }

    @JsonIgnore
    public OfferingBlock getOfferingBlock() {
        return offeringBlock;
    }

    @JsonIgnore
    public Offering getOffering (long offeringId) {
        for (Offering offering : offeringBlock.getOfferingBlock()) {
            if (offering.getCourseOfferingId() == offeringId) {
                return offering;
            }
        }

        throw new NoSuchResourceAvailable("Offering with id : " + offeringId + " doesn't exist.");
    }

    @JsonIgnore
    public List<Observer> getListOfObservers() {
        return listOfObservers;
    }

    @Override
    public String toString () {
        return "\n" + catalogNumber +  offeringBlock;
    }

    @Override
    public void registerObserver(Observer observer) {
        listOfObservers.add (observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        listOfObservers.remove (observer);
    }

    @Override
    public void notifyObservers (Enrollment enrollment, Semester semester) {
        for (Observer observer : listOfObservers) {
            observer.update (enrollment, semester);
        }
    }
}
