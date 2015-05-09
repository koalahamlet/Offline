package mikecanco.de.offline;

import android.app.Application;

public class OfflineApplication extends Application {

	private static OfflineApplication sInstance;

	@Override
	public void onCreate() {
		super.onCreate();
		sInstance = this;
	}

	public static OfflineApplication getInstance() {
		return sInstance;
	}

}
