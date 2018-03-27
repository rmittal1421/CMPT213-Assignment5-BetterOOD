package ca.model.blocks.CourseFields;

public class CourseCode {
    private String courseSubject;
    private String subjectCode;

    public CourseCode(String subject, String code) {
        courseSubject = subject;
        subjectCode = code;
    }


    public void print () {
        System.out.println(courseSubject + " " + subjectCode);
    }
}
