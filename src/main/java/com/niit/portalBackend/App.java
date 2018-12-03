package com.niit.portalBackend;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.config.DBConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Scanner sc = new Scanner(System.in);
        
        DBConfig dbConfig=new DBConfig();
        
        dbConfig.sessionFactory();
        
        System.out.println("Enter your choice : 1.User 2.Job 3.Blog");
        
        int choice=sc.nextInt();
        
        switch(choice)
        {
        case 1:
        {
        UserMain userMain=new UserMain();
    	     userMain.userOut();
    	     break;
        }
        
        case 2:
        {
        JobMain jobMain=new JobMain();
        jobMain.jobOut();
    	     break;
        }
       /* case 3:
        {
        BlogMain blogMain=new BlogMain();
        blogMain.blogOut();
    	     break;
        }*/
        default:
       	 System.out.println("Please enter valid option");
        }
       
    		     
        
        
       
        
    }
}
    
   
