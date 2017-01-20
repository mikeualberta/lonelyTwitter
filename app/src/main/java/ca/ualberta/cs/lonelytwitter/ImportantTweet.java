package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by simion on 1/19/17.
 */

public class ImportantTweet extends Tweet {
    /* Inside block right click; generate; constructor; select both; creates two code segments below */
    public ImportantTweet(String message) {
        super(message);
    }

    public ImportantTweet(Date date, String message) {
        super(date, message);
    }

    @Override
    public Boolean isImportant(){
        return true;
    }
}
