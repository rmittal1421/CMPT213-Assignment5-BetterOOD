/**
 * Each name is contained in the hashmap stored in name block and is keyed by the name of it's subject.
 * It contains information about all the courses offered in this name in it's courseBlock.
 * @author Raghav Mittal
 */
package ca.model.blocks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.concurrent.atomic.AtomicLong;

public class Department {

    public static final int ARBITRARY_PRIME = 17;
    public static AtomicLong nextID = new AtomicLong();

    private String name;
    private long deptId;
    private CourseBlock courseBlock = new CourseBlock ();

    public Department(String name, long deptId) {
        this.name = name;
        this.deptId = deptId;
    }

    public void addCourse (String[] csvLine) {
        courseBlock.add (csvLine);
    }

    public String getName() {
        return name;
    }

    public long getDeptId() {
        return deptId;
    }

    public static String getHashCode (String department) {
//        return (ARBITRARY_PRIME * department.hashCode()) / (department.length()*10) ;
        return department;
    }

    public static long getNextID () {
        return nextID.incrementAndGet();
    }

    @JsonIgnore
    public CourseBlock getCourseBlock() {
        return courseBlock;
    }

    @Override
    public String toString () {
        return "" + courseBlock;
    }
}
