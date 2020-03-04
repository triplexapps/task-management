package com.triplexng.taskmanagement.service;

import java.util.Optional;

import com.triplexng.taskmanagement.persistence.model.Project;

public interface IProjectService {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
