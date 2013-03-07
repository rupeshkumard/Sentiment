package com;

import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.http.AccessToken;

public class JavaTwit1 {
	private final static String CONSUMER_KEY = "ovWPxdqUXGc2xaQaMQ0cVg";

	private final static String CONSUMER_KEY_SECRET =

	"Erkm5NEw6wMvc5Yg7jASUDvoV0QQgmNgeCJLjpqueo";

	public void start() throws TwitterException, IOException {

		Twitter twitter = new TwitterFactory().getInstance();

		twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

		// here's the difference

		String accessToken = getSavedAccessToken();

		String accessTokenSecret = getSavedAccessTokenSecret();

		AccessToken oathAccessToken = new AccessToken(accessToken,

		accessTokenSecret);

		twitter.setOAuthAccessToken(oathAccessToken);

		// end of difference

		twitter.updateStatus("Hi, im updating status again from my office for Demo");

		System.out.println("\nMy Timeline:");

		// I'm reading your timeline

		ResponseList<Status> list = twitter.getHomeTimeline();

		for (Status each : list) {

			System.out.println("Sent by: @" + each.getUser().getScreenName()

			+ " - " + each.getUser().getName() + "\n" + each.getText()

			+ "\n");

		}

	}

	private String getSavedAccessTokenSecret() {

		// consider this is method to get your previously saved Access Token

		// Secret

		return "PTww0AbuoF6C3nACU8yaPG7oSsZilm98Zi5fxcpos";

	}

	private String getSavedAccessToken() {

		// consider this is method to get your previously saved Access Token

		return "388824237-Xa6TCVhVGp6O5MEcmrDANXHRqTJr0bIoQWEceMqB";

	}

	public static void main(String[] args) throws Exception {

		new JavaTwit1().start();

	}

}
