package com.freework.repositories;

import com.freework.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "companies")
public interface CompaniesRepository extends JpaRepository<Company,Integer>{

}
