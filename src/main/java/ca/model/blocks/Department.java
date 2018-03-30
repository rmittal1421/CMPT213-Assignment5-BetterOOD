/**
 * Each department is contained in the hashmap stored in department block and is keyed by the name of it's subject.
 * It contains information about all the courses offered in this department in it's courseBlock.
 * @author Raghav Mittal
 */
package ca.model.blocks;

public class Department {

    public static final int ARBITRARY_PRIME = 17;

    private String department;
    private CourseBlock courseBlock = new CourseBlock ();

    public Department(String department) {
        this.department = department;
    }

    public void addCourse (String[] csvLine) {
        courseBlock.add (csvLine);
    }


    public static int getHashCode (String department) {
        return ARBITRARY_PRIME * department.hashCode() + department.length();
    }

    @Override
    public int hashCode () {
        return getHashCode (this.department);
    }

    @Override
    public String toString () {
        return "" + courseBlock;
    }
}
