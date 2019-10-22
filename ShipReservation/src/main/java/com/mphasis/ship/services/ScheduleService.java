package com.mphasis.ship.services;

import java.util.Set;

import com.mphasis.ship.entities.Schedule;
import com.mphasis.ship.exceptions.BusinessException;

public interface ScheduleService {

	public void addSchedule(Schedule schedule)throws BusinessException;
    public void updateSchedule(Schedule schedule)throws BusinessException;
    public void deleteSchedule(String sid)throws BusinessException;
    public Schedule getScheduleById(String sid)throws BusinessException;
    public Set<Schedule> getSchedules()throws BusinessException;
}
