/**
 * Enrollment stores the enrollment totat and enrollment capacity.
 * It's each instance is stored in the hashmap in the component code like TUT, LEC
 * All the professors offering any of the this component code get added up and so is their enrollments.
 * @author Akansha Vaish
 */

package ca.model.blocks.CourseFields;

public class Enrollment {
    private String type;
    private int enrollmentCap;
    private int enrollmentTotal;

    public Enrollment (String compCode, int enrollmentCap, int enrollmentTotal) {
        this.type = compCode;
        this.enrollmentCap = enrollmentCap;
        this.enrollmentTotal = enrollmentTotal;
    }

    public Enrollment (String enrollmentCap, String enrollmentTotal) {
        this.enrollmentCap = Integer.parseInt (enrollmentCap);
        this.enrollmentTotal = Integer.parseInt (enrollmentTotal);
    }

    public String getType() {
        return type;
    }

    public int getEnrollmentCap() {
        return enrollmentCap;
    }

    public int getEnrollmentTotal() {
        return enrollmentTotal;
    }

    //Adds up enrollment of the courses whose component codes are same given rest of the information
    //matches except for the professors.
    public void merge(Enrollment enrollment) {
        this.enrollmentCap += enrollment.getEnrollmentCap();
        this.enrollmentTotal += enrollment.getEnrollmentTotal();
    }

    @Override
    public String toString () {
        return "Enrollment=" + + enrollmentTotal + "/" + enrollmentCap;
    }
}