package com.dto;

import java.io.Serializable;
import java.util.List;

import com.model.Entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllEntryDTOs implements Serializable {

	private int count;
	private List<Entry> entries;
	
	
}
