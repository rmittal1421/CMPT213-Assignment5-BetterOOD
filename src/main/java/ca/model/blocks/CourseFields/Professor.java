package ca.model.blocks.CourseFields;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private List<String> listOfProfessors = new ArrayList<>();

    public void add (String professor) {
        if (!listOfProfessors.contains (professor)) {
            listOfProfessors.add (professor);
        }
    }

    public void print () {
        for (int index = 0; index < listOfProfessors.size() - 1; index++) {
            System.out.print (listOfProfessors.get (index) + ", ");
        }

        System.out.println (listOfProfessors.get (listOfProfessors.size() - 1));
    }
}
