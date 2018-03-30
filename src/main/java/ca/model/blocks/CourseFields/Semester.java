/**
 * Semester contains the information about when this particular course was offered. The first three digits of the
 * string semester contains the year and the last one is about which season.
 *
 * Enum season is made because it will be helpful for phase-2 when we have to represent the season in which
 * it was offered.
 * @author Akansha Vaish
 */

package ca.model.blocks.CourseFields;

public class Semester {

    public static final int STARTING_YEAR = 1900;

    public enum Season {
        FALL, SPRING, SUMMER
    }

    private int yearNumber;
    private int sfuSemester;
    private int year;
    private Season semSeason;

    public Semester(String semester) {
        yearNumber = Integer.parseInt (semester.substring (0,semester.length() - 1));

        String season = semester.substring (semester.length() - 1);
        sfuSemester = (season.equals("1")) ? 1 : (season.equals("4") ? 4 : 7);

        year = STARTING_YEAR + yearNumber;
        this.semSeason = (sfuSemester == 1) ? Season.SPRING : sfuSemester == 4 ? Season.SUMMER : Season.FALL;
    }

    @Override
    public String toString () {
        return "\t\t" + yearNumber + sfuSemester;
    }
}
