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
@Table(name="tbl_booking")
public class Booking {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int bookingId;


@Column(nullable=false)
private int bookingPrice;


@Column(nullable=false)
private String bookingDate;

//@JsonBackReference
@ManyToOne
@JoinColumn(name = "visitorId")
private Visitor visitor;

//@OneToOne
//@JoinColumn(name = "eventId")
@Column(nullable=false)
private String eventName;


public int getBookingId() {
	return bookingId;
}

public void setBookingId(int bookingId) {
	this.bookingId = bookingId;
}

public int getBookingPrice() {
	return bookingPrice;
}

public void setBookingPrice(int bookingPrice) {
	this.bookingPrice = bookingPrice;
}

public String getBookingDate() {
	return bookingDate;
}

public void setBookingDate(String bookingDate) {
	this.bookingDate = bookingDate;
}

public Visitor getVisitor() {
	return visitor;
}

public void setVisitor(Visitor visitor) {
	this.visitor = visitor;
}

public String getEventName() {
	return eventName;
}

public void setEventName(String eventName) {
	this.eventName = eventName;
}

@Override
public String toString() {
	return "Booking [bookingId=" + bookingId + ", bookingPrice=" + bookingPrice + ", bookingDate=" + bookingDate
			 + ", eventName=" + eventName + "]";
}


}