package com.model;

import java.io.Serializable;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entry implements Serializable {

	@Id
	private String link;
	private String API;
	private String Description;
	private String Auth;
	private String https;
	private String category;
	private String cors;
}
