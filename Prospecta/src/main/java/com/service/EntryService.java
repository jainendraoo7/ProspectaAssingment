package com.service;

import java.util.List;

import com.dto.EntryDTO;
import com.exception.EntryException;
import com.model.Entry;

public interface EntryService {

	public List<EntryDTO> getAllEntriesByCateogory(String category)throws EntryException;
	
	public Entry saveEntry(Entry entry);
	
	
}
