
package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by simion on 2/16/17.
 */

public class TweetList {
    private ArrayList<NormalTweet> tweets = new ArrayList<NormalTweet>();

    public void add(NormalTweet tweet){
        if(this.hasTweet(tweet)){
            throw new IllegalArgumentException();
        }
        else{
            tweets.add(tweet);
        }

    }

    public boolean hasTweet(NormalTweet tweet){
        return tweets.contains(tweet);
    }

    public NormalTweet getTweet(int index){
        return tweets.get(0);
    }

    public void delete(NormalTweet tweet){
        tweets.remove(tweet);
    }

    public int getCount(){
        return tweets.size();
    }

    public ArrayList<NormalTweet> getTweets(){
        return tweets;
    }
}