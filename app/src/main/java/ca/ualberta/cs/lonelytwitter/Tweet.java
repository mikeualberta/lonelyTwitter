package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

import static android.R.id.message;

/**
 * Created by simion on 1/19/17.
 */

public abstract class Tweet implements Tweetable{
    /* By adding abstract we are saying that a tweet has to be a normal tweet or an important Tweet*/
    private Date date;
    private String message;
    private ArrayList<Mood> moodList;

    public Tweet(String message){
        /* This is a  constructor without any return type */
        this.message = message;
        this.date = new Date(); /* new is how you create a new instance in java */
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140){
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public abstract Boolean isImportant();


}
