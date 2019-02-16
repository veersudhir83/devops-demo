package io.sudheer.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	// Using Static List
	/*List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "Springframework", "Springframework Description"),
			new Topic("java", "Core Java", "Core Java Description"),
			new Topic("javascript", "Javascript", "Javascript Description")
			));*/

	public List<Topic> getTopics() {
		// return topics; // Using Static list
		
		// Using Persistence API
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		// Using Static list
		// return topics.stream().filter(t -> t.getId().equalsIgnoreCase(id)).findFirst().get();
		
		// Using Persistence API
		return topicRepository.findOne(id);
	}

	public String addTopic(Topic topic) {
		String message;
		// Using Static list
		/*if (topics.stream().anyMatch(t -> t.getId().equalsIgnoreCase(topic.getId()))) {
			message = "Already Exists";
		} else {
			topics.add(topic);
			message = "Added Topic";
		}*/
		
		// Using Persistence API
		topicRepository.save(topic);
		message = "Added Topic";
		return message;
		
	}

	public String updateTopic(String id, Topic topic) {
		// Using Static list
		/*Topic t = null;
		String message = "Not found and Not Updated";
		for(int i=0; i < topics.size(); i++) {
			t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				message = "Topic Updated";
				return message;
			}
		}*/
		
		// Using Persistence API
		String message = "Topic Updated";
		topicRepository.save(topic);
		return message;
	}
	
	public String deleteTopic(String id) {
		// Using Static list
		//Using Lambda predicate
		/*topics.removeIf(t -> t.getId().equals(id));
		return "Topic Deleted";*/
		
		//General for loop
		/*Topic t = null;
		for(int i=0; i < topics.size(); i++) {
			t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.remove(i);
				System.out.println("Topic Deleted");
				return;
			}
		}*/
		
		// Using Persistence API
		topicRepository.delete(id);
		return "Topic Deleted";
	}
}
