/**
 * Year and location is stored because each course has a unique year and location.
 * If two courses are same, it means that they have same year and location.
 * Semester is stored as an instance of Semester class where location is just a string.
 * @author Akansha Vaish
 */

package ca.model.blocks.CourseFields;

public class YearAndLocation {
    private Semester courseSemester;
    private String location;

    public YearAndLocation (String courseSemester, String location) {
        this.courseSemester = new Semester (courseSemester);
        this.location = location;
    }

    @Override
    public String toString() {
        return courseSemester + " in " + location;
    }
}
