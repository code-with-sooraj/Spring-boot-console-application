package com.spring.management;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepo cRepo;
	public Course saveCourse(Course course) {
		return cRepo.save(course);
	}
	
	public List<Course> findAllCourse(){
		return (List<Course>) cRepo.findAll();		
	}
	
	public Course findById(int id) {
		return cRepo.findById(id).orElse(null);
	}
	
	public Course updateCourse(Course course)
	{
		Course existedCourse = findById(course.getCourseid());
		if(existedCourse!=null) {
			existedCourse.setCourseid(course.getCourseid());
			existedCourse.setCoursenameString(course.getCoursenameString());
			existedCourse.setDuration(course.getDuration());
			cRepo.save(existedCourse);
		}
		return existedCourse;
	}
	
	public String deleteCourse(int id) {
		cRepo.deleteById(id);
		return "Course removed from systeeeeemmmmm";
	}
}
