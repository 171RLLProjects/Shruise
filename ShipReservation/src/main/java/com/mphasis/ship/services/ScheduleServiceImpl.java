package com.mphasis.ship.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.ship.daos.ScheduleDao;
import com.mphasis.ship.entities.Schedule;
import com.mphasis.ship.exceptions.BusinessException;
@Service
public class ScheduleServiceImpl implements ScheduleService {
@Autowired
ScheduleDao scheduleDao;
	public void addSchedule(Schedule schedule) throws BusinessException {
		scheduleDao.addSchedule(schedule);

	}

	public void updateSchedule(Schedule schedule) throws BusinessException {
		scheduleDao.updateSchedule(schedule);
	}

	public void deleteSchedule(String sid) throws BusinessException {
		scheduleDao.deleteSchedule(sid);

	}

	public Schedule getScheduleById(String sid) throws BusinessException {
		
		return scheduleDao.getScheduleById(sid);
	}

	public Set<Schedule> getSchedules() throws BusinessException {
		
		return scheduleDao.getSchedules();
	}

}
