package tn.esprit.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.Entity.Interview;
import tn.esprit.Service.InterviewService;

@RestController
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    // add Interview
    @PostMapping(value = "/createInterview")
    public Interview addInterview(@RequestBody Interview interview) {
        return interviewService.planInterview(interview);
    }

}
