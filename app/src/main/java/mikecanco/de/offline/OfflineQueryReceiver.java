package mikecanco.de.offline;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
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

		// set something that waits ten seconds
		Log.e("OfflineQueryReceiver", "wtf");
		Toast.makeText(context, "hello dave", Toast.LENGTH_LONG).show();

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
