package com.triplexng.taskmanagement.service;

import com.triplexng.taskmanagement.persistence.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class ProjectServiceImplIntegrationTest {

    @Autowired
    private IProjectService projectService;

    @Test
    public void whenSavingProject_thenOK(){
        Project savedProject = projectService.save(new Project((long) 123, "name", LocalDate.now()));

        assertThat(savedProject, is(notNullValue()));
    }
}
