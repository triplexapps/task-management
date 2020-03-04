package com.triplexng.taskmanagement.persistence.repository;

import java.util.Optional;

import com.triplexng.taskmanagement.persistence.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface IProjectRepository extends CrudRepository<Project, Long> {

    /*
    Optional<Project> findById(Long id);

    Project save(Project project);
    */
}
