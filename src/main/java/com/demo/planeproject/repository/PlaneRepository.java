package com.demo.planeproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.planeproject.Entity.Plane;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Integer>{

	
	List<Plane> findAllByPlaneName(String name);

}
