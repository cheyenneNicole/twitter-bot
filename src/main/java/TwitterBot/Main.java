package TwitterBot;

import twitter4j.*;
import twitter4j.auth.AccessToken;


public class Main {

    public static void main(String[] args){

        Twitter twitter = new TwitterFactory().getInstance();
        // Twitter Consumer key & Consumer Secret
        twitter.setOAuthConsumer(Config.CONSUMER_KEY, Config.CONSUMER_SECRET);
        // Twitter Access token & Access token Secret
        twitter.setOAuthAccessToken(new AccessToken(Config.ACCESS_TOKEN, Config.ACCESS_TOKEN_SECRET));
        try {
            // Getting Twitter Timeline using Twitter4j API
            ResponseList statusReponseList = twitter.getUserTimeline(new Paging(1, 5));
            for (int x = 0; x < statusReponseList.size(); x++) {
                System.out.println(statusReponseList.get(x).toString());
            }
            // Post a Tweet using Twitter4j API
            Status status = twitter.updateStatus("Hello world!");
            System.out.println("Successfully updated the status to [" + status.getText() + "].");
        } catch (Exception e) {
        }
    }
}



