package com.project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.project.entity.User;

public interface UserRepo extends CrudRepository<User, Integer> {

}
