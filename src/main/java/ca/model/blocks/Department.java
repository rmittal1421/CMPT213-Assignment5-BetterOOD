package ca.model.blocks;

import java.util.concurrent.atomic.AtomicInteger;

public class Department {

    private static AtomicInteger nextID = new AtomicInteger();

    private int departmentID;
    private String department;

    private CourseBlock courseBlock = new CourseBlock ();

    public Department(String department) {
        departmentID = nextID.incrementAndGet();
        this.department = department;
    }

    public void addCourse (String[] csvLine) {
        courseBlock.add (csvLine);
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public String getDepartment() {
        return department;
    }

    public static int getHashCode (String department) {
        return 17 * department.hashCode() + department.length();
    }

    @Override
    public int hashCode () {
        return getHashCode (this.department);
    }

    public void print () {
        courseBlock.print ();
    }
}
