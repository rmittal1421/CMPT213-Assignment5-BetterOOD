package ca.model.blocks;


import java.util.HashMap;
import java.util.Map;

public class DepartmentBlock {
    private Map <Integer, Department> departmentBlock = new HashMap<>();

    public void add (String[] csvLine) {
        int departmentHash = Department.getHashCode (csvLine[1]);

        if (departmentBlock.get(departmentHash) == null) {
            departmentBlock.put (departmentHash, new Department (csvLine[1]));
        }

        departmentBlock.get (departmentHash).addCourse (csvLine);
    }

    public void printAllEntries () {
        for (Integer departmentKey : departmentBlock.keySet()) {
            departmentBlock.get (departmentKey).print();
        }
    }
}
