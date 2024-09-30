package com.service;

import java.util.List;
import com.model.Topic;
import com.model.TopicInformation;

public interface TopicService {

	public List<Topic> getAllTopics() throws Exception;

	public List<TopicInformation> getTopicInfoByTopic(Long topicId) throws Exception;

}
