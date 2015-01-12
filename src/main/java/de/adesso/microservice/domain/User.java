package de.adesso.microservice.domain;

import lombok.Getter;
import lombok.Setter;

public class User {
	@Setter @Getter private String firstName;
	@Setter @Getter private String lastName;
}