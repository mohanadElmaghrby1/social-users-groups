package com.idealwaves;

import com.idealwaves.domain.Group;
import com.idealwaves.domain.User;
import com.idealwaves.domain.UserGroup;
import com.idealwaves.service.GroupService;
import com.idealwaves.service.UserGroupService;
import com.idealwaves.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IdealwavesApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdealwavesApplication.class, args);
    }

    @Bean
    public CommandLineRunner getUsers (UserService userService , GroupService groupService
            , UserGroupService userGroupService){
        return args -> {
            User user = new User("mohannad", "elmaghrby", 'N');
            userService.save(user);

            Group group = new Group();
            group.setIsActive('Y');
            group.setName("EgyptionGeeks");
            groupService.save(group);

            UserGroup userGroup = new UserGroup();
            userGroup.setGroup(group);
            userGroup.setUser(user);
            userGroup.setIsActive('N');

            userGroupService.save(userGroup);
        };
    }

}
