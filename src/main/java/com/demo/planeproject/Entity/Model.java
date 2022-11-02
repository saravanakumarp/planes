package com.demo.planeproject.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int modelId;
	
	private int versionId;

}
