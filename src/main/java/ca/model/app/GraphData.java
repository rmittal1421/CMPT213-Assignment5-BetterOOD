/**
 * Graph data is holding the fields required explicilty for data to go in graph.
 * This class is designed to cop up with the data in UI.
 * @author vakansha & rmittal
 */
package ca.model.app;

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
