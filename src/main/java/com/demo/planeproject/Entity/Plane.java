package com.demo.planeproject.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Plane {

	@Id
	@SequenceGenerator(
			name = "planesequence",
			sequenceName = "planesequence",
			allocationSize = 1
	    	)
	@GeneratedValue(
			strategy =  GenerationType.SEQUENCE,
			generator = "planesequence"
			)
	public int id;
	@Column(unique=true, nullable = false)
	@NotEmpty(message = "Please provide a Plane Name")
	public String planeName;
	
	@ManyToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER
			)
	@JoinColumn(
			name = "model_id",
			referencedColumnName = "modelId"
			)
	public Model model;
	
	
}
