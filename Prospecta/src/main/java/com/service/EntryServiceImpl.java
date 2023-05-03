package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dto.AllEntryDTOs;
import com.dto.EntryDTO;
import com.exception.EntryException;
import com.model.Entry;
import com.repository.EntryRepository;

@Service
public class EntryServiceImpl implements EntryService {

	  @Autowired
	  private EntryRepository entryDao;
	
	 private static final String baseurl = "https://api.publicapis.org";
	
	 private RestTemplate restTemplate =  new RestTemplate(); 
	
	 
	@Override
	public List<EntryDTO> getAllEntriesByCateogory(String category) throws EntryException {
		
		AllEntryDTOs allEntryDtos  = restTemplate.getForObject(baseurl + "/entries", AllEntryDTOs.class);
		
		List<EntryDTO> listofdto = new ArrayList<>(); 
		
		
		if(allEntryDtos.getEntries().isEmpty()) {
			throw new EntryException("Entry Not Found");
		}
		
		else
			
			for(Entry entry: allEntryDtos.getEntries()) {
				
				EntryDTO dto = new EntryDTO();
				
				dto.setDescription(entry.getDescription());
				dto.setTitle(entry.getAPI());
				listofdto.add(dto);
				
			}
			
		
		return listofdto;
	}


	@Override
	public Entry saveEntry(Entry entry) {
	    
	   AllEntryDTOs allEntryDtos = restTemplate.getForObject(baseurl, AllEntryDTOs.class);
		
	   List<Entry> list = allEntryDtos.getEntries(); 
		
	   list.add(entry);
	   
	   return entryDao.save(entry);
		
	}
	
	
	

}
