package com.pdw.daoI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdw.entity.Appointment;


//Dao interface extending Data JPA methods for the appointments class to perform operations

@Repository
public interface AppointmentDaoI extends JpaRepository<Appointment, String> {

	
}
