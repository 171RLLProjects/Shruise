package com.mphasis.ship.daos;

import java.util.Set;

import com.mphasis.ship.entities.Schedule;
import com.mphasis.ship.exceptions.BusinessException;

public interface ScheduleDao {
	 public void addSchedule(Schedule schedule);
	    public void updateSchedule(Schedule schedule);
	    public void deleteSchedule(String sid);
	    public Schedule getScheduleById(String sid);
	    public Set<Schedule> getSchedules();

}
