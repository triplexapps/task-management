package com.triplexng.taskmanagement.persistence.repository;

import com.triplexng.taskmanagement.persistence.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class ProjectRepositoryImplIntegrationTest {

    @Autowired
    private IProjectRepository projectRepository;

    @Test
    public void whenSavingNewProject_thenSuccess(){
        Project newProject = new Project((long)123, randomAlphabetic(6), LocalDate.now());

        assertThat(projectRepository.save(newProject), is(notNullValue()));
    }
    @Test
    public void givenProject_whenFindById_thenSuccess(){
        Project newProject = new Project((long)123, randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject);

        Optional<Project> retrievedProject = projectRepository.findById(newProject.getId());

        assertThat(retrievedProject.get(), is(equalTo(newProject)));
    }
}
