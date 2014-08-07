package day.hack.wtfMyBus;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import com.google.android.maps.MapActivity;

import android.app.Activity;

import android.os.Bundle;
public class MapsActivity extends Activity 
{    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_fragment);
    }
 
   
}