package com.example.CRUDdemo;

import com.example.CRUDdemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruDdemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruDdemoApplication.class, args);

	}
	@Bean
	public CommandLineRunner commandLineRunner(studentDao studentDaoVar){
		return runner ->{
			//createAndReadStudent(studentDaoVar);
			//queryAllStudents(studentDaoVar);
			//queryByLastName(studentDaoVar,"Balasubramaniam");
			updateLastName(studentDaoVar,1,"Manivasagam");
		};
	}



	public void createAndReadStudent(studentDao studentDaoVar){
        //creating new student object
		Student tempStudent = new Student("lokesh","Kumar","lokesh@gmail.com");
		System.out.println("New student created");
		//storing the student object to database
		studentDaoVar.save(tempStudent);
		System.out.println("Student with id : "+tempStudent.getId()+" saved in database");
		//querying the database based on primary key
		Student read = studentDaoVar.findById(tempStudent.getId());
		System.out.println("Displaying the read student");
		System.out.println(read.toString());
	}
	public void queryAllStudents(studentDao studentDaoVar){
		//fetching the result
		List<Student> res = studentDaoVar.findAll();
		//printing all the items from the result
		System.out.println("Printing the query result for find all");
		for(Student x : res){
			System.out.println(x.toString());
		}
	}
	private void queryByLastName(studentDao studentDaoVar, String name) {
		//Call the Dao
		List<Student> res = studentDaoVar.findByLastName(name);
		//print the result;
		System.out.println("Printing the query result for find by LastName");
		for(Student x : res){
			System.out.println(x.toString());
		}

	}
	public void updateLastName(studentDao studentDaoVar,int id, String newLastName){
		//find the data row to be updated
		Student toChange = studentDaoVar.findById(id);
		// change name by setter method
		toChange.setLastName(newLastName);
		//update to the database
		studentDaoVar.update(toChange);
	}

}
