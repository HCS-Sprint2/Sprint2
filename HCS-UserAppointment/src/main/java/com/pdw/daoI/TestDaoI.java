package com.pdw.daoI;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pdw.entity.Test;
@Repository
public interface TestDaoI extends JpaRepository<Test,String>{

}