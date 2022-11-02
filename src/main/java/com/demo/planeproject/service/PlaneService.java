package com.demo.planeproject.service;

import java.util.List;

import com.demo.planeproject.Entity.Plane;
import com.demo.planeproject.error.PlaneNotFoundException;

public interface PlaneService {
	
Plane savePlane(Plane plane);

List<Plane> findAll();

List<Plane> findbyPlaneName(String name) throws PlaneNotFoundException;

Plane findById(int id);

Plane updatePlane(int id, Plane plane);

void deleteById(int id);

}
