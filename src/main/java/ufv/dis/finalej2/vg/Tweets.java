package ufv.dis.finalej2.vg;

import java.util.ArrayList;
import java.util.List;

public class Tweets {

	private List<Tweet> tweets;
	
	public Tweets() {
		this.tweets = new ArrayList<>();
	}
	
	public int 	Cont_Tweets() {
		return tweets.size();
	}
	
	public boolean Add_Tweet(Tweet mensaje) {
		tweets.add(mensaje);
		return true;
	}
	
	public List<Tweet> Lista_Tweet(){
		return tweets;
	}
	
}
