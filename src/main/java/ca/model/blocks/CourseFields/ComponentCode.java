package ca.model.blocks.CourseFields;

import java.util.HashMap;
import java.util.Map;

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

    public void print() {
        for (String code : componentCode.keySet()) {
            System.out.print ("\t\t\t\tTYPE = " + code + ", ");
            componentCode.get (code).print();
        }
    }
}
