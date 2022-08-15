package tn.esprit.util;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tn.esprit.Entity.SexeType;
import tn.esprit.Entity.User;
import tn.esprit.Entity.Role;
import tn.esprit.Entity.ZoneMap;
import tn.esprit.Service.UserServiceImpl;


@Component
public class FirstTimeInitializer implements CommandLineRunner {

    private final Log logger = LogFactory.getLog(FirstTimeInitializer.class);

    @Autowired
    private UserServiceImpl userService;

    @Override
    public void run(String... strings) throws Exception {

        if (userService.retrieveAllUsers().isEmpty()) {
            logger.info("No Users accounts found. Creating some users");

            User user = new User("Ahmed","Zarrad","07508030","ahmed123",
                    "ahmed123",true,"95382514","ariena",
                    "ahmed.zarrad@esprit.tn", SexeType.Men,true,0,false,false,
                    true, ZoneMap.TUNIS,Role.ADMINISTRATOR);
            userService.save(user);
        }
    }
}
