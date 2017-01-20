package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by simion on 1/19/17.
 */

public class SadMood extends Mood {

    public SadMood() {
        super();
    }

    public SadMood(Date date) {
        super(date);
    }

    @Override
    public String whatMood() {
        return ":(";
    }

}
