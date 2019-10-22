package com.mphasis.ship.daos;

import java.util.List;

import com.mphasis.ship.entities.UserProfile;
import com.mphasis.ship.exceptions.BusinessException;

public interface UserProfileDao {
	public UserProfile login(String username,String pass);
	public void register(UserProfile userProfile);
	public UserProfile getUserById(String userId) ;
	public void deleteUser(String UserId);
	public List<UserProfile> getAll();

}
