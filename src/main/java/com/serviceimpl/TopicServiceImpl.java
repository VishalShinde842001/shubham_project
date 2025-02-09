package com.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TopicDao;
import com.model.Topic;
import com.model.TopicInformation;
import com.service.TopicInformationDao;
import com.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicDao topicDao;

	@Autowired
	private TopicInformationDao topicInformationDao;

	@Override
	public List<Topic> getAllTopics() throws Exception {
		return topicDao.findAll();
	}

	@Override
	public List<TopicInformation> getTopicInfoByTopic(Long topicId) throws Exception {
		return topicInformationDao.findTopicInformationByTopicId(topicId);
	}

}
