/**
 * Rest controller class which is basically giving spring boot the data which is supposed to go in that.
 * It is using CSV reader class from the model and passing in the filepath from which it has to read all the info.
 * @author Akansha Vaish
 */

package ca.courseInfo.contollers;

import ca.model.CSVreader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseDetailsController {

    @GetMapping ("/dump-model")
    public String dumpModel () {

        String filePath = "/Users/rmittal/Desktop/MY_SFU/CMPT213/Assignment5/Phase1/docs/course_data_2018.csv";

        CSVreader csvFile = new CSVreader (filePath);
        System.out.println(csvFile.getResult());
        return "";
    }
}
