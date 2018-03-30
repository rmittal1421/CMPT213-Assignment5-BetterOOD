/**
 * Professors contains a list which stores the name of all the professors.
 * If a course is offered by null, it doesn't stores anything and if a professor is already added in the list
 * and is again offering some other catalog number, his'her name is not added again.
 * @author Akansha Vaish
 */

package ca.model.blocks.CourseFields;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Professor {
    private List<String> listOfProfessors = new ArrayList<>();

    public void add (String professor) {
        if (professor.toLowerCase().contains("null")) {
            return;
        }

        if (!listOfProfessors.contains (professor)) {
            listOfProfessors.add (professor);
        }
    }

    @Override
    public String toString() {

        Collections.sort (listOfProfessors);

        StringBuilder stringBuilder = new StringBuilder();
        String toReturn = "";

        stringBuilder.append (toReturn);
        if (this.listOfProfessors.size() != 0) {
            for (int index = 0; index < listOfProfessors.size() - 1; index++) {
                stringBuilder.append (listOfProfessors.get(index) + ", ");
            }

            stringBuilder.append (listOfProfessors.get (listOfProfessors.size() - 1));
        }

        return stringBuilder.toString();
    }
}
