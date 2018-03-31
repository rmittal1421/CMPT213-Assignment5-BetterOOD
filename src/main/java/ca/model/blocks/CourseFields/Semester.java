/**
 * Semester contains the information about when this particular course was offered. The first three digits of the
 * string semester contains the year and the last one is about which season.
 *
 * Enum season is made because it will be helpful for phase-2 when we have to represent the season in which
 * it was offered.
 * @author Akansha Vaish
 */

package ca.model.blocks.CourseFields;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Semester {

    public static final int STARTING_YEAR = 1900;

    private int semesterCode;
    private int sfuSemester;
    private int year;
    private String term;

    public Semester(String semester) {
        semesterCode = Integer.parseInt (semester.substring (0,semester.length() - 1));

        String season = semester.substring (semester.length() - 1);
        sfuSemester = (season.equals("1")) ? 1 : (season.equals("4") ? 4 : 7);

        year = STARTING_YEAR + semesterCode;

        this.term = (sfuSemester == 1) ? "Spring" : sfuSemester == 4 ? "Summer" : "Fall";
    }

    public int getSemesterCode() {
        return semesterCode;
    }

    @JsonIgnore
    public int getSfuSemester() {
        return sfuSemester;
    }

    public int getYear() {
        return year;
    }

    public String getTerm() {
        return term;
    }

    @Override
    public String toString () {
        return "\t\t" + semesterCode + sfuSemester;
    }
}
