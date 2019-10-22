package com.mphasis.ship.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.mphasis.ship.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Route {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "rou_seq")
	@GenericGenerator(name = "rou_seq", 
	        strategy = "com.mphasis.ship.util.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	        		@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "2"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ROU_"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	private String routeId;
	
	@ManyToOne
	@JoinColumn(name="slid")
	private Location source;
	
	@ManyToOne
	@JoinColumn(name="dlid")
	private Location destination;
	
	@Column(length=20,nullable=false)
	private long distance;
	@Column(length=20,nullable=false)
	private String duration;
	@Column(length=20,nullable=false)
	private double costPerkm;

	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	public Location getSource() {
		return source;
	}
	public void setSource(Location source) {
		this.source = source;
	}
	public Location getDestination() {
		return destination;
	}
	public void setDestination(Location destination) {
		this.destination = destination;
	}
	public long getDistance() {
		return distance;
	}
	public void setDistance(long distance) {
		this.distance = distance;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public double getCostPerkm() {
		return costPerkm;
	}
	public void setCostPerkm(double costPerkm) {
		this.costPerkm = costPerkm;
	}
	
	
	
}
