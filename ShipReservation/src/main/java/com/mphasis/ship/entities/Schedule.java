package com.mphasis.ship.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.ship.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Schedule {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sch_seq")
	@GenericGenerator(name = "sch_seq", 
	        strategy = "com.mphasis.ship.util.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	        		@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "5"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "SC_"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	private String scheduleId;
	private Date startDate;
	private Date endDate;
	@OneToOne(mappedBy="schedule")
	private Ship ship;
	public String getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Ship getShip() {
		return ship;
	}
	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
}
