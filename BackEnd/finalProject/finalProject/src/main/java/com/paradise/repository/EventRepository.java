package com.paradise.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paradise.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer>{
	
	@Transactional
	@Query("Select e from Event e where e.eventName=:name")
	public Optional<Event> findByName(@Param("name") String name);


}
