package com.paradise.repository;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paradise.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{

	//public List<Review> findReviewByPlace(Place place);

	//public List<Review> findReviewByVisitor(Visitor visitor);

	@Transactional
	@Modifying
	@Query("Delete from Review r where r.reviewId=:id")
	public void deleteReview(@Param("id") Integer id);
//	
//	@Transactional
//	@Query("Select r from Visitor v,Review r where r.visitor.visitorId=(Select visitorId from Visitor v where v.username=:username)")
//	public List<Review> findIdByUserName(@Param("username") String username);


	@Transactional
	@Query("Select r from Review r where r.visitor.visitorId=:visitorId")
	public List<Review> findIdByUserId(@Param("visitorId") int visitorId);

	
	
	//@Transactional
	//@Modifying
	//@Query("Insert into Review (reviewId,description) values(?,?))").setParameter(1,)
	//@Query(value = "insert into Review (reviewId,description) VALUES (:reviewId,:description)", nativeQuery = true)
	//public void saveReview(@Param("id") Integer id,@Param("description")String description);

}
