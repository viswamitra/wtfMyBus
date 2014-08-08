package day.hack.wtfMyBus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by abhiramk on 08/08/14.
 */

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import android.app.Activity;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MapActivity extends Activity implements LocationListener {

    private GoogleMap map;
    private static final String TAG = "mapActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);

        // Get a handle to the Map Fragment


        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);


        map = ((MapFragment) getFragmentManager()
                .findFragmentById(R.id.map)).getMap();

        Intent intent = getIntent();
        String userLocationJson = intent.getExtras().get("userLocationsJson").toString();
        Type type = new TypeToken<List<UserLocation>>(){}.getType();
        List<UserLocation> userLocations = new Gson().fromJson(userLocationJson,type);

        for(UserLocation userLocation : userLocations) {
            LatLng yourLocation = new LatLng(Double.parseDouble(userLocation.getLatitude()), Double.parseDouble(userLocation.getLongitude()));
            map.addMarker(new MarkerOptions()
                    .position(yourLocation)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_icon)));
        }
    }

    @Override
    public void onLocationChanged(Location location) {

        LatLng yourLocation = new LatLng(location.getLatitude(), location.getLongitude());
        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(yourLocation, 13));

        map.addMarker(new MarkerOptions()
                .title("you")
                .snippet("Your current Location")
                .position(yourLocation));
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
