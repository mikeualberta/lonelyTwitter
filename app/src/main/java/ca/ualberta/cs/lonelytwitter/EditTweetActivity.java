package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import static ca.ualberta.cs.lonelytwitter.R.id.activity_edit_tweet;
import static ca.ualberta.cs.lonelytwitter.R.id.textView;

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        TextView textview = (TextView) findViewById(R.id.textView);

        String tweetString = getIntent().getExtras().getString("MyTweet");
        textview.setText(tweetString);

    }
}
