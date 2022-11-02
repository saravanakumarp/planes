package com.demo.planeproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.planeproject.Entity.Plane;
import com.demo.planeproject.error.PlaneNotFoundException;
import com.demo.planeproject.service.PlaneService;

@RestController
@Validated
public class PlaneController {
	
	@Autowired
	PlaneService planeService;
	
	@PostMapping("/")
    public Plane savePlanes(@Valid @RequestBody Plane plane) {
    	Plane planeSaved = planeService.savePlane(plane); ;
    	
		return planeSaved;
    	
    }
	
	@GetMapping("/")
	public List<Plane> getAllPlanes(){
	 List<Plane> planes = new ArrayList<Plane>();
	 planes = planeService.findAll();
	 return planes;

	}

	@GetMapping("/planes/name/{name}")
	public List<Plane> getPlanesByName(@PathVariable("name") String name ) throws PlaneNotFoundException{
		 List<Plane> planes = new ArrayList<Plane>();
		 planes = planeService.findbyPlaneName(name);
		 return planes;

	}
	
	@GetMapping("/planes/{id}")
	public  ResponseEntity<Plane> findById(@PathVariable("id") int id){
		Plane plane = planeService.findById(id);
		return new ResponseEntity<Plane>(plane,HttpStatus.OK);
		
	}
	
	@PutMapping("/planes/{id}")
	public Plane updatePlane(@PathVariable("id") int id , @RequestBody Plane plane) {
		return planeService.updatePlane(id,plane);
  }
	
	@DeleteMapping("/planes/{id}")
	public String deletePlane(@PathVariable("id") int id) {
		
		planeService.deleteById(id);
		return "deleted Succesfully";
	}
}
