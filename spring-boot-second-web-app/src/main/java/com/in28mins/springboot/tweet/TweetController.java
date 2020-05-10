package com.in28mins.springboot.tweet;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28mins.springboot.user.User;
import com.in28mins.springboot.user.UserService;

@RestController
public class TweetController {
	
	@Autowired
	public UserService service;
	
	//Post a tweet from a user
	
	@PostMapping("/users/{id}/tweet")
	public Tweet postTweet(@RequestBody Tweet tweet) {
		service.postTweet(tweet,tweet.getUserid());
		return tweet;
	}
	
	//Retrieve all tweets of a user - 
	//Display only the tweets not user ID. In tweets, not timestamp
	
	@GetMapping("/users/{id}/tweets")
	public List<Tweet> retrieveAllUserTweets(@PathVariable int id){
		return service.retrieveUserTweets(id);
	}
	
	//Follow another user
	@GetMapping("/users/{userid}/follow/{id}")
	public List<Integer> follow(@PathVariable int userid, @PathVariable int id) {
		service.addFollowing(userid, id);
		return service.getFollowing(userid);
	}
	
	//Retrive all following Users 	//GET/users/{id}/following
	
	@GetMapping("/users/{id}/following")
	public List<Integer> following(@PathVariable int id){
		return service.getFollowing(id);
	}
		
	//Retrieve all following Users' Tweets in chronological order
	@GetMapping("/users/{id}/wall")
	public List<Tweet> wall(@PathVariable int id){
		return service.getWall(id);
	}
	
	

}
