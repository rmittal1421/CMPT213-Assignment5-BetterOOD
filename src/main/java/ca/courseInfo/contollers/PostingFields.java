package ca.courseInfo.contollers;

public class PostingFields {
    private int semester;
    private String subjectName;
    private int catalogNumber;
    private String location;
    private int enrollmentCap;
    private String component;
    private int enrollmentTotal;
    private String instructor;

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setCatalogNumber(int catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEnrollmentCap(int enrollmentCap) {
        this.enrollmentCap = enrollmentCap;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public void setEnrollmentTotal(int enrollmentTotal) {
        this.enrollmentTotal = enrollmentTotal;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getSemester() {
        return semester;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getCatalogNumber() {
        return catalogNumber;
    }

    public String getLocation() {
        return location;
    }

    public int getEnrollmentCap() {
        return enrollmentCap;
    }

    public String getComponent() {
        return component;
    }

    public int getEnrollmentTotal() {
        return enrollmentTotal;
    }

    public String getInstructor() {
        return instructor;
    }
}
