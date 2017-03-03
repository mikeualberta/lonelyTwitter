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
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

public class LonelyTwitterActivity extends Activity {

	private LonelyTwitterActivity activity = this; // reference back to lonelyTwitterActivity class

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;


	public ListView getOldTweetsList(){
		return oldTweetsList;
	}


	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		oldTweetsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				Intent intent = new Intent(activity, EditTweetActivity.class);
				Tweet editTweet = (Tweet) oldTweetsList.getAdapter().getItem(i);
				intent.putExtra("MyTweet", editTweet.getMessage());
				startActivity(intent);
			}
		});

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();


				Tweet tweet = new NormalTweet(text);

//				tweetList = new ArrayList<Tweet>();
				tweetList.add(tweet);

				adapter.notifyDataSetChanged();

				saveInFile();

			}
		});


		Button clearButton = (Button) findViewById(R.id.clear);


		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
//				String text = bodyText.getText().toString();
				tweetList.clear();

				deleteFile("file.sav");
				adapter.notifyDataSetChanged();

//				Method I used before. deleteFile thing is what was used in the lab
//				adapter.notifyDataSetChanged();
//
//				saveInFile();

			}
		});


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