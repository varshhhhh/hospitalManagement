package DTO;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

public class appointment {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int id;
	String problem;
	LocalDateTime time;
	
	
	@ManyToOne
	patient patient;
	
	@ManyToOne
	doctor doctor;

}
