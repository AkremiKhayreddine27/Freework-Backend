package com.freework.repositories;

import com.freework.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "users")
public interface UsersRepository extends JpaRepository<User,Integer>{
}
