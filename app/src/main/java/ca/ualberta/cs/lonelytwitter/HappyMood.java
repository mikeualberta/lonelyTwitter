package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by simion on 1/19/17.
 */

/**
 * This class is the HappyMood class of the application. It extends the mood class.
 */

public class HappyMood extends Mood {


    public HappyMood() {
        super();
    }

    public HappyMood(Date date) {
        super(date);
    }

    /**
     * This is the whatMood method
     * @return a smiley emoticon string
     */

    @Override
    public String whatMood() {
        return ":)";
    }
}
