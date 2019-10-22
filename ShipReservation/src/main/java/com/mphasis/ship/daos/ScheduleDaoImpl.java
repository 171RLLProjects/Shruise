package com.mphasis.ship.daos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.ship.entities.Schedule;
import com.mphasis.ship.entities.Ship;
import com.mphasis.ship.exceptions.BusinessException;
@Repository
public class ScheduleDaoImpl implements ScheduleDao {
@Autowired
SessionFactory	sessionFactory;

	public void addSchedule(Schedule schedule) {
		Session session=sessionFactory.openSession();
	    session.beginTransaction();
	    session.save(schedule);
	    session.getTransaction().commit();
	}

	public void updateSchedule(Schedule schedule)  {
		Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(schedule);
        session.getTransaction().commit();
        session.close();

	}

	public void deleteSchedule(String sid)  {
		Session session=sessionFactory.openSession();
        session.beginTransaction();
        Schedule schedule=(Schedule)session.get(Schedule.class, sid);
        session.delete(schedule);
        session.getTransaction().commit();

	}

	public Schedule getScheduleById(String sid)  {
		Session session=sessionFactory.openSession();
		Schedule schedule=(Schedule)session.get(Schedule.class, sid);
        return schedule;
	}

	public Set<Schedule> getSchedules() {
		
	        Session session=sessionFactory.openSession();
	        TypedQuery<Schedule> query = session.createQuery("from Schedule", Schedule.class);
	        List<Schedule> schedules=query.getResultList();
	        Set<Schedule> scheduleSet=new HashSet<>();
	        scheduleSet.addAll(schedules);
	       
	        return scheduleSet;
	    }
	}


