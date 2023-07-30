package location_vector_mgmt.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import location_vector_mgmt.model.dto.LocationVector_DTO;
import location_vector_mgmt.service.I_LocationVector_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/locationVectorManagement")
public class LocationVector_Controller 
{

//	private static final Logger logger = LoggerFactory.getLogger(LocationVector_Controller.class);

	@Autowired
	private I_LocationVector_Service locationVectorServ;
	
	@PostMapping("/new")
	public ResponseEntity<LocationVector_DTO> newLocationVector(@RequestBody LocationVector_DTO locationVectorDTO) {
		LocationVector_DTO locationVectorDTO2 = locationVectorServ.newLocationVector(locationVectorDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(locationVectorDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllLocationVectors", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LocationVector_DTO>> getAllLocationVectors() 
	{
		ArrayList<LocationVector_DTO> LocationVectorDTOs = locationVectorServ.getAllLocationVectors();
		return new ResponseEntity<>(LocationVectorDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectLocationVectors", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LocationVector_DTO>> getSelectLocationVectors(@RequestBody ArrayList<Long> locationVectorSeqNos)
	{
		ArrayList<LocationVector_DTO> LocationVectorDTOs = locationVectorServ.getSelectLocationVectorDetails(locationVectorSeqNos);		
		return new ResponseEntity<>(LocationVectorDTOs, HttpStatus.OK);
	}	
	
	@PutMapping("/updLocationVector")
	public void updateLocationVector(@RequestBody LocationVector_DTO LocationVectorDTO) 
	{
			locationVectorServ.updLocationVector(LocationVectorDTO);	
		return;
	}

	@DeleteMapping("/delSelectLocationVector")
	public void deleteSelectLocationVector(@RequestBody ArrayList<Long> locationVectorSeqNoList) 
	{
		locationVectorServ.delSelectLocationVectorDetails(locationVectorSeqNoList);
		return;
	}
	
	@DeleteMapping("/delAllLocationVector")
	public void deleteAllLocationVectors() {
		locationVectorServ.delAllLocationVectors();
		return;
	}
	}