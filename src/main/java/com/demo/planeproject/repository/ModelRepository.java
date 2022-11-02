package com.demo.planeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.planeproject.Entity.Model;
@Repository
public interface ModelRepository extends JpaRepository<Model, Integer>{

}
