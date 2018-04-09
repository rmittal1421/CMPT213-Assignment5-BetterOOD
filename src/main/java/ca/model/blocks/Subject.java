/**
 * Subject is the interface designed to create a Observer pattern. Course class is implementing it and it means that
 * course is the subject or we can say that course is the thing observed by all the observers it has.
 * Anytime any changes are made to a course, every observer observing this subject is notified.
 *
 * @author Raghav Mittal
 */
package ca.model.blocks;

import ca.model.blocks.CourseFields.Enrollment;
import ca.model.blocks.CourseFields.Semester;

public interface Subject {
    public void registerObserver (Observer observer);
    public void removeObserver (Observer observer);
    public void notifyObservers (Enrollment enrollment, Semester semester);
}
