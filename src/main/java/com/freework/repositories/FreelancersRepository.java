package com.freework.repositories;

import com.freework.entities.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "freelancers")
public interface FreelancersRepository extends JpaRepository<Freelancer,Integer>{

    public Freelancer findByName(String name);

}
