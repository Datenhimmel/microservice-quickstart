package de.adesso.microservice.domain;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

public class Comment {
	
	@Id @Setter @Getter private String id;
	@Setter @Getter private String articleID;
	@Setter @Getter private String title;
	@Setter @Getter private String content;
	@Setter @Getter private Date createdOn;
	@Setter @Getter private User author;
}
