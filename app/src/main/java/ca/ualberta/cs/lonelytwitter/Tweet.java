package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

import static android.R.id.message;

/**
 * Created by simion on 1/19/17.
 */

/**
 * Public abstract class Tweet that implements Tweetable
 * @version 1.4.2
 * @since 1.0
 */

public abstract class Tweet implements Tweetable{
    /* By adding abstract we are saying that a tweet has to be a normal tweet or an important Tweet*/
    private Date date;
    private String message;
    private ArrayList<Mood> moodList;

    /**
     * Constructor for tweet object. Single argument
     * @param message
     */
    public Tweet(String message){
        /* This is a  constructor without any return type */
        this.message = message;
        this.date = new Date(); /* new is how you create a new instance in java */
    }

    /**
     * Constructor for tweet object. Two arguments
     * @param date
     * @param message
     */
    public Tweet(Date date, String message){
        /* Constructor with 2 arguments. Also a call of super() is implied in a constructor*/
        this.message = message;
        this.date = date;
    }

    /*  This is the default constructor. Not necessary.
    public Tweet(){
        super();
        this.date = new Date();
    }*/

    /**
     * date getter
     * @return date
     */

    public Date getDate() {
        return date;
    }

    /**
     * setter. sets date
     * @param date
     */

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * getter. Gets message
     * @return
     */

    public String getMessage() {
        return message;
    }

    /**
     * setMessage method
     * @param message
     * @throws TweetTooLongException if tweet is longer than 140 characters
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140){
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * isImportant abstract method. Determines if tweet isImportant.
     * @return
     */

    public abstract Boolean isImportant();

    /**
     * toString method that connects current to date to message
     * @return date + tweet message
     */
    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }


}
