/**
 * Enrollment stores the enrollment totat and enrollment capacity.
 * It's each instance is stored in the hashmap in the component code like TUT, LEC
 * All the professors offering any of the this component code get added up and so is their enrollments.
 * @author Akansha Vaish
 */

package ca.model.blocks.CourseFields;

public class Enrollment {
    private int enrollmentCapacity;
    private int enrollmentTotal;

    public Enrollment (int enrollmentCapacity, int enrollmentTotal) {
        this.enrollmentCapacity = enrollmentCapacity;
        this.enrollmentTotal = enrollmentTotal;
    }

    public Enrollment (String enrollmentCapacity, String enrollmentTotal) {
        this.enrollmentCapacity = Integer.parseInt (enrollmentCapacity);
        this.enrollmentTotal = Integer.parseInt (enrollmentTotal);
    }

    public int getEnrollmentCapacity() {
        return enrollmentCapacity;
    }

    public int getEnrollmentTotal() {
        return enrollmentTotal;
    }

    //Adds up enrollment of the courses whose component codes are same given rest of the information
    //matches except for the professors.
    public void merge(Enrollment enrollment) {
        this.enrollmentCapacity += enrollment.getEnrollmentCapacity();
        this.enrollmentTotal += enrollment.getEnrollmentTotal();
    }

    @Override
    public String toString () {
        return "Enrollment=" + + enrollmentTotal + "/" + enrollmentCapacity;
    }
}