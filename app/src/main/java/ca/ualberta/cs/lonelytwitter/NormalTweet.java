package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by simion on 1/19/17.
 */

/**
 * NormalTweet class that extends Tweet
 * @author simion
 * @version  1.4.2
 * @since 1.0
 */

public class NormalTweet extends Tweet {

    public NormalTweet(String message) {
        super(message);
    }

    public NormalTweet(Date date, String message) {
        super(date, message);
    }

    /**
     * isImportant method. Indicates that tweet isn't important
     * @return false boolean
     */
    @Override
    public Boolean isImportant(){
        return false;
    }

}
