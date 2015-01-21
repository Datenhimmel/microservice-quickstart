package de.adesso.microservice.domain;

import java.util.Date;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Data public class Comment {
	
	@Id private String id;
	private String articleID;
	private String title;
	private String content;
	private Date createdOn;
	private User author;
}
