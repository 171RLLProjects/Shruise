package com.mphasis.ship.services;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mphasis.ship.daos.UserProfileDao;
import com.mphasis.ship.entities.UserProfile;
import com.mphasis.ship.exceptions.BusinessException;
@Service
public class UserProfileServiceImpl implements UserProfileService{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	UserProfileDao userProfileDao;


	public UserProfile login(String userName, String pass) throws BusinessException
	{
		UserProfile userProfile= userProfileDao.login(userName, pass);
		if(userProfile==null) {
			throw new BusinessException("invalid Credentials");
		}

		return userProfile ;
	}
	public void register(UserProfile userProfile) throws BusinessException 
	{
		if(userProfile.getUserName().matches("[A-Z a-z]{3,20}"))
		{
				if((userProfile.getPass().length()>1)&&(userProfile.getPass().length()<20)) 

				{
		userProfileDao.register(userProfile);

			}
				else

				{
			throw new BusinessException("Name is invalid");
				}
		}
		else 
		{
			throw new BusinessException("Pass is invalid");
		}
	}

	public UserProfile getUserById(String userId) throws BusinessException {
		if(userId==null) {
			throw new BusinessException("the userId should not be empty");
		}
		return userProfileDao.getUserById(userId);
	}
	@Override
	public void deleteUser(String UserId) {

		userProfileDao.deleteUser(UserId);
	}
	@Override
	public List<UserProfile> getAll() throws BusinessException {

		return userProfileDao.getAll();
	}
}


/*
	public String deleteUser(String UserId) {
		userProfileDao.deleteUser(UserId);
	}
 */
/*	public void checkLogin(String UserId, String password) {
UserProfile userProfile=userProfileDao.getUserById(UserId);
if (userProfile!=null) {
	String  userPass=userProfile.getPass();
	if(userPass.equals(password)) {

	}
	}

}*/

/*public List<HashMap<String, String>> getHistory(String UserId) {
return null;
HashMap<String, String> hash = new HashMap<String, String>();
List<HashMap<String, String>> userAllHistory = new ArrayList<HashMap<String, String>>();
List<Reservation> allBooking = bookingImplementation.getBookedDetails(personId);

for (Booking booking : allBooking) {

	List<Passenger> passengers = new ArrayList<Passenger>();
	FlightMaster flightMaster = booking.getFlightMaster();
	LocationMaster source = flightMaster.getLocationMaster1();
	LocationMaster destination = flightMaster.getLocationMaster2();
	hash.put("Booking Number", booking.getBookingNumber());
	hash.put("Source", source.getCode());
	hash.put("Source Name", source.getAirportName());
	hash.put("Destination", destination.getCode());
	hash.put("Destiantion Name", destination.getAirportName());
	hash.put("Date", String.valueOf(flightMaster.getFlightTravelDate()));
	hash.put("Departure Time", flightMaster.getDepartureTime()
			.toString());
	hash.put("Arrival Time", flightMaster.getArrivalTime().toString());
	hash.put("Total Cost", String.valueOf(booking.getTotalCost()));
	hash.put("Seat ", String.valueOf(booking.getSeatsBooked()));
	hash.put("Class ", booking.getSeatClass());
	for (Passenger passenger : passengers) {
		hash.put("Passenger Detail", passenger.getFirstName() + " "
				+ passenger.getLastName() + " " + passenger.getAge()
				+ " " + passenger.getGender() + "");
	}
	userAllHistory.add(hash);
}
return userAllHistory;
}
 */

