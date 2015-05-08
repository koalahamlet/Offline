package mikecanco.de.offline;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class OfflineActivity extends ActionBarActivity {

	@InjectView(R.id.button)
	Button mybutton;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_offline);
		ButterKnife.inject(this);


		//TODO: this chunk of code is how we would send

//	public static void setUploadLogsAlarm() {
//
//
//
//		PendingIntent uploadAlarmIntent;
//
//
//		Context context = App.getInstance();
//
//		alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//		Intent intent = new Intent(context, UploadAlarmReceiver.class);
//		uploadAlarmIntent = PendingIntent.getBroadcast(context, Constants.UPLOAD_ALARM_ID, intent, 0);
//
//		//for now, trigger in 5 seconds then every hour thereafter.
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTimeInMillis(System.currentTimeMillis());
//		calendar.add(Calendar.SECOND, 5);
//
//		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
//				calendar.getTimeInMillis(),
//				AppConfig.UPLOAD_INTERVAL,
//				uploadAlarmIntent);
//
//
//		Log.d(TAG, "alarm is set.");
//	}

		//TODO: this chunk of code was how we would send a broadcast to the system
//		public void onQuestionStackUpdatedEvent(QuestionStackUpdatedEvent event) {
//			if (mLayout != null) {
//				updateQuestionDrawerHeaderText(event.getQuestionStackSize());
//				if (event.getQuestionStackSize() == 0) {
//					//temporarily calling uploading questions here for demo purposes.
//					Intent intent = new Intent(App.getInstance().getApplicationContext(),
//							UploadAlarmReceiver.class);
//					App.getInstance().getApplicationContext().sendBroadcast(intent);
//
//					//mLayout.hidePanel();
//				}
//			}
//		}

		//TODO: this would then get intercepted by a receiver which would then execute the notification logic ,
		//it would then set another alarm, or possibly a handler which would execute the tweet.


		/**
		 * Note:Receivers need to be declared in the manifest
		 * also, this would architecture only works if you're using job scheduler from path.
		 */
//		public class UploadAlarmReceiver extends BroadcastReceiver {
//
//			private static final String TAG = UploadAlarmReceiver.class.getSimpleName();
//
//			@Override public void onReceive(Context context, Intent intent) {
//
//				Log.d(TAG, "upload logs.");
//
//				JobManager jobManager = App.getInstance().getJobManager();
//				jobManager.addJob(new UploadLogsJob(MetricLogger.getLatestFilename(), context));
//
//				jobManager.addJob(new UploadQuestionsJob(context));
//
//				MetricLogger.reset();
//
//			}
//		}


		//TODO:this chunk of code is how one would show the notification

//		mNotificationManager = (NotificationManager) App.getInstance()
//				.getApplicationContext()
//				.getSystemService(Context.NOTIFICATION_SERVICE);
//		//Notification id set to 1 for right now. we can come up with a better schema later.
//		int NOTIFICATION_ID = 1;
//		Intent notificationIntent = new Intent(App.getInstance(), MainActivity.class);
//		notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//		notificationIntent.setAction(Intent.ACTION_MAIN);
//		notificationIntent.addCategory(Intent.CATEGORY_LAUNCHER);
//		PendingIntent contentPendingIntent = PendingIntent.getActivity(App.getInstance(), NOTIFICATION_ID, notificationIntent,
//				PendingIntent.FLAG_ONE_SHOT);
//
//
//		Bitmap largeIcon = BitmapFactory.decodeResource(ResHelper.getResources(),
//				R.drawable.ic_knowl_launcher);
//		NotificationCompat.Builder nb = new NotificationCompat.Builder(App.getInstance())
//				.setLargeIcon(largeIcon)
//				.setSmallIcon(R.drawable.ic_knowl_launcher)
//				.setAutoCancel(true)
//				.setContentTitle(ResHelper.getStringByResId(R.string.new_questions_notification))
//				.setContentText(ResHelper.getStringByResId(R.string.new_questions_notification_content))
//				.setTicker(ResHelper.getStringByResId(R.string.new_questions_notification))
//				.setContentIntent(contentPendingIntent);
//
//		mNotificationManager.notify(NOTIFICATION_ID, nb.build());



	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_offline, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@OnClick(R.id.button)
	public void clickButton(View view){

		AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

		// 2. Chain together various setter methods to set the dialog characteristics
		builder.setMessage(R.string.dialog_message)
				.setTitle(R.string.dialog_title);

		builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				// User clicked OK button
			}
		});

		builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				// User cancelled the dialog
			}
		});

		// 3. Get the AlertDialog from create()
		AlertDialog dialog = builder.create();



		dialog.show();

	}

}
