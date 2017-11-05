package com.freework.repositories;

import com.freework.entities.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "entries")
public interface EntitiesRepository extends JpaRepository<Entry,Integer>{

}
