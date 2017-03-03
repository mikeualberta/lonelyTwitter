package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by simion on 2/16/17.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2{
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        // Need to start with the word test unless it's some sort of setup method
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet("some tweet");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));

        try{
            tweets.add(tweet);
            assertTrue(false);
        } catch (IllegalArgumentException e){
            assertTrue(true);
        }
//        assertEquals(tweets.add(tweet));
    }

    public void testHasTweet(){
        // TDD: Test > Fail > Code > Pass (LOOP)
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet("some tweet");
        // first checking that list doesn't have tweet before its addition
        assertFalse(tweets.hasTweet(tweet));
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet("some tweet");

        tweets.add(tweet);
        NormalTweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
        assertEquals(returnedTweet.getDate(), tweet.getDate());
    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet("some tweet");

        tweets.add(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }


    public void testGetCount(){
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet("some tweet");
        assertEquals(tweets.getCount(), 0);
        tweets.getCount();
        tweets.add(tweet);
        assertEquals(tweets.getCount(), 1);

    }

    public void testGetTweets(){
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet("1");
        NormalTweet tweet2 = new NormalTweet("2");
        NormalTweet tweet3 = new NormalTweet("3");

        tweets.add(tweet);
        tweets.add(tweet2);
        tweets.add(tweet3);

        ArrayList<NormalTweet> ordered = tweets.getTweets();

        assertEquals(ordered.get(0), tweet);
        assertEquals(ordered.get(1), tweet2);
        assertEquals(ordered.get(2), tweet3);

        assertFalse(ordered.get(0) == tweet3);
        assertFalse(ordered.get(0) == tweet2);
        assertFalse(ordered.get(1) == tweet3);
        assertFalse(ordered.get(1) == tweet);



    }


}