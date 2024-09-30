package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bo.ErrorConstants;
import com.bo.Response;
import com.service.TopicService;

@RestController
@CrossOrigin
@RequestMapping("/rest/")
public class TopicController {

	@Autowired
	private TopicService topicService;

	@GetMapping("all-topics")
	public Response getAllTopics() {
		Response response = new Response();
		try {
			response.setResult(topicService.getAllTopics());
			response.setStatus(ErrorConstants.SUCESS);
			response.setMessage("All Topics get Sucessfully...");
		} catch (Exception e) {
			response.setStatus(ErrorConstants.INTERNAL_SERVER_ERROR);
			response.setMessage(ErrorConstants.INTERNAL_SERVER_ERROR_MESSAGE);

		}
		return response;
	}

	@GetMapping("topic-information-{topicId}")
	public Response getAllTopics(@PathVariable Long topicId) {
		Response response = new Response();
		try {
			response.setResult(topicService.getTopicInfoByTopic(topicId));
			response.setStatus(ErrorConstants.SUCESS);
			response.setMessage("Topic Info get Sucessfully...");
		} catch (Exception e) {
			response.setStatus(ErrorConstants.INTERNAL_SERVER_ERROR);
			response.setMessage(ErrorConstants.INTERNAL_SERVER_ERROR_MESSAGE);

		}
		return response;
	}

}
