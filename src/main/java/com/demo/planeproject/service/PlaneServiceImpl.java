package com.demo.planeproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.planeproject.Entity.Plane;
import com.demo.planeproject.error.PlaneNotFoundException;
import com.demo.planeproject.repository.PlaneRepository;

@Service
public class PlaneServiceImpl implements PlaneService {

	@Autowired
	PlaneRepository repo;
	
	@Override
	public Plane savePlane(Plane plane) {
		Plane savedPlane = repo.save(plane);
		return savedPlane;
	}

	@Override
	public List<Plane> findAll() {
	
		return repo.findAll();
	}

	@Override
	public List<Plane> findbyPlaneName(String name) throws PlaneNotFoundException  {
		List<Plane> planeList = repo.findAllByPlaneName(name);
		if(planeList.isEmpty()) {
			throw new PlaneNotFoundException("This plane is not found ");
		}
		return planeList;
	}

	@Override
	public Plane findById(int id) {
			return repo.findById(id).get();
	}

	@Override
	public Plane updatePlane(int id, Plane plane) {
		Plane plane_toUpdate = repo.findById(id).get();
		plane_toUpdate.setPlaneName(plane.getPlaneName());
		
		return repo.save(plane_toUpdate);
	}

	@Override
	public void deleteById(int id) {
	   
		repo.deleteById(id);
		
	}

	

	

}
