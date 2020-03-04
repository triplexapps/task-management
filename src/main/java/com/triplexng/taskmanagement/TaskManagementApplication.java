package com.triplexng.taskmanagement;

import com.triplexng.taskmanagement.persistence.model.Project;
import com.triplexng.taskmanagement.persistence.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
public class TaskManagementApplication {


	public static void main(String[] args) {
		ApplicationContext context  = SpringApplication.run(TaskManagementApplication.class, args);

		IProjectRepository projectRepository = (IProjectRepository) context.getBean("IProjectRepository");
/*
		for(int i=0; i<10; i++) {
			projectRepository.save(new Project((long)i, "Kannadi", LocalDate.now()));
		}
 */
	}

}
