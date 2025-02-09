package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TopicInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "topic_information_id")
	private Long topicInformationId;

	@Column(name = "heading")
	private String heading;

	@Column(name = "subheading")
	private String subheading;

	@Column(name = "content", columnDefinition = "LONGTEXT")
	private String content;

	@ManyToOne
	@JoinColumn(name="topic_id")
	private Topic topic;

}
