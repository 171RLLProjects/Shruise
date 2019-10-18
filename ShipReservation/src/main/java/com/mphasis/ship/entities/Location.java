package com.mphasis.ship.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.ship.util.StringPrefixedSequenceIdGenerator;


@Entity
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "loc_seq")
	@GenericGenerator(name = "loc_seq", 
	        strategy = "com.mphasis.ship.util.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	        		@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "LOC"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	private String locId;
	@Column(length=20,nullable=false)
	private String locName;
	public String getLocId() {
		return locId;
	}
	public void setLocId(String locId) {
		this.locId = locId;
	}
	public String getLocName() {
		return locName;
	}
	public void setLocName(String locName) {
		this.locName = locName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locId == null) ? 0 : locId.hashCode());
		result = prime * result + ((locName == null) ? 0 : locName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (locId == null) {
			if (other.locId != null)
				return false;
		} else if (!locId.equals(other.locId))
			return false;
		if (locName == null) {
			if (other.locName != null)
				return false;
		} else if (!locName.equals(other.locName))
			return false;
		return true;
	}
	
}
