package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dto.EntryDTO;
import com.exception.EntryException;
import com.model.Entry;
import com.service.EntryService;

@RestController
public class EntryController {

	@Autowired
	private EntryService entryService;
	
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<EntryDTO>> getAllEntriesByCateogory(@PathVariable("category") String category) throws EntryException{
		
		return new ResponseEntity<>(entryService.getAllEntriesByCateogory(category),HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping("/add/entries")
	public ResponseEntity<Entry> saveEntry(@RequestBody Entry entry){
		
		return new ResponseEntity<>(entryService.saveEntry(entry),HttpStatus.CREATED);
		
	}
	
}
