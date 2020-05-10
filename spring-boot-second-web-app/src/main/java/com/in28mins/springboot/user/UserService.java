package com.in28mins.springboot.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;
import com.in28mins.springboot.tweet.Tweet;

@Component
public class UserService {

	public static List<User> users = new ArrayList<>();

	public static int userCount = 2;

	static {
		ArrayList<Tweet> Tweets = new ArrayList<>();
		Tweets.add(new Tweet(1, "Tweet 1 trial", new Timestamp(System.currentTimeMillis())));
		Tweets.add(new Tweet(1, "Tweet 2 trial", new Timestamp(System.currentTimeMillis())));
		users.add(new User(1, Tweets));
		users.add(new User(2));
	}

	//Create a new user
	public User createUser() {
		User user = new User();
		user.setId(++userCount);
		users.add(user);
		return user;
	}

	//Return all users
	public List<User> getUsers() {
		return users;
	}

	//Return a particular user with ID
	public User getUser(int id) {
		for(User user: users) {
			if(user.getId() == id)
				return user;
		}
		return null;
	}

	//Retrieve all tweets of a user
	//Display only the tweets not user
	public List<Tweet> retrieveUserTweets(int id){

		User user = getUser(id);
		if(user!=null) {
			if(user.getTweets() != null)
				return user.getTweets();
		}

		return null;
	}

	//Create a new tweet for a user
	public Tweet postTweet(Tweet tweet, int id) {

		tweet.setTimestamp(new Timestamp(System.currentTimeMillis()));
		tweet.setUserid(id);

		User user = getUser(id);

		if(user != null) {
			if(user.getTweets()!= null) 
				user.getTweets().add(tweet);

			else {
				List<Tweet> Tweets = new ArrayList<>();
				Tweets.add(tweet);
				user.setTweets(Tweets);
			}
		}

		return tweet;
	}

	public void addFollowing(int userid, int id) {

		User user = getUser(userid);

		if(user != null) {
			if(user.getFollowing()!= null) 
				user.getFollowing().add(id);

			else {
				List<Integer> Following = new ArrayList<>();
				Following.add(id);
				user.setFollowing(Following);;
			}
		}
	}

	public List<Integer> getFollowing(int id) {
		User user = getUser(id);
		if(user!=null) {
			if(user.getFollowing() != null)
				return user.getFollowing();
		}
		return null;
	}

	public List<Tweet> getWall(int id) {
		//Make a list of tweets
		//get user -> get following IDs -> Traverse IDs -> Get each user -> Get each user Tweets -> Store in treeSet -> override comparator
		User user = getUser(id);

		List<Integer> Following = user.getFollowing();
		List<Tweet> listTweet = new ArrayList<Tweet>();

		for(Integer followingId : Following) {
			List<Tweet> Tweets = retrieveUserTweets(followingId);
			if(Tweets!=null) {
				listTweet.addAll(Tweets);				
			}
		}
		Collections.sort(listTweet, new Comparator<Tweet>() {
			public int compare(Tweet o1, Tweet o2) {
				return o1.getTimestamp().compareTo(o2.getTimestamp());
			}
		});
		return listTweet;
	}



}