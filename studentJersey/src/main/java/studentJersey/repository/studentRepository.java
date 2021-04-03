package studentJersey.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import studentJersey.entities.Student;

public class studentRepository 
{
	
	
	   // database connection
	Connection con=null;
	
	public  studentRepository()
	{
	  String url= "jdbc:mysql://localhost:3306/studenttablejercy";
	   String Username  ="root";
	   String Password  ="";
		  try
		  {
			 Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,Username,Password);
		  } 
		   catch (SQLException e) {
			System.out.println("exception raised...!" +e);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("exception raiseddd...!" +e);
			e.printStackTrace();
		}
		
		  
	}
	
	
   // get all  list
	public List<Student> getstudents()
	{
		List<Student> list = new ArrayList<>();
		String str= "select * from student";
	try 
    	{
		 Statement stm =con.createStatement();
	     ResultSet rs = stm.executeQuery(str);
	     while(rs.next())
	     {
	    	 Student s= new Student();
	    	 s.setId(rs.getInt(1));
	    	 s.setName(rs.getString(2));
	    	 s.setDob(rs.getString(3));
	    	 s.setDoj(rs.getString(4));
	    	list.add(s);
	     }
 	}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		return list;
	}
	
	
	// get single data
	public Student getstudentByid(int id)
	{
		String str= "select * from student where id="+id;
		 Student s= new Student();
		try 
	    	{
			 Statement stm =con.createStatement();
		     ResultSet rs = stm.executeQuery(str);
		     if(rs.next())
		     {
		    	
		    	 s.setId(rs.getInt(1));
		    	 s.setName(rs.getString(2));
		    	 s.setDob(rs.getString(3));
		    	 s.setDoj(rs.getString(4));
		     }
	 	}
			catch(Exception e)
			{
				System.out.println(e);
				
			}
		return s;
		
	}

  // add new student
	public void addStudent(Student student)
	{
		String str = "insert into student values(?,?,?,?)";
		try 
    	{
		PreparedStatement pst =con.prepareStatement(str);
		  pst.setInt(1,student.getId());
		  pst.setString(2, student.getName());
		  pst.setString(3,student.getDob());
		  pst.setString(4, student.getDoj());
		  
		  pst.executeUpdate();

     	}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		
	}
	
	// update
		public void updateStudent(Student student)
		{
			String str = "update student set name=?, dob=?, doj=? where id=?";
			try 
	    	{
			PreparedStatement pst =con.prepareStatement(str);
			 
			  pst.setString(1, student.getName());
			  pst.setString(2,student.getDob());
			  pst.setString(3, student.getDoj());
			  pst.setInt(4,student.getId());
			  
			  pst.executeUpdate();

	     	}
			catch(Exception e)
			{
				System.out.println(e);
				
			}
			
		}// end update

   // delete
		public void deletestudent(int id) 
		{
			String str = "delete from student where id=?";
			try 
	    	{
			PreparedStatement pst =con.prepareStatement(str);
			 
			  pst.setInt(1,id);
			  
			  pst.executeUpdate();

	     	}
			catch(Exception e)
			{
				System.out.println(e);
				
			}
			
		}// end delete

}



