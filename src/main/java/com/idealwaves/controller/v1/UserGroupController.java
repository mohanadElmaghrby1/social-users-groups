package com.idealwaves.controller.v1;

import com.idealwaves.api.v1.model.UserGroupsDTO;
import com.idealwaves.domain.Group;
import com.idealwaves.domain.User;
import com.idealwaves.domain.UserGroup;
import com.idealwaves.service.GroupService;
import com.idealwaves.service.UserGroupService;
import com.idealwaves.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * create by mohannad on 11/12/2019
 */
@RestController
@RequestMapping(UserGroupController.BASE_URL)
public class UserGroupController {
    public static final String BASE_URL = "/api/v1/usersgroups";

    private UserGroupService userGroupService;
    private UserService userService;

    public UserGroupController(UserGroupService userGroupService, UserService userService) {
        this.userGroupService = userGroupService;
        this.userService = userService;
    }

//
//    @PostMapping("/{userId}/{groupId}")
//    public ResponseEntity<UserGroup> removeUserFromGroup(@PathVariable long userId ,@PathVariable long groupId) {
//        return new ResponseEntity(userGroupService.save(UserGroup), HttpStatus.CREATED);
//    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserGroupsDTO> getUserGroups(@PathVariable long userId) {
        List<UserGroup> allUserGroupsByUserId = userGroupService.findAllUserGroupsByUserId(userId);
        if (allUserGroupsByUserId == null) {
            throw new EntityNotFoundException("cant find user with id :" + userId);
        }
        List<Group> groups = allUserGroupsByUserId.stream()
                .map(UserGroup::getGroup)
                .collect(Collectors.toList());
        return new ResponseEntity((new UserGroupsDTO((allUserGroupsByUserId.get(0).getUser()), groups)), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/{groupId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeUserFromGroup(@PathVariable long userId ,@PathVariable long groupId) {
        UserGroup userGroup = userGroupService.findByUserIdAndGroupId(userId, groupId)
                .orElseThrow(() -> new EntityNotFoundException(" cant find user user group"));
        userGroupService.delete(userGroup);
    }

    @GetMapping
    public ResponseEntity<List<UserGroup>> getAllUsersGroups() {
        return new ResponseEntity(userGroupService.findAll(), HttpStatus.OK);
    }
}
