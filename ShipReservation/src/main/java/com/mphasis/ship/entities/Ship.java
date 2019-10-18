package com.mphasis.ship.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.ship.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Ship {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sh_seq")
	@GenericGenerator(name = "sh_seq", 
	        strategy = "com.mphasis.ship.util.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	        		@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "10"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "SH"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d") })
	private String shipId;
	@Column(length=20,nullable=false)
	private String shipName;
	@OneToOne
	@JoinColumn(name="routeId")
	private Route route;
	@OneToOne
	@JoinColumn(name="scheduleId")
	private Schedule schedule;
	private static final int seatingCapacity=30;
	private int reserveCapacity;
	private int wListCapacity;
	public String getShipId() {
		return shipId;
	}
	public void setShipId(String shipId) {
		this.shipId = shipId;
	}
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public int getReserveCapacity() {
		return reserveCapacity;
	}
	public void setReserveCapacity(int reserveCapacity) {
		this.reserveCapacity = reserveCapacity;
	}
	public int getwListCapacity() {
		return wListCapacity;
	}
	public void setwListCapacity(int wListCapacity) {
		this.wListCapacity = wListCapacity;
	}
	public static int getSeatingcapacity() {
		return seatingCapacity;
	}
	
	
}
