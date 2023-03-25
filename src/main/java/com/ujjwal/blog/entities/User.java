package com.ujjwal.blog.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Users") // To give your table the name
@NoArgsConstructor // NoArgsConstructor is necessary for getters and setters. And AllArgsConstructor makes the getters and setters un usable.
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
	// Now we need to set primary key in the table
	@Id // This helps to set this as primary key
	@GeneratedValue(strategy = GenerationType.AUTO) // To auto increment the value
	private int id;

	@Column(name = "user_name", nullable = false, length = 100) // This name can't be null and the length of this name will be 100
	private String name;

	private String email;

	private String password;

	private String about;
}
