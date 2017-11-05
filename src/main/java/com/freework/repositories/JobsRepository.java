package com.freework.repositories;

import com.freework.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "jobs")
public interface JobsRepository extends JpaRepository<Job,Integer>{
}
