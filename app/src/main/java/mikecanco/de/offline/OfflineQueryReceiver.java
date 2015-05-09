package mikecanco.de.offline;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class OfflineQueryReceiver extends BroadcastReceiver {
	public OfflineQueryReceiver() {
	}

	@Override
	public void onReceive(Context context, Intent intent) {


		throw new UnsupportedOperationException("Not yet implemented");


		// TODO: This method is called when the BroadcastReceiver is receiving
		// Launch notification


//		Log.d(TAG, "upload logs.");
//		JobManager jobManager = App.getInstance().getJobManager();
//		jobManager.addJob(new UploadLogsJob(MetricLogger.getLatestFilename(), context));
//		jobManager.addJob(new UploadQuestionsJob(context));
//		MetricLogger.reset();


	}
}
