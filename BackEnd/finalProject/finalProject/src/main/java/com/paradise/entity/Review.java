package com.paradise.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="tbl_review")
public class Review {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int reviewId;

@Column(nullable=false)
private String description;

//@JsonBackReference
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "visitorId")
private Visitor visitor;

//bookingMapping
//@OneToOne(fetch = FetchType.EAGER)
//@JoinColumn(name = "visitorId")
//private Booking booking;


public int getReviewId() {
	return reviewId;
}

public void setReviewId(int reviewId) {
	this.reviewId = reviewId;
}

public Visitor getVisitor() {
	return visitor;
}

public void setVisitor(Visitor visitor) {
	this.visitor = visitor;
}

//public Place getPlace() {
//	return place;
//}
//
//public void setPlace(Place place) {
//	this.place = place;
//}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

@Override
public String toString() {
	return "Review [reviewId=" + reviewId + ", description=" + description + "]";
}

}
