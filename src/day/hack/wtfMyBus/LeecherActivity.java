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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.view.View.OnClickListener;



public class LeecherActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.leecher_screen);
	}


	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	protected void onStart() {
		super.onStart();
		TextView busText = (TextView) findViewById(R.id.bustext);
		SearchView seeder  = (SearchView) findViewById(R.id.searchView);
		Button searchButton = (Button) findViewById(R.id.searchBtn);
		
		searchButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivityForMap();
			}
		});
	}


	public void startActivityForMap() {
		Intent intent = new Intent(this, MapsActivity.class);
		startActivity(intent);
	}
}

