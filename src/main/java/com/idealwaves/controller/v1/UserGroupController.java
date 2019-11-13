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
    private GroupService groupService;

    public UserGroupController(UserGroupService userGroupService, UserService userService, GroupService groupService) {
        this.userGroupService = userGroupService;
        this.userService = userService;
        this.groupService = groupService;
    }

    @GetMapping
    public ResponseEntity<UserGroup> assignUserToGroup(@RequestParam(name = "userId") long userId
            ,@RequestParam(name = "groupId") long groupId
            ,@RequestParam(name = "isActive") char isActive) {
        User user = userService.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("cant find user with id: " + userId));
        Group group = groupService.findById(groupId)
                .orElseThrow(() -> new EntityNotFoundException("cant find group with id: " + groupId));

        UserGroup userGroup = new UserGroup();
        userGroup.setIsActive(isActive);
        userGroup.setUser(user);
        userGroup.setGroup(group);
        return new ResponseEntity<>(userGroupService.save(userGroup) , HttpStatus.CREATED);
    }

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
}
