package com.paradise.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paradise.entity.Booking;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{

	@Transactional
	@Modifying
	@Query("Delete from Booking b where b.bookingId=:id")
	public void deleteBooking(@Param("id") Integer id);

	@Transactional
	@Query("Select b from Booking b where b.visitor.visitorId=(Select visitorId from Visitor v where v.username=:username)")
	public List<Booking> findIdByUserName(@Param("username") String username);

	
}
