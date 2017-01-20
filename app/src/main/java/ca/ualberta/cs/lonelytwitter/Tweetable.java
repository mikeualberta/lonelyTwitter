package ca.ualberta.cs.lonelytwitter;

/**
 * Created by simion on 1/19/17.
 */

public interface Tweetable {
    /* Everything in the interface must be public, thus typing public ahead of the next line would be redundant */
    public String getMessage();
    public void setMessage(String string) throws TweetTooLongException;


}
