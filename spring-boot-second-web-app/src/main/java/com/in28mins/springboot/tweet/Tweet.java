package com.in28mins.springboot.tweet;

import java.sql.Timestamp;

public class Tweet {
	
	private int userid;

	private String content;
	
	private Timestamp timestamp; 

	public Tweet(int userid, String content, Timestamp timestamp) {
		super();
		this.userid = userid;
		this.content = content;
		this.timestamp = timestamp;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Tweet [userid=" + userid + ", content=" + content + "]";
	}

}
