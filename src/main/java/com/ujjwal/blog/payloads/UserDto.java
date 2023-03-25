package com.ujjwal.blog.payloads;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
	private int id;
	private String name;
	private String email;
	private String password;
	private String about;
}
