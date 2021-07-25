package com.demo.app.ws.mobileappws.service.concrete;

import com.demo.app.ws.mobileappws.repo.UserRepository;
import com.demo.app.ws.mobileappws.service.abstracts.UserService;
import com.demo.app.ws.mobileappws.shared.dto.UserDto;
import com.demo.app.ws.mobileappws.ui.model.entity.UserEntity;
import com.demo.app.ws.mobileappws.ui.model.request.UserDetailRequestModel;
import com.demo.app.ws.mobileappws.ui.model.response.UserRest;
import com.demo.app.ws.mobileappws.ui.model.util.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImp implements UserService {

    Map<String, UserRest> users;
    Utils utils;

    private UserRepository userRepository;

    public UserServiceImp() {
    }

    @Autowired
    public UserServiceImp(Utils utils, UserRepository userRepository) {
        this.utils = utils;
        this.userRepository = userRepository;
    }

    @Override
    public UserRest createUser(UserDetailRequestModel model) {

        UserRest res = new UserRest();
        res.setFirstName(model.getFirstName());
        res.setLastName(model.getLastName());
        res.setEmail(model.getEmail());

        String userId = utils.generateUserId();
        res.setUserId(userId);

        if (users == null) users = new HashMap<>();
        users.put(userId, res);

        return res;
    }

    @Override
    public UserDto createUser(UserDto model) {

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(model, userEntity);

        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testUserId");

        UserEntity storedUserDetail = userRepository.save(userEntity);
        UserDto retValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetail, retValue);

        return retValue;
    }
}
