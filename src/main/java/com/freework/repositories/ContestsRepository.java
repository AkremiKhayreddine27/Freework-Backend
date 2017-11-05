package com.freework.repositories;

import com.freework.entities.Contest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "contests")
public interface ContestsRepository extends JpaRepository<Contest,Integer>{
}
