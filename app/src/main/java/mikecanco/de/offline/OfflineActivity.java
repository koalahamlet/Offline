package mikecanco.de.offline;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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

		//TODO: Some layer of twitter login needs to go here
		

		//TODO: this chunk of code is how we would set an alarm

		Globals.setOfflineQueryAlarm();

	}

	//no menus needed here.
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.menu_offline, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//
//		//noinspection SimplifiableIfStatement
//		if (id == R.id.action_settings) {
//			return true;
//		}
//
//		return super.onOptionsItemSelected(item);
//	}

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
