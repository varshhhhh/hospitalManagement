package DTO;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class appointment {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int id;
	String problem;
	LocalDateTime time;
	
	

	
	@ManyToOne
	doctor doctor;

}
