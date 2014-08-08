package day.hack.wtfMyBus;

import day.hack.wtfMyBus.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SearchView;
import android.widget.TextView;
import android.view.View.OnClickListener;



public class SeederActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.seeder_screen);
	}

	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	protected void onStart() {
		super.onStart();
		TextView busText = (TextView) findViewById(R.id.bustext);
		EditText seeder = (EditText) findViewById(R.id.editbustext);
		Button shareButton = (Button) findViewById(R.id.shareBtn);
		String searchableitem = seeder.getText().toString();
		shareButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivityForMap();
			}
		});
	}
	
	public void startActivityForMap() {
//		Intent intent = new Intent(this, MapsActivity.class);
//		startActivity(intent);
	}
}


