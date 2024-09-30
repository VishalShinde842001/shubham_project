package com.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.TopicInformation;

public interface TopicInformationDao extends JpaRepository<TopicInformation, Long> {

	@Query("SELECT ti FROM TopicInformation ti WHERE ti.topic.topicId = :topicId")
	List<TopicInformation> findTopicInformationByTopicId(@Param("topicId") Long topicId);
}
