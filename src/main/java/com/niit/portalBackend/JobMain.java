package com.niit.portalBackend;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.JobDAO;
import com.niit.model.Job;

public class JobMain
{
	public void jobOut()
	{
		 Scanner sc = new Scanner(System.in);
	     AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	    	JobDAO jobDAO = (JobDAO) context.getBean("jobDAO");
	    	  
	       
	        Job job1 = new Job();
	        
	        System.out.println("Please select a category to do the manipulation");
	    	System.out.println("1.Add Job /n 2.Get All jobs ");
	    	
	    	int choice = sc.nextInt();
	        
	    	switch(choice)
	    	{
	    	
	    	case 1:
	    		
	    		 System.out.println("Please Enter the user details to enter");
	 			
	    			
	 		
	 			
	 			System.out.println("Enter Job Title:");

	 			job1.setJobTitle(sc.next());
	 			
	 			System.out.println("Enter Job Description:");

	 			job1.setJobDescription(sc.next());
	 			
	 			System.out.println("Enter Skills Required:");

	 			job1.setSkillsRequired(sc.next());
	 			
	 			System.out.println("Enter Salary:");

	 			job1.setSalary(sc.next());
	 			
	 			System.out.println("Enter Location");
	 			
	 			job1.setLocation(sc.next());
	 			
	 			System.out.println("Enter Company name");
	 			
	 			job1.setCompanyName(sc.next());
	 			
	 			System.out.println("Enter Years of Exp");
	 			
	 			job1.setYrsOfExp(sc.next());
	 			
	 			
	 			
	 			
	 			jobDAO.addJob(job1);
	 			
	 			
	 			break;
	 			
	    	
	    	case 2:
	    		System.out.println("Please enter the User emailID to view User Details");
	    		String email= sc.next();
	    		List<Job> jobList =jobDAO.getAllJobs();
	    		
	    		for(Job job : jobList)
	    		{

		 			System.out.println("JobID:" + job.getId());

		 	
		 			
		 			System.out.println(" Job Title:" +job.getJobTitle());

		 	
		 			
		 			System.out.println(" Job Description:"+ job.getJobDescription());

		 	
		 			
		 			System.out.println(" Skills Required:"+job.getSkillsRequired());

		 	
		 			
		 			System.out.println(" Salary:"+job.getSalary());

	
		 			
		 			System.out.println(" Location"+job.getLocation());
		 			
		 		
		 			
		 			System.out.println("Company name"+job.getCompanyName());
		 			
		 
		 			
		 			System.out.println(" Years of Exp"+job.getYrsOfExp());
		 			
		 	
		 			
		 			
		 			
	    			
	    			System.out.println("");
	    		}
	    		
	    		break;
	    		
	    	
	    		
	    		
	    		
		        
	    	}
	    	context.close();
			sc.close();
	    	}
}
	       
			
			
	



