package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by simion on 1/19/17.
 */

/**
 * This class is the ImportantTweet class of the application. It extends the Tweet class.
 */

public class ImportantTweet extends Tweet {
    /* Inside block right click; generate; constructor; select both; creates two code segments below */
    public ImportantTweet(String message) {
        super(message);
    }

    public ImportantTweet(Date date, String message) {
        super(date, message);
    }

    /**
     * isImportant boolean function
     * @return true boolean value
     */
    @Override
    public Boolean isImportant(){
        return true;
    }
}
