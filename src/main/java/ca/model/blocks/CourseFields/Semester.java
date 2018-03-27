package ca.model.blocks.CourseFields;

public class Semester {

    public enum Season {
        FALL, SPRING, SUMMER
    }

    public static final int ARBITRARY_PRIME = 11;
    private int yearNumber;
    private int sfuSemester;
    private int year;
    private Season semSeason;

    public Semester(String semester) {
        yearNumber = Integer.parseInt (semester.substring (0,semester.length() - 1));

        String season = semester.substring (semester.length() - 1);
        sfuSemester = (season.equals("1")) ? 1 : (season.equals("4") ? 4 : 7);

        year = 1900 + yearNumber;
        this.semSeason = (sfuSemester == 1) ? Season.SPRING : sfuSemester == 4 ? Season.SUMMER : Season.FALL;
    }

//    @Override
//    public boolean equals (Object semester) {
//        int yearNum = ((Semester) semester).yearNumber;
//        int sfuSem = ((Semester) semester).sfuSemester;
//        return (yearNumber == yearNum) && (sfuSemester == sfuSem);
//    }
//
//    @Override
//    public int hashCode () {
//        return ARBITRARY_PRIME * yearNumber + sfuSemester;
//    }

    public void print() {
        System.out.print ("\t\t" + yearNumber + "" + sfuSemester);
    }
}
