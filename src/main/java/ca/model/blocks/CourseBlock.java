/**
 * Course Block's object exist in every department and contains all the courses offered in that department inside of
 * a hashmap. The catalog number is used to hash a course code to it's course.
 * ex- all cmpt courses are stored in one department but all the courses such as
 * cmpt 213, cmpt 300, cmpt 307 .... are stored in course block.
 * @author Raghav Mittal
 */
package ca.model.blocks;

import java.util.*;

public class CourseBlock {

    public static final int CATALOG_INDEX = 2;
    public static final int DEPARTMENT_INDEX = 1;

    private Map<String, Course> courseBlock = new HashMap<>();

    public void add(String[] csvLine) {
        String courseID = Course.getHashCode (csvLine [CATALOG_INDEX]);

        if (courseBlock.get (courseID) == null) {
            courseBlock.put (courseID, new Course (csvLine [DEPARTMENT_INDEX], csvLine [CATALOG_INDEX], Course.getNextID()));
        }

        courseBlock.get (courseID).addOffering (csvLine);
    }

    public List <Course> getCourseBlock() {
        List <Course> listOfCourses = new ArrayList<>();

        List<String> sortedKeys = new ArrayList<> (courseBlock.keySet());
        Collections.sort (sortedKeys);

        for (String key : sortedKeys) {
            listOfCourses.add (courseBlock.get (key));
        }

        return listOfCourses;
    }

    @Override
    public String toString () {

        String toReturn = "";

        List<String> sortedKeys = new ArrayList<> (courseBlock.keySet());
        Collections.sort (sortedKeys);

        for (String courseID : sortedKeys) {
            toReturn += courseBlock.get(courseID);
        }

        return toReturn;
    }
}
