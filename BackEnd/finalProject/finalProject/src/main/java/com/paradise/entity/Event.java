package com.paradise.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_event")
public class Event {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int eventId;
@Column(nullable=false,unique=true)
private String eventName;

@Column(nullable=false)
private int eventCost;
@Column(nullable=false)
private String eventDate;

public int getEventId() {
	return eventId;
}
public void setEventId(int eventId) {
	this.eventId = eventId;
}
public String getEventName() {
	return eventName;
}
public void setEventName(String eventName) {
	this.eventName = eventName;
}
public int getEventCost() {
	return eventCost;
}
public void setEventCost(int eventCost) {
	this.eventCost = eventCost;
}
public String getEventDate() {
	return eventDate;
}
public void setEventDate(String eventDate) {
	this.eventDate = eventDate;
}
@Override
public String toString() {
	return "Event [eventCost=" + eventCost + ", eventName=" + eventName + ", eventDate=" + eventDate + "]";
}



}
