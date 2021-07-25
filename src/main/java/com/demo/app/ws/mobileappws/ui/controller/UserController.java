package com.demo.app.ws.mobileappws.ui.controller;

import com.demo.app.ws.mobileappws.service.abstracts.UserService;
import com.demo.app.ws.mobileappws.shared.dto.UserDto;
import com.demo.app.ws.mobileappws.ui.model.request.UpdateUserDetailRequestModel;
import com.demo.app.ws.mobileappws.ui.model.request.UserDetailRequestModel;
import com.demo.app.ws.mobileappws.ui.model.response.UserRest;
import com.demo.app.ws.mobileappws.ui.model.util.UserServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

    Map<String, UserRest> users;

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "limit", defaultValue = "50") int limit,
                          @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "get user was called with page = " + page + " limit = " + limit;
    }

    @GetMapping(path = "/{userId}", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<UserRest> getUserById(@PathVariable String userId) {

        if (true) throw new UserServiceException("A user service exception is thrown");

        if (users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
            }, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
    })
    public UserRest createUser(@Valid @RequestBody UserDetailRequestModel model) {

        UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();

        BeanUtils.copyProperties(model, userDto);

        UserDto res = userService.createUser(userDto);
        BeanUtils.copyProperties(res, returnValue);

        return returnValue;
    }

    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
            }, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
    })
    public String updateUser(@Valid @RequestBody UpdateUserDetailRequestModel model) {
        if (users.containsKey(model.getUserId())) {
            UserRest userModel = users.get(model.getUserId());

            userModel.setFirstName(model.getFirstName());
            userModel.setLastName(model.getLastName());

            users.put(model.getUserId(), userModel);

            return "User was updated.";

        } else {
            return "User was not found.";
        }
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity deleteUser(@PathVariable String userId) {
        if (users.containsKey(userId)) users.remove(userId);
        return ResponseEntity.noContent().build();
    }
}

