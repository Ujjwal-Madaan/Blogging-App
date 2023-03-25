package com.ujjwal.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
	String resourceName;
	String fieldName;
	long fieldValue;

	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {

		// We always give string to super class
		super(String.format("%s not found with %s: %l", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}
