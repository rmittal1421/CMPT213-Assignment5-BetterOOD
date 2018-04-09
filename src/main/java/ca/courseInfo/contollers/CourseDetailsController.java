/**
 * Rest controller class which is basically giving spring boot the data which is supposed to go in that.
 * It is using CSV reader class from the model and passing in the filepath from which it has to read all the info.
 * It is also holding all the requests made from the localhost.
 *
 * @author Akansha Vaish & Raghav Mittal
 */

package ca.courseInfo.contollers;

import ca.model.app.CSVreader;
import ca.model.app.GraphData;
import ca.model.blocks.*;
import ca.model.blocks.CourseFields.Dept$CourseId;
import ca.model.blocks.CourseFields.Enrollment;
import ca.model.blocks.CourseFields.PostingFields;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseDetailsController {

    public static final String COMMA = ", ";
    private String filePath = "/Users/rmittal/Desktop/MY_SFU/CMPT213/Assignment5/Phase1/docs/course_data_2018.csv";
    private CSVreader csvFile = new CSVreader(filePath);
    private List<Watcher> listOfWatchers = new ArrayList<>();

    @GetMapping("api/about")
    public Object getAbout() {
        return new Object() {
            public final String appName = "SFU Course Information App";
            public final String authorName = "Akansha Vaish & Raghav Mittal";
        };
    }

    @GetMapping("api/dump-model")
    public String dumpModel() {

        System.out.println("Model Dump from 'course_data_2018.csv' file");
        System.out.println(csvFile.getResult());
        return "";
    }

    @GetMapping("api/departments")
    public List<Department> getListOfDepartments() {
        return csvFile.getDepartmentBlock().getDepartmentBlock();
    }

    private Department getThisDepartment(long id) {
        for (Department dept : getListOfDepartments()) {
            if (dept.getDeptId() == id) {
                return dept;
            }
        }

        throw new NoSuchResourceAvailable("Department with id : " + id + " doesn't exist.");
    }

    @GetMapping("api/departments/{id}/courses")
    public List<Course> getListOfCourses(@PathVariable("id") long id) {
        return getThisDepartment(id).getCourseBlock().getCourseBlock();
    }

    private Course getThisCourse(long id, long courseId) {
        for (Course course : getListOfCourses(id)) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }

        throw new NoSuchResourceAvailable("Course with id : " + courseId + " doesn't exist.");
    }

    @GetMapping("api/departments/{id}/courses/{courseId}/offerings")
    public List<Offering> getListOfOfferings(@PathVariable("id") long id, @PathVariable("courseId") long courseId) {
        return getThisCourse(id, courseId).getOfferingBlock().getOfferingBlock();
    }

    @GetMapping("api/departments/{id}/courses/{courseId}/offerings/{offeringId}")
    public List<Enrollment> getOffering(@PathVariable("id") long id,
                                        @PathVariable("courseId") long courseId,
                                        @PathVariable("offeringId") long offeringId) {

        Course course = getThisCourse (id, courseId);
        return course.getOffering(offeringId).getCompCode();
    }

    @GetMapping("api/stats/students-per-semester")
    public List<GraphData> getNumberOfEnrollments(@RequestParam("deptId") long id) {
        Department dept = getThisDepartment(id);
        dept.fillSemesterEnrollments();
        return dept.getGraphData();
    }

    @PostMapping("/api/addoffering")
    @ResponseStatus(HttpStatus.CREATED)
    public Enrollment addOffering(@RequestBody PostingFields posting) {

        String newCourseOffering = "";

        newCourseOffering += (posting.getSemester() + COMMA
                + posting.getSubjectName() + COMMA
                + posting.getCatalogNumber() + COMMA
                + posting.getLocation() + COMMA
                + posting.getEnrollmentCap() + COMMA
                + posting.getEnrollmentTotal() + COMMA
                + posting.getInstructor() + COMMA
                + posting.getComponent());

        csvFile.addDynamically(newCourseOffering);
        Enrollment enrollment = new Enrollment(posting.getComponent(),
                posting.getEnrollmentCap(), posting.getEnrollmentTotal());

        return enrollment;
    }

    @GetMapping("api/watchers")
    public List<Watcher> getAllWatchers() {
        return listOfWatchers;
    }

    @PostMapping("/api/watchers")
    @ResponseStatus(HttpStatus.CREATED)
    public Watcher createAWatcher(@RequestBody Dept$CourseId dept$CourseId) {

        Department dept = getThisDepartment(dept$CourseId.getDeptId());
        Course course = getThisCourse(dept$CourseId.getDeptId(), dept$CourseId.getCourseId());

        Watcher eye = new Watcher(dept, course);
        listOfWatchers.add(eye);
        course.registerObserver(eye);

        return eye;
    }

    private Watcher getThisWatcher(long watcherId) {
        for (Watcher eye : listOfWatchers) {
            if (eye.getId() == watcherId) {
                return eye;
            }
        }

        throw new NoSuchResourceAvailable("Watcher with id : " + watcherId + " doesn't exists.");
    }

    @GetMapping("/api/watchers/{id}")
    public Watcher getAWatcher(@PathVariable("id") long watcherId) {
        return getThisWatcher(watcherId);
    }

    @DeleteMapping("api/watchers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAWatcher(@PathVariable("id") long watcherId) {
        Watcher eye = getThisWatcher(watcherId);
        eye.getCourse().removeObserver(eye);
        listOfWatchers.remove(eye);
    }
}
