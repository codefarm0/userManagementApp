package com.gl.userManagementApp.repository;

import com.gl.userManagementApp.dto.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
