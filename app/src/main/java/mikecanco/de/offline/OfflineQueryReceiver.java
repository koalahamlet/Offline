package mikecanco.de.offline;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class OfflineQueryReceiver extends BroadcastReceiver {
	public OfflineQueryReceiver() {
	}

	@Override
	public void onReceive(Context context, Intent intent) {

//		throw new UnsupportedOperationException("Not yet implemented");

		// as far as we know, they're offline *troll*
		Globals.setOffline(true);
		Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
		// Vibrate for 500 milliseconds
		v.vibrate(500);
		// set something that waits ten seconds
		Log.e("OfflineQueryReceiver", "wtf");
		Toast.makeText(context, "hello dave", Toast.LENGTH_LONG).show();

//		NotificationCompat.Builder mBuilder =
//				new NotificationCompat.Builder(context)
//						.setSmallIcon(R.drawable.abc_btn_check_material)
//						.setContentTitle("My notification")
//						.setContentText("Hello World!");
//
		NotificationManager mNotificationManager =
				(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//// mId allows you to update the notification later on.
//		mNotificationManager.notify(1, mBuilder.build());

		// First let's define the intent to trigger when notification is selected
// Start out by creating a normal intent (in this case to open an activity)
		Intent i = new Intent(context, OfflineActivity.class);
// Next, let's turn this into a PendingIntent using
//   public static PendingIntent getActivity(Context context, int requestCode,
//       Intent intent, int flags)
		int requestID = (int) System.currentTimeMillis(); //unique requestID to differentiate between various notification with same NotifId
		int flags = PendingIntent.FLAG_CANCEL_CURRENT; // cancel old intent and create new one

		PendingIntent pIntent = PendingIntent.getActivity(context, requestID, i, flags);
// Now we can attach this to the notification using setContentIntent
		Notification noti =
				new NotificationCompat.Builder(context)
						.setSmallIcon(R.drawable.abc_btn_check_material)
						.setContentTitle("#Offline")
						.setContentText("Are you Offline?")
						.setContentIntent(pIntent).build();

// Hide the notification after its selected
//		noti.setAuto(true);

// mId allows you to update the notification later on.
		mNotificationManager.notify(0, noti);

		// TODO: This method is called when the BroadcastReceiver is receiving
		// Launch notification
		// if no response in

//		Log.d(TAG, "upload logs.");
//		JobManager jobManager = App.getInstance().getJobManager();
//		jobManager.addJob(new UploadLogsJob(MetricLogger.getLatestFilename(), context));
//		jobManager.addJob(new UploadQuestionsJob(context));
//		MetricLogger.reset();

	}
}
