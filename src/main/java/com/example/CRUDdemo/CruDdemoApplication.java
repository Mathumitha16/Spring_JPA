package com.example.CRUDdemo;

import com.example.CRUDdemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruDdemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruDdemoApplication.class, args);

	}
	@Bean
	public CommandLineRunner commandLineRunner(studentDao studentDaoVar){
		return runner ->{
			createStudent(studentDaoVar);
		};
	}
	public void createStudent(studentDao studentDaoVar){

		Student tempStudent = new Student("Mathumitha","Manovasagam","mehamani7@gmail.com");
		System.out.println("New student created");
		studentDaoVar.save(tempStudent);
		System.out.println("Student with id : "+tempStudent.getId()+" saved in database");
	}

}
