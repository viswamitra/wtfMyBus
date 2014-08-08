package day.hack.wtfMyBus;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhiramk on 08/08/14.
 */
public class MapAsyncTask extends AsyncTask<String, Void, List> {

    private String userId;
    private String busNumber;
    private Context context;
    private ProgressDialog progressDialog;

    private static final String TAG = "mapAsyncTask";
    private static final String searchBusUrl = "http://172.17.94.196:8085/userLocations/busNumber?busNumber=";

    public MapAsyncTask(String userId, String busNumber, Context context, ProgressDialog progressDialog) {
        this.userId = userId;
        this.busNumber = busNumber;
        this.context = context;
        this.progressDialog = progressDialog;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setTitle("Getting Maps for you");
        progressDialog.setMessage("Please wait!");
        progressDialog.show();
    }

    @Override
    protected List<UserLocation> doInBackground(String... url) {
        HttpClient httpclient = new DefaultHttpClient();
        String response = "";


        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(searchBusUrl+busNumber);
        try {
            HttpResponse execute = client.execute(httpGet);
            InputStream content = execute.getEntity().getContent();

            BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
            String s = "";
            while ((s = buffer.readLine()) != null) {
                response += s;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        List<UserLocation> userLocations = convertResponseToUserLocations(response);
        return userLocations;
    }

    private List<UserLocation> convertResponseToUserLocations(String response) {
        Type type = new TypeToken<ArrayList<UserLocation>>() {
        }.getType();
        ArrayList<UserLocation> userLocations = new Gson().fromJson(response, type);
        return userLocations;
    }


    @Override
    protected void onPostExecute(List result) {
        super.onPostExecute(result);
        try {
            if ( progressDialog.isShowing()) {
                progressDialog.dismiss();
                progressDialog = null;
            }
        } catch (Exception e) {
            //nothing
        }
        Intent intent = new Intent(context, MapsActivity.class);
        String userLocationsJson = new Gson().toJson(result);
        intent.putExtra("userLocationsJson", userLocationsJson);
        context.startActivity(intent);
    }


}
