package com.demo.app.ws.mobileappws.repo;

import com.demo.app.ws.mobileappws.ui.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findUserEntitiesByEmail(String email);
}
