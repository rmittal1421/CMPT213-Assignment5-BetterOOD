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

    public void merge(Enrollment enrollment) {
        this.enrollmentCapacity += enrollment.getEnrollmentCapacity();
        this.enrollmentTotal += enrollment.getEnrollmentTotal();
    }

    public void print() {
        System.out.println ("Enrollment = " + enrollmentTotal + "/" + enrollmentCapacity);
    }
}