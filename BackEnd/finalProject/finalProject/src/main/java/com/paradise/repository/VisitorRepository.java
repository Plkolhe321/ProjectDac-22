package com.paradise.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.paradise.entity.Visitor;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Integer>{
	
	@Transactional
	@Query("Select username from Visitor v where v.username=:username")
	public String findByUserName2(@Param("username") String username);

	@Transactional
	@Query("Select v from Visitor v where v.username=:username")
	public Visitor findByUserName(@Param("username") String username);
	
	@Transactional
	@Modifying
	@Query("Delete from Visitor v where v.visitorId=:id")
	public void deleteVisitor(@Param("id") Integer id);
	
	@Transactional
	@Query("Select v from Visitor v where v.username=:username and v.password=:password")
	public Visitor login(@Param("username") String id,@Param("password") String password);

}