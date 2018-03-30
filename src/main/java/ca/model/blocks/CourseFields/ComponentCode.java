/**
 * Component Code contains a hashmap which stores all the information about different section of a particular
 * offering and the enrollment of that section in that particular offering of that particulat course.
 * @author Akansha Vaish
 */
package ca.model.blocks.CourseFields;

import java.util.*;

public class ComponentCode {

    private Map<String, Enrollment> componentCode = new HashMap<>();

    public void add(String compCode, Enrollment enrollment) {
        Enrollment tempEnroll = componentCode.get (compCode);

        if (tempEnroll == null) {
            componentCode.put (compCode, enrollment);
        }
        else {
            tempEnroll.merge (enrollment);
        }
    }

    @Override
    public String toString () {
        String toReturn = "";

        List<String> sortedKeys = new ArrayList<> (componentCode.keySet());
        Collections.sort (sortedKeys);

        for (String code : sortedKeys) {
            toReturn += "\n\t\t\t\tTYPE=" + code + ", " + componentCode.get(code);
        }
        return toReturn;
    }
}
