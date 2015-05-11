package mikecanco.de.offline;

import android.app.Application;

import com.squareup.otto.Bus;

public class OfflineApplication extends Application {

	private static OfflineApplication sInstance;

	private static Bus sBus;

	@Override
	public void onCreate() {
		super.onCreate();
		sInstance = this;

		sBus = new Bus();

		Globals.setOfflineQueryAlarm();
	}

	public static OfflineApplication getInstance() {
		return sInstance;
	}

	public static Bus getBus() {
		return sBus;
	}

}
