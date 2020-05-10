package com.in28mins.springboot.user;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.in28mins.springboot.tweet.Tweet;

public class User {
	
	@JsonIgnore
	private int id;
	
	private List<Tweet> Tweets;
	
	private List<Integer> Following;
	
	public User() {
		
	}
	
	public User(int id) {
		super();
		this.id = id;
	}
	
	public User(int id, List<Tweet> tweets) {
		super();
		this.id = id;
		Tweets = tweets;
	}

	public List<Tweet> getTweets() {
		return Tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		Tweets = tweets;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Integer> getFollowing() {
		return Following;
	}

	public void setFollowing(List<Integer> following) {
		Following = following;
	}

	
	@Override
	public String toString() {
		return "User [id=" + id + ", Tweets=" + Tweets + "]";
	}
	
	/*
	 * @Override public String toString() { return "User [id=" + id + "]"; }
	 */
	
	

}
