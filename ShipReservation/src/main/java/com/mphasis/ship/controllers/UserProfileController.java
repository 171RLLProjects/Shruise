package com.mphasis.ship.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mphasis.ship.entities.UserProfile;
import com.mphasis.ship.exceptions.BusinessException;
import com.mphasis.ship.services.UserProfileService;

@RestController
public class UserProfileController {
	@Autowired
	UserProfileService userProfileService;

	
	@RequestMapping(value="/login/{userName}/{pass}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public String login(@PathVariable("userName")String userName,@PathVariable("pass")String pass) {
		UserProfile userProfile=null;
		try {
			userProfile=userProfileService.login(userName,pass);
		}catch (BusinessException e) {
			e.printStackTrace();
		}
		return userProfile.getRole();
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserProfile>> getUser(){
		List<UserProfile> users=null;
		try {
			users=userProfileService.getAll();
		} catch (Exception e) {
			try {
				throw new BusinessException("no users found");
			} catch (BusinessException e1) {
				e1.getMessage();
			}
			return new ResponseEntity<List<UserProfile>>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok().body(users);
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addUser(@RequestBody UserProfile userProfile){
		try {
			userProfileService.register(userProfile);
		}
		catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value="/users/{userId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserProfile> getById(@PathVariable("userId") String userId) {
		UserProfile userProfile= null;
		try {
			userProfile = userProfileService.getUserById(userId);
		} catch (Exception e) {
			return new ResponseEntity<UserProfile>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.accepted().body(userProfile);
	}



	@RequestMapping(value="/users/{userId}",method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteProduct(@PathVariable("userId")String userId){
		try{
			userProfileService.deleteUser(userId);
		}catch(Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}


	@RequestMapping("/logout")  
	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response) {  
		request.getSession().invalidate();
		System.out.println("Logged out...");
		return new ModelAndView("homepage");  
	}


}

/*
@RequestMapping(value="/register",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Map<String, String>> addUser( @RequestBody UserProfile userProfile){
	Map<String,String> response= new HashMap<>();
	try {
		userProfileService.register(userProfile);
		response.put("ok","success");
		return ResponseEntity.accepted().body(response);
	}catch (BusinessException e) {
		response.put("error",e.getMessage());
		return ResponseEntity.badRequest().body(response); 
	}

}
 */


