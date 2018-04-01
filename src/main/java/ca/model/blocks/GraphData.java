package ca.model.blocks;

public class GraphData {
    private int semesterCode;
    private int totalCoursesTaken = 0;

    public GraphData(int semesterCode) {
        this.semesterCode = semesterCode;
    }

    public void merge(String moreEnrollments) {
        totalCoursesTaken += Integer.parseInt (moreEnrollments);
    }

    public int getSemesterCode() {
        return this.semesterCode;
    }

    public int getTotalCoursesTaken() {
        return this.totalCoursesTaken;
    }
}
