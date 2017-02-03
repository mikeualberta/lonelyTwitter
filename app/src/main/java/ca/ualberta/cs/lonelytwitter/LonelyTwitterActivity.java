package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This class is the main view class of the project. <br> In this class,
 * user interaction and file manipulation is performed .
 * All files are in the form of "json" files that are stored in Emulator's
 * accessible from Android Deice Monitor:
 * <pre>
 *     pre-formatted text: <br>
 *         File Explorer -> data -> data -> ca.ualberta.cs.lonelytwitter -> files -> file.sav.
 * </pre>
 * <code> begin <br>
 *     some pseduo code here <br>
 * end.</code>
 * The file name is indicated in the &nbsp &nbsp FILENAME constant.
 * <ul>
 *     <li>item 1</li>
 *     <li>item 2</li>
 *     <li>item 3</li>
 * </ul>
 * <ol>
 *     <li>item 1</li>
 *     <li>item 2</li>
 *     <li>item 3</li>
 * </ol>
 *
 * @author simion
 * @version 1.4.2
 * @since 1.0
 */
public class LonelyTwitterActivity extends Activity {
	/**
	 * The file that all the tweets aresaved there.
	 * The format of the file is JSON
	 * @see #loadFromFile()
	 * @see #saveInFile()
	 */

	private static final String FILENAME = "file.sav";
	private enum TweetListOrdering {DATE_ASCENDING, DATE_DESCENDING, TEXT_ASCENDING, TEXT_DESCENDING};
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;

	/**
	 * Called when the activity is first created
	 * @param savedInstanceState
     */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				text = trimExtraSpaces(text);


				Tweet tweet = new NormalTweet(text);

//				tweetList = new ArrayList<Tweet>();
				tweetList.add(tweet);

				adapter.notifyDataSetChanged();

				saveInFile();

			}
		});


		/* NEW STUFF*/
		Button clearButton = (Button) findViewById(R.id.clear);


		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
//				String text = bodyText.getText().toString();
				tweetList.clear();

//				Tweet tweet = new NormalTweet(text);
//
//				tweetList.add(tweet);

				adapter.notifyDataSetChanged();

				saveInFile();

			}
		});

		/* End of NEW STUFF */

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.
//		String[] tweets = loadFromFile();
		loadFromFile();
//		tweetList = new ArrayList<Tweet>();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
	}



	/**
	 *  Removes extra spaces in the given string
	 * @param inputString
	 * @return string without extra spaces
     */

	private String trimExtraSpaces(String inputString){
		inputString = inputString.replaceAll("\\s+"," ");
		return inputString;
	}

	private void sortTweetListItems(TweetListOrdering ordering){
	}
	/**
	 * Load tweets from file
	 * @throws TweetTooLongException if the tweet is too long
	 * @exception FileNotFoundException if the file is not created
	 */

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

			tweetList = gson.fromJson(in, new TypeToken<ArrayList<NormalTweet>>() {
			}.getType());

//			logs = gson.fromJson(br, new TypeToken<List<JsonLog>>(){}.getType());
			fis.close();

		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();

		} catch (IOException e) {
			throw new RuntimeException();
		}
//		return tweets.toArray(new String[tweets.size()]);
	}

	/**
	 * Save tweets in file in JSON format.
	 * @throws FileNotFoundException if folder doesn't exist
	 */

	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();

			gson.toJson(tweetList, out);

			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

}