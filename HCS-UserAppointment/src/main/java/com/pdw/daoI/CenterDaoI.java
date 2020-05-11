package com.pdw.daoI;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdw.entity.DiagnosticCentre;
@Repository
public interface CenterDaoI extends JpaRepository<DiagnosticCentre,String>{
	
}
