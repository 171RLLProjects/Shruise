package com.mphasis.ship.services;

import java.util.HashMap;
import java.util.List;

import com.mphasis.ship.entities.UserProfile;
import com.mphasis.ship.exceptions.BusinessException;

public interface UserProfileService {
	public UserProfile login(String username,String pass) throws BusinessException;
	public UserProfile getUserById(String userId) throws BusinessException;
	public void register(UserProfile userProfile) throws BusinessException;
	public List<UserProfile> getAll() throws BusinessException;


	public void deleteUser(String UserId);



}

