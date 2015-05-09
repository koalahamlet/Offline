package mikecanco.de.offline;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

public class Globals {

	private static final String TAG = Globals.class.getSimpleName();

	private static boolean offline = false;

	static AlarmManager alarmManager;

	public static void setOfflineQueryAlarm() {

		PendingIntent offlineAlarmIntent;

		Context context = OfflineApplication.getInstance();

		alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		Intent intent = new Intent(context, OfflineQueryReceiver.class);
		offlineAlarmIntent = PendingIntent.getBroadcast(context, Constants.UPLOAD_ALARM_ID, intent, 0);

		//for now, trigger in 5 seconds then every hour thereafter.
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.SECOND, 5);

		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
				calendar.getTimeInMillis(),
				Constants.QUESTION_QUERY_INTERVAL,
				offlineAlarmIntent);

		Log.d(TAG, "alarm is set.");

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


	}

	public static boolean isOffline() {
		return offline;
	}

	public static void setOffline(boolean offline) {
		Globals.offline = offline;
	}
}
