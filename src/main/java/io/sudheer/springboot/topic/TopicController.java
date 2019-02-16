package io.sudheer.springboot.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired 
	private TopicService topicService;
	
	@RequestMapping("/topics")
	//gets all topics using service
	public List<Topic> getTopics() { 
		return topicService.getTopics();
	}
	
	@RequestMapping("/topics/{id}")
	//gets the topic using service
	public Topic getTopic(@PathVariable("id") String id) { 
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	//adds the topic using service
	public String addTopic(@RequestBody Topic topic) {
		return topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	//updates the topic using service
	public String updateTopic(@RequestBody Topic topic, @PathVariable("id") String id) {
		return topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	//Deletes the topic using service
	public String removeTopic(@PathVariable("id") String id) {
		return topicService.deleteTopic(id);
	}
}
