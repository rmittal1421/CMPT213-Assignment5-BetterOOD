package ca.model.blocks;

import java.util.HashMap;
import java.util.Map;

public class CourseBlock {
    private Map<Integer, Course> courseBlock = new HashMap<>();

    public void add(String[] csvLine) {
        int courseID = Course.getHashCode (csvLine[2]);

        if (courseBlock.get (courseID) == null) {
            courseBlock.put (courseID, new Course (csvLine[1], csvLine[2]));
        }

        courseBlock.get (courseID).addOffering (csvLine);
    }

    public void print () {
        for (Integer courseID : courseBlock.keySet()) {
            courseBlock.get (courseID).print ();
        }
    }
}
