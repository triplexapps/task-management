package com.triplexng.taskmanagement.service.impl;

import com.triplexng.taskmanagement.persistence.model.Project;
import com.triplexng.taskmanagement.persistence.repository.IProjectRepository;
import com.triplexng.taskmanagement.service.IProjectService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private IProjectRepository projectRepository;

    public ProjectServiceImpl(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> findById(Long id) {
        LOG.debug("Project Service >> Finding Project By Id {}", id);
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        LOG.debug("Project Service >> Saving Project {}", project);
        return projectRepository.save(project);
    }
}
