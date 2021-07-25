package com.demo.app.ws.mobileappws.service.abstracts;

import com.demo.app.ws.mobileappws.shared.dto.UserDto;
import com.demo.app.ws.mobileappws.ui.model.request.UserDetailRequestModel;
import com.demo.app.ws.mobileappws.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailRequestModel model);

    UserDto createUser(UserDto model);
}
