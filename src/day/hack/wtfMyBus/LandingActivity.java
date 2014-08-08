package day.hack.wtfMyBus;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by abhiramk on 08/08/14.
 */
public class LandingActivity extends Activity {
    private ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        TextView myTextView=(TextView)findViewById(R.id.app_name);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/RobotoCondensed-Light.ttf");
        myTextView.setTypeface(typeFace);
    }


    public void LaunchLoginActivity(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
