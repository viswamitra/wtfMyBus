package day.hack.wtfMyBus;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.AsyncTask;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by abhiramk on 08/08/14.
 */
public class SeederAsyncTask extends AsyncTask<String, Void, Boolean> {

    private String userId;
    private String busNumber;
    private Location location;
    private ProgressDialog progressDialog;

    private static final String TAG = "mapAsyncTask";
    private static final String postUrl = "http://172.17.94.196:8085/userLocations";

    public SeederAsyncTask(String userId, String busNumber, Location location, ProgressDialog progressDialog) {
        this.userId = userId;
        this.busNumber = busNumber;
        this.location = location;
        this.progressDialog = progressDialog;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setTitle("Posting your location");
        progressDialog.setMessage("Please wait!");
        progressDialog.show();
    }

    @Override
    protected Boolean doInBackground(String... url) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response ;
        Boolean result = true;

        UserLocation userLocation = new UserLocation();
        userLocation.setUser_id(userId);
        userLocation.setBus_number(busNumber);
        userLocation.setLatitude(Double.toString(location.getLatitude()));
        userLocation.setLongitude(Double.toString(location.getLongitude()));

        List<UserLocation> userLocations = new ArrayList<UserLocation>();
        userLocations.add(userLocation);

        String userLocationsJson = new Gson().toJson(userLocations);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type","application/json");









        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(postUrl);
        try {
            for (String header : headers.keySet()) {
                httpPost.setHeader(header, headers.get(header));
            }

            if(userLocationsJson != null){
                httpPost.setEntity(new StringEntity(userLocationsJson));
            }

            client.execute(httpPost);


        } catch (Exception e) {

            Log.e(TAG, "Error in executing get request " + e.getMessage());
            result = false;

        }

        return result;
    }




    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        try {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
                progressDialog = null;
            }
        } catch (Exception e) {
            //nothing
        }
    }
}
