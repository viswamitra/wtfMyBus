package day.hack.wtfMyBus;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
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



public class SeederActivity extends Activity implements LocationListener {

    private static final String TAG = "seederActivity";
    private String userId;
    private String busNumber;
    private ProgressDialog progressDialog;

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
        busNumber = seeder.getText().toString();
        userId = getIntent().getExtras().get("userId").toString();

        Log.d(TAG, "------------> "+busNumber);
        Log.d(TAG, "----------> "+userId);
		shareButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForMap();
            }
        });
	}
	
	public void startActivityForMap() {
//		Intent intent = new Intent(this, SeederLocationMapActivity.class);
//        intent.putExtra("userId", userId);
//        intent.putExtra("busNumber", busNumber);
//		startActivity(intent);

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
	}

    @Override
    public void onLocationChanged(Location location) {
        new SeederAsyncTask(userId, busNumber, location, progressDialog).execute();
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}


