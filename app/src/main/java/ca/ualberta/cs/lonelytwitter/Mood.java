package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by simion on 1/19/17.
 */

/**
 * Private abstract class mood
 *
 * @author simion
 */

public abstract class Mood {

    private Date date;

    public Mood(){
        this.date = new Date();
    }

    public Mood(Date date){
        this.date = date;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * abstract method whatMood()
     * @return string emoticon associated with appropriate mood
     */

    public abstract String whatMood();
}
