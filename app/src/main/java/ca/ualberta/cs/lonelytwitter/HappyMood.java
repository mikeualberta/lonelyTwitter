package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by simion on 1/19/17.
 */

public class HappyMood extends Mood {

    public HappyMood() {
        super();
    }

    public HappyMood(Date date) {
        super(date);
    }

    @Override
    public String whatMood() {
        return ":)";
    }
}
