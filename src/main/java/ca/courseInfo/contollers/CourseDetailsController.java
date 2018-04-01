/**
 * Rest controller class which is basically giving spring boot the data which is supposed to go in that.
 * It is using CSV reader class from the model and passing in the filepath from which it has to read all the info.
 *
 * @author Akansha Vaish
 */

package ca.courseInfo.contollers;

import ca.model.CSVreader;
import ca.model.blocks.Course;
import ca.model.blocks.CourseFields.Enrollment;
import ca.model.blocks.Department;
import ca.model.blocks.GraphData;
import ca.model.blocks.Offering;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseDetailsController {

    public static final String COMMA = ", ";
    private String filePath = "/Users/rmittal/Desktop/MY_SFU/CMPT213/Assignment5/Phase1/docs/course_data_2018.csv";
    private CSVreader csvFile = new CSVreader(filePath);

    @GetMapping("api/dump-model")
    public String dumpModel() {

        System.out.println("Model Dump from 'course_data_2018.csv' file");
        System.out.println(csvFile.getResult());
        return "";
    }

    @GetMapping("api/about")
    public About getAbout() {
        return new About();
    }

    @GetMapping("api/departments")
    public List<Department> getListOfDepartments() {
        return csvFile.getDepartmentBlock().getDepartmentBlock();
    }

    public Department getThisDepartment(long id) {
        for (Department dept : getListOfDepartments()) {
            if (dept.getDeptId() == id) {
                return dept;
            }
        }

        throw new NoSuchResourceAvailable("Department with id : " + id + " doesn't exists.");
    }

    @GetMapping("api/departments/{id}/courses")
    public List<Course> getListOfCourses(@PathVariable("id") long id) {
        return getThisDepartment(id).getCourseBlock().getCourseBlock();
    }

    public Course getThisCourse(long id, long courseId) {
        for (Course course : getListOfCourses(id)) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }

        throw new NoSuchResourceAvailable("Course with id : " + courseId + " doesn't exists in department with id : " + id);
    }

    @GetMapping("api/departments/{id}/courses/{courseId}/offerings")
    public List<Offering> getListOfOfferings(@PathVariable("id") long id, @PathVariable("courseId") long courseId) {
        return getThisCourse(id, courseId).getOfferingBlock().getOfferingBlock();
    }

    @GetMapping("api/departments/{id}/courses/{courseId}/offerings/{offeringId}")
    public List<Enrollment> getOffering(@PathVariable("id") long id,
                                        @PathVariable("courseId") long courseId,
                                        @PathVariable("offeringId") long offeringId) {

        for (Course course : getListOfCourses(id)) {
            if (course.getCourseId() == courseId) {
                return course.getOffering(offeringId).getCompCode();
            }
        }

        throw new NoSuchResourceAvailable("Offering with id : " + offeringId + " doesn't exists in course with id : " + courseId);
    }

    @GetMapping("api/stats/students-per-semester")
    public List<GraphData> getNumberOfEnrollments(@RequestParam("deptId") long id) {
        Department dept = getThisDepartment(id);
        dept.fillSemesterEnrollments();
        return dept.getGraphData();
    }

    @PostMapping("/api/addoffering")
    @ResponseStatus(HttpStatus.CREATED)
    public Enrollment addOffering (@RequestBody PostingFields posting) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");

        stringBuilder.append(posting.getSemester() + COMMA
                            + posting.getSubjectName() + COMMA
                            + posting.getCatalogNumber() + COMMA
                            + posting.getLocation() + COMMA
                            + posting.getEnrollmentCap() + COMMA
                            + posting.getEnrollmentTotal() + COMMA
                            + posting.getInstructor() + COMMA
                            + posting.getComponent());

        Enrollment enrollment = new Enrollment(posting.getComponent(),
                posting.getEnrollmentCap(), posting.getEnrollmentTotal());

        csvFile.addDynamically (stringBuilder.toString());
        return enrollment;
    }
}
