package com.example.dockerizedsample.persistence;

import com.example.dockerizedsample.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

   void deleteByEmail(String email);
   User findByEmail(String email);
}