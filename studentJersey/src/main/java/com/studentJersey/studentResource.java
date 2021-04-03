package com.studentJersey;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import studentJersey.entities.Student;
import studentJersey.repository.studentRepository;

@Path("studentResource")
public class studentResource 
{
	studentRepository studentRepo = new studentRepository();
	
	
	// get list resource
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	   public List<Student> getstudents()
	   {
		 
		   return studentRepo.getstudents(); 
	   }
	
	
	// get single data resource
	@GET
	@Path("Student/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	   public Student getstudentByid(@PathParam("id") int id)
	   {
		   return studentRepo.getstudentByid(id); 
	   }
	
	
	// add new data resource
	@POST
	@Path("addStudent")
	@Consumes(MediaType.APPLICATION_JSON)
	public Student addStudent(Student student)
	{ 
		System.out.println("new added :" +student);
		
		studentRepo.addStudent(student);
		return student;
		
	}
	// update  resource
	
	@PUT
	@Path("updateStudent")
	@Consumes(MediaType.APPLICATION_JSON)
	public Student updateStudent(Student student)
	{ 
		System.out.println("data update successfully..! :" +student);
		
		studentRepo.updateStudent(student);;
		return student;
		
	}
	
	// // delete  resource
	@DELETE
	@Path("deleteStudent/{id}")
	   public Student deletestudent(@PathParam("id") int id)
	   {
		   Student st= studentRepo.getstudentByid(id); 
		   if(st.getId()!=0)
		   {
			   studentRepo.deletestudent(id);
			   System.out.println(st +" : this  data is delete successfully..! :" );
				
		   }
			   
		   return st;
	   }
	
}


