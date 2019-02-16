package io.sudheer.springboot.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getCourses(String topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id) {
		return courseRepository.findOne(id);
	}

	public String addUpdateCourse(Course course) {
		String message = "Added/Updated Course";
		courseRepository.save(course);
		return message;
	}

	public String deleteCourse(String id) {
		courseRepository.delete(id);
		return "Course Deleted";
	}
}
