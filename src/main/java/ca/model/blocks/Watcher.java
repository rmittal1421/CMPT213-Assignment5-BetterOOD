/**
 * Watcher class is the class implementing the observer pattern and hence is the one which is actually observing.
 * It is observing on a course and a course has a list which keeps all the watchers inside of it.
 *
 * @author Akansha Vaish & Raghav Mittal
 */
package ca.model.blocks;

import ca.model.blocks.CourseFields.Enrollment;
import ca.model.blocks.CourseFields.Semester;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Watcher implements Observer {

    public static AtomicLong watcherId = new AtomicLong();

    private long id = getNextID();
    private Department department;
    private Course course;
    private List<String> events = new ArrayList<>();

    public Watcher (Department dept, Course course) {
        this.department = dept;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Course getCourse () {
        return course;
    }

    public void setCourse (Course course) {
        this.course = course;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    public static long getNextID () {
        return watcherId.incrementAndGet();
    }

    @Override
    public void update (Enrollment enrollment, Semester semester) {
        String event = (new Date()).toString() + ": Added section " + enrollment.getType()
                + " with enrollment (" + enrollment.getEnrollmentTotal() + "/"
                + enrollment.getEnrollmentCap() + ") to offering "
                + semester.getTerm() + " " + semester.getYear();

        events.add (event);
    }
}
