package tn.esprit.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.Interview;
import tn.esprit.Repository.InterviewRepository;

@Service
public class InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    public Interview planInterview(Interview interview){
        return interviewRepository.save(interview);
    }




}
