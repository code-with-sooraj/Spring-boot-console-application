package com.spring.management;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class ManagementApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ManagementApplication.class, args);
		CourseService cService = context.getBean(CourseService.class);
	}
	
	@Bean
	public CommandLineRunner demo(CourseService cService) {
		return (args)->{
			Scanner scanner = new Scanner(System.in);
			boolean flag =true;
			while(flag) {
				System.out.println("Course Management");
				System.out.println("1  :  Create");
				System.out.println("2  :  Show All Courses");
				System.out.println("3  :  Find a course");
				System.out.println("4  :  Update");
				System.out.println("5  :  Delete");
				System.out.println("6  :  Exit");
				System.out.print("Enter Your Choice: ");
				int choice = scanner.nextInt();
				if(choice==1) {
					System.out.print("Enter the course ID: ");
					int id = scanner.nextInt();
					Course course2=cService.findById(id);
					if(course2!=null) {
						System.out.println("Course already exist");
					}
					else {
						System.out.print("Enter the course Name: ");
						String courseName = scanner.next();
						System.out.print("Enter the course duration: ");
						int duration = scanner.nextInt();
					
						Course course = new Course();
						course.setCourseid(id);
						course.setCoursenameString(courseName);
						course.setDuration(duration);
					
						cService.saveCourse(course);
						System.out.println("You have succesfully added a course.");
					}
				}
				else if(choice==2) {
					List<Course> displayCourses= cService.findAllCourse();
					for(Course c : displayCourses) {
						System.out.println(c.getCourseid()+" "+c.getCoursenameString()+" "+c.getDuration());
					}
				}
				else if(choice==3) {
					System.out.print("Enter the Course ID: ");
					int id =scanner.nextInt();
					Course course = cService.findById(id);
					System.out.println(course.getCourseid()+" "+course.getCoursenameString()+" "+course.getDuration());
				}
				else if(choice==4) {
					System.out.print("Enter the course id for updation: ");
					int id = scanner.nextInt();
					Course course = cService.findById(id);
					if(course!=null) {
						System.out.print("Enter the new Course name: ");
						String newCoursenameString = scanner.next();
						System.out.print("Enter the duration for the new course: ");
						int newDuration = scanner.nextInt();
						course.setCourseid(id);
						course.setCoursenameString(newCoursenameString);
						course.setDuration(newDuration);
						
						cService.updateCourse(course);
					}
					else {
						System.out.println("Course doesn't matched with ID.");
					}
				}
				else if(choice==5) {
					System.out.print("Enter the course ID for deletion: ");
					int id=scanner.nextInt();
					Course course  = cService.findById(id);
					if(course!=null)
					{
						cService.deleteCourse(id);
						System.out.println("Course deleted successfully.");
					}
					else {
						System.out.println("Course is not found.");
					}
				}
				else if(choice==6)
				{
					flag=false;
				}
				else {
					System.out.println("You have entered wrong choice. Enter again!");
				}
			}
		};
	}
	

}
