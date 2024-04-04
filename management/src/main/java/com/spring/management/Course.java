package com.spring.management;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Component
public class Course {

	@Id
	private int courseid;
	private String coursenameString;
	private int  duration;
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCoursenameString() {
		return coursenameString;
	}
	public void setCoursenameString(String coursenameString) {
		this.coursenameString = coursenameString;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	

}
