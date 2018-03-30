/**
 * It contains a hashmap. The constructor is taking in a string and matching if a department of the given
 * subject already exists or not. It creates a new department if it does not and adds the line of csv to that
 * department.
 *
 * This class can be said to be facade class.
 * @author Raghav Mittal
 */
package ca.model.blocks;

import java.util.*;

public class DepartmentBlock {

    public static final int DEPARTMENT_INDEX = 1;

    private Map <Integer, Department> departmentBlock = new HashMap<>();

    public void add (String[] csvLine) {
        int departmentHash = Department.getHashCode (csvLine [DEPARTMENT_INDEX]);

        if (departmentBlock.get(departmentHash) == null) {
            departmentBlock.put (departmentHash, new Department (csvLine [DEPARTMENT_INDEX]));
        }

        departmentBlock.get (departmentHash).addCourse (csvLine);
    }

    @Override
    public String toString () {

        String toReturn = "";

        List<Integer> sortedKeys = new ArrayList<> (departmentBlock.keySet());
        Collections.sort (sortedKeys);

        for (Integer departmentKey : sortedKeys) {
            toReturn +=  departmentBlock.get (departmentKey);
        }

        return toReturn;
    }
}
