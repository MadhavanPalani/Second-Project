package com.niit.portalBackend;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.UserDAO;
import com.niit.model.User;

public class UserMain
{
	public void userOut()
	{
		 Scanner sc = new Scanner(System.in);
	     AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	    	UserDAO userDAO = (UserDAO) context.getBean("userDAO");
	    	  
	       
	        User user1 = new User();
	        
	        System.out.println("Please select a category to do the manipulation");
	    	System.out.println("1.Add User /n 2.Delete User /n 3.Update User /n 4.View All Users /n 5.View Users by name");
	    	
	    	int choice = sc.nextInt();
	        
	    	switch(choice)
	    	{
	    	
	    	case 1:
	    		
	    		 System.out.println("Please Enter the user details to enter");
	 			
	    			
	 			
	 			System.out.println("User emailID:");

	 			user1.setEmail(sc.next());
	 			
	 			System.out.println("Enter password:");

	 			user1.setPassword(sc.next());
	 			System.out.println("Enter first name:");

	 			user1.setFirstname(sc.next());
	 			System.out.println("Enter last name:");

	 			user1.setLastname(sc.next());
	 			
	 			System.out.println("Enter role:");

	 			user1.setRole(sc.next());
	 			
	 			System.out.println("Enter phone number");
	 			
	 			user1.setPhonenumber(sc.next());
	 			
	 			
	 			userDAO.registerUser(user1);
	 			
	 			
	 			break;
	 			
	    	/*case 2:
	    		List<User> userList1 = userDAO.findAllUsers();
	    		for(User user : userList1)
	    		{
	    			
	    			System.out.print("User Name:"+user.getUsername() +"|");
	    			System.out.print("First Name"+user.getFirstname() +"|");
	    			System.out.print("Last Name:"+user.getLastname() +"|");
	    			System.out.print("Email ID:"+user.getEmail() +"");
	    			System.out.print("PhoneNumber:"+user.getPhonenumber() +"");
	    			
	    			System.out.println("");

	    		}
	    		System.out.println("Please enter the User to be deleted from the above Table");
	    		String username = sc.next();
	    		boolean result = userDAO.deleteUser(username);
	    		if(result == true)
	    		{
	    			System.out.println("The user has been successfuly deleted");
	    		}
	    		break;*/
	    		
	    	case 3:
	    		
	    		List<User> userList2 = userDAO.findAllUsers();
	    		for(User user : userList2)
	    		{
	    			System.out.print("User Name:"+user.getFirstname() +"|");
	    			/*System.out.print("First Name : "+user.getFirstname() +"|");*/
	    			System.out.print("Last Name:"+user.getLastname() +"|");
	    			System.out.print("Email ID:"+user.getEmail() +"");
	    			System.out.print("PhoneNumber:"+user.getPhonenumber() +"");
	    			
	    			System.out.println("");


	    		}
	    		
	    		/*
	    		 System.out.println("Please Enter the user details to enter");
		 			
	    			
		 			
		 			System.out.println("UserName:");

		 			user1.setUsername(sc.next());
		 			
		 			System.out.println("Enter password:");

		 			user1.setPassword(sc.next());
		 			System.out.println("Enter first name:");

		 			user1.setFirstname(sc.next());
		 			System.out.println("Enter last name:");

		 			user1.setLastname(sc.next());
		 			System.out.println("Enter email");
		 			
		 			user1.setEmail(sc.next());
		 			System.out.println("Enter phone number");
		 			
		 			user1.setPhonenumber(sc.next());
		 			
	    		
	    		boolean result2 = userDAO.updateUser(user1);
	    		if(result2 == true)
	    		{
	    			System.out.println("User Details has been updated successfully");
	    		}
*/	    		break;
	    		
	    	case 2:
	    		System.out.println("Please enter the User emailID to view User Details");
	    		String email= sc.next();
	    		User userList =userDAO.getUser(email);
	    		
	    			
	    			System.out.print("First Name : "+userList.getFirstname() +"|");
	    			System.out.print("Last Name:"+userList.getLastname() +"|");
	    			System.out.print("Email ID:"+userList.getEmail() +"");
	    			System.out.print("PhoneNumber:"+userList.getPhonenumber() +"");
	    			System.out.print("User Role:"+userList.getRole() +"");
	    			
	    			System.out.println("");
	    		
	    		break;
	    		
	    	/*case 5:
	    		
	    		System.out.println("Please enter the UserName to view User Details");
	    		String username1 = sc.next();
	    		User user2 = userDAO.findUserByName(username1);
	    		System.out.print("User Name:"+user2.getUsername() +"|");
    			System.out.print("First Name : "+user2.getFirstname() +"|");
    			System.out.print("Last Name:"+user2.getLastname() +"|");
    			System.out.print("Email ID:"+user2.getEmail() +"");
    			System.out.print("PhoneNumber:"+user2.getPhonenumber() +"");
    			
    			System.out.println("");
	    		break;*/
	    		
	    		
	    		
	    		
	    		
		        
	    	}
	    	context.close();
			sc.close();
	    	}
}
	       
			
			
	



