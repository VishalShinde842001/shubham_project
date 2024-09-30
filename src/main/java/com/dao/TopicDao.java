package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Topic;

public interface TopicDao extends JpaRepository<Topic, Long> {

}
