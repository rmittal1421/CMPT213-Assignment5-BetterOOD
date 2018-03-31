/**
 * Rest controller class which is basically giving spring boot the data which is supposed to go in that.
 * It is using CSV reader class from the model and passing in the filepath from which it has to read all the info.
 * @author Akansha Vaish
 */

package ca.courseInfo.contollers;

import ca.model.CSVreader;
import ca.model.blocks.Course;
import ca.model.blocks.Department;
import ca.model.blocks.DepartmentBlock;
import ca.model.blocks.Offering;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CourseDetailsController {

    private String filePath = "/Users/rmittal/Desktop/MY_SFU/CMPT213/Assignment5/Phase1/docs/course_data_2018.csv";
    private CSVreader csvFile = new CSVreader (filePath);

    @GetMapping ("api/dump-model")
    public String dumpModel () {

        System.out.println ("Model Dump from 'course_data_2018.csv' file");
        System.out.println(csvFile.getResult());
        return "";
    }

    @GetMapping ("api/about")
    public About getAbout () {
        return new About ();
    }

    @GetMapping ("api/departments")
    public List<Department> getListOfDepartments () {
        return csvFile.getDepartmentBlock().getDepartmentBlock();
    }

    @GetMapping ("api/departments/{id}/courses")
    public List <Course> getListOfCourses (@PathVariable ("id") long id) {
        for (Department dept : getListOfDepartments()) {
            if (dept.getDeptId() == id) {
                return dept.getCourseBlock().getCourseBlock();
            }
        }

        throw new NoSuchResourceAvailable ("Department with id : " + id + " doesn't exists.");
    }

    @GetMapping ("api/departments/{id}/courses/{courseId}/offerings")
    public List <Offering> getListOfOfferings (@PathVariable ("id") long id, @PathVariable ("courseId") long courseId) {
        for (Course course : getListOfCourses (id)) {
            if (course.getCourseId() == courseId) {
                return course.getOfferningBlock().getOfferingBlock();
            }
        }

        throw new NoSuchResourceAvailable ("Course with id : " + courseId + " doesn't exists in department with id : " + id);
    }
}
