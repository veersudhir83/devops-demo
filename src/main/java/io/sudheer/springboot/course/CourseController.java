package io.sudheer.springboot.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.sudheer.springboot.topic.Topic;

@RestController
public class CourseController {

	@Autowired 
	private CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses")
	//gets all courses using service
	public List<Course> getCourses(@PathVariable("topicId") String topicId) { 
		return courseService.getCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	//gets the course using service
	public Course getCourse(@PathVariable("id") String id) { 
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	//adds the course using service
	public String addCourse(@RequestBody Course course, @PathVariable("topicId") String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		return courseService.addUpdateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	//updates the course using service
	public String updateCourse(@RequestBody Course course, @PathVariable("topicId") String topicId, @PathVariable("id") String id) {
		course.setTopic(new Topic(topicId, "", ""));
		return courseService.addUpdateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	//Deletes the course using service
	public String removeCourse(@PathVariable("id") String id) {
		return courseService.deleteCourse(id);
	}
}
