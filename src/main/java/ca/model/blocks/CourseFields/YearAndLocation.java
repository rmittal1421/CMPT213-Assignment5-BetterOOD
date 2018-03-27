package ca.model.blocks.CourseFields;

public class YearAndLocation {
    public static final int ARBITRARY_PRIME = 17;
    private Semester courseSemester;
    private String location;

    public YearAndLocation (String courseSemester, String location) {
        this.courseSemester = new Semester (courseSemester);
        this.location = location;
    }

    public Semester getCourseSemester() {
        return courseSemester;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public boolean equals (Object otherYearAndLocation) {

        if (this == otherYearAndLocation) {
            return true;
        }

        if (!(otherYearAndLocation instanceof YearAndLocation)) {
            return false;
        }

        Semester otherSemester = ((YearAndLocation) otherYearAndLocation).getCourseSemester();
        String  otherLocation = ((YearAndLocation) otherYearAndLocation).getLocation();

        return this.courseSemester.equals(otherSemester) && this.location.equals(otherLocation);
    }

    @Override
    public int hashCode () {
        return ARBITRARY_PRIME * courseSemester.hashCode() + location.hashCode();
    }

    public void print() {
        courseSemester.print();
        System.out.print(" in " + location);
    }
}
