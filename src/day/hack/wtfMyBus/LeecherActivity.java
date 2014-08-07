package day.hack.wtfMyBus;

import day.hack.wtfMyBus.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
		int gps=1;
		//check for gps
		if(gps!=0){
			
			TextView busText = (TextView) findViewById(R.id.bustext);
			EditText leecher = (EditText) findViewById(R.id.editbustext);
			Button shareButton = (RadioButton) findViewById(R.id.shareBtn);

			shareButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent=new Intent(this,MapActivity.class);
					startActivity(intent);
				}
			});
			
		}
		
	}
}

