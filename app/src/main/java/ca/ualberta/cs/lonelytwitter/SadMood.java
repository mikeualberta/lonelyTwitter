package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by simion on 1/19/17.
 */

/**
 * Sadmood class that extends mood class.
 * @author simion
 */

public class SadMood extends Mood {

    public SadMood() {
        super();
    }

    public SadMood(Date date) {
        super(date);
    }

    /**
     * whatMood method
     * @return frowning string emoticon
     */
    @Override
    public String whatMood() {
        return ":(";
    }

}
