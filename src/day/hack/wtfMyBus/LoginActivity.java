package day.hack.wtfMyBus;
import day.hack.wtfMyBus.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.view.View.OnClickListener;



public class LoginActivity extends Activity {

	private static final String TAG = "LoginActivity";
	private static final String APP_TITLE = "WTFmyBUS";
	private static final int STATUS_CODE = 1;
	private ProgressDialog progressDialog;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login_screen);
	}

	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	protected void onStart() {
		super.onStart();
		
		final LocationManager manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );

	    if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
	        buildAlertMessageNoGps();
	    }

	
		
			
			Button loginButton = (Button) findViewById(R.id.loginBtn);
			final RadioButton leecher = (RadioButton) findViewById(R.id.radio1);
			final RadioButton seeder = (RadioButton) findViewById(R.id.radio0);
			RadioGroup radiogrp = ((RadioGroup) findViewById (R.id.radiogrp));
			
			radiogrp.setOnCheckedChangeListener(new OnCheckedChangeListener(){
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				
			    switch (checkedId){
			    case R.id.radio1:
			        
			        break;
			    case R.id.radio0:
			    	
			        break;
			
			}
			}
			});

			loginButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					if (leecher.isChecked())
					{
						Intent intent=new Intent(this,LeecherActivity.class);
						startActivity(intent);
					}
					else if (seeder.isChecked())
					{
						Intent intent=new Intent(this,SeederActivity.class);
						startActivity(intent);
					}
				}
			});
			
		}
	  public void buildAlertMessageNoGps() {
		    final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		    builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
		           .setCancelable(false)
		           .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
		               public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
		                   startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
		               }
		           })
		           .setNegativeButton("No", new DialogInterface.OnClickListener() {
		               public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
		                    dialog.cancel();
		               }
		           });
		    final AlertDialog alert = builder.create();
		    alert.show();
		}
		
	}


