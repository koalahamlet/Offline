package mikecanco.de.offline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.otto.Subscribe;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class OfflineActivity extends ActionBarActivity {

	@InjectView(R.id.button)
	Button mybutton;

	@InjectView(R.id.text)
	TextView textView;

	@InjectView(R.id.login_button)
	TwitterLoginButton loginButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_offline);
		ButterKnife.inject(this);

		loginButton.setCallback(new Callback<TwitterSession>() {
			@Override
			public void success(Result<TwitterSession> result) {
				// Do something with result, which provides a
				// TwitterSession for making API calls
			}

			@Override
			public void failure(TwitterException exception) {
				// Do something on failure
			}
		});

		TwitterCore.getInstance().getApiClient();

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		// Pass the activity result to the login button.
		loginButton.onActivityResult(requestCode, resultCode,
				data);
	}

	@Override
	protected void onResume() {
		super.onResume();
		OfflineApplication.setUserInApp(true);
		OfflineApplication.getBus().register(this);
		if (Globals.isOffline()){
			offlineUI();
		}else {
			Globals.setOffline(false);
			onlineUI();
		}
	}



	public void onlineUI(){
		textView.setText(getResources().getString(R.string.text_online));
		mybutton.setText(getResources().getString(R.string.button_online));
	}

	public void offlineUI(){
		textView.setText(getResources().getString(R.string.text_offline));
		mybutton.setText(getResources().getString(R.string.button_offline));
	}

	@Override
	protected void onPause() {
		super.onPause();
		OfflineApplication.setUserInApp(false);
	}

	@OnClick(R.id.button)
	public void clickButton(View view){

	if (Globals.isOffline()){
		Globals.setOffline(false);
		onlineUI();
	}

//
//		AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
//
//		// 2. Chain together various setter methods to set the dialog characteristics
//		builder.setMessage(R.string.dialog_message)
//				.setTitle(R.string.dialog_title);
//
//		builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
//			public void onClick(DialogInterface dialog, int id) {
//				// User clicked OK button
//			}
//		});
//
//		builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
//			public void onClick(DialogInterface dialog, int id) {
//				// User cancelled the dialog
//			}
//		});
//
//		// 3. Get the AlertDialog from create()
//		AlertDialog dialog = builder.create();
//
//		dialog.show();

	}

	@Subscribe
	public void answerAvailable(AlarmOfflineEvent event) {
		// TODO: React to the event somehow!

		Toast.makeText(this, "Youre in the app, totes online", Toast.LENGTH_LONG).show();
	}

}
