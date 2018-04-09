/**
 * Observer interface is designed so that any kind of observer can observe the subject.
 * In this project, a Watcher is implementing this interface and its list is maintained in the
 * usercontroller class and it is watching on the courses listings.
 *
 * @author Akansha Vaish
 */
package ca.model.blocks;

import ca.model.blocks.CourseFields.Enrollment;
import ca.model.blocks.CourseFields.Semester;

public interface Observer {
    public void update (Enrollment enrollment, Semester semester);
}
