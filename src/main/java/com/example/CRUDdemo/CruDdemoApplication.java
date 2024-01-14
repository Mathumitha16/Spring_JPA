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
			createAndReadStudent(studentDaoVar);
		};
	}
	public void createAndReadStudent(studentDao studentDaoVar){

		Student tempStudent = new Student("Roja","Rani","rojaRani@gmail.com");
		System.out.println("New student created");
		studentDaoVar.save(tempStudent);
		System.out.println("Student with id : "+tempStudent.getId()+" saved in database");
		Student read = studentDaoVar.findById(tempStudent.getId());
		System.out.println("Displaying the read student");
		System.out.println(read.toString());
	}

}
