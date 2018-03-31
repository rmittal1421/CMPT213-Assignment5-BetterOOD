/**
 * CourseCode contains the subject (department) name and the catalog number for that course. It remains same for
 * a particular course throughout.
 * It stores information like CMPT 213.
 * @author Akansha Vaish
 */

package ca.model.blocks.CourseFields;

public class CourseCode {
    private String courseSubject;
    private String subjectCode;

    public CourseCode(String subject, String code) {
        courseSubject = subject;
        subjectCode = code;
    }

    @Override
    public String toString () {
        return courseSubject + " " + subjectCode;
    }

    public String getCourseSubject() {
        return courseSubject;
    }

    public String getSubjectCode() {
        return subjectCode;
    }
}
