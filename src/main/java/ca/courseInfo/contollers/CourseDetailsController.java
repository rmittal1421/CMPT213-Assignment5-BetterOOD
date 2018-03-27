package ca.courseInfo.contollers;

import ca.model.CSVreader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseDetailsController {

    @GetMapping ("/hello")
    public String getHello () {
        CSVreader csvFile = new CSVreader ("/Users/rmittal/Desktop/MY_SFU/CMPT213/Assignment5/Project/docs/course_data_2018.csv");
        csvFile.printResults();
        return "";
    }
}
