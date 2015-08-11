package mikecanco.de.offline;

import android.app.Application;

import com.squareup.otto.Bus;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;

public class OfflineApplication extends Application {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "e3GYokZAuXKx3lw30YxhceoCH";
    private static final String TWITTER_SECRET = "4IMtab61zp5tn2112B3hgYGJqI8KV5OLaj534MkZAlE55xwKKJ";


	private static OfflineApplication sInstance;

	private static Bus sBus;
	private static boolean userInApp;

	public static boolean isUserInApp() {
		return userInApp;
	}

	public static void setUserInApp(boolean userInApp) {
		OfflineApplication.userInApp = userInApp;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
		Fabric.with(this, new Twitter(authConfig));

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
