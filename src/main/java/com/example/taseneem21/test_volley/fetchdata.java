package com.example.taseneem21.test_volley;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class fetchdata extends ActionBarActivity{
    String myJSON;

    private static final String TAG_RESULTS="result";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";
    private static final String TAG_ADD ="address";


    private static final String TAG = fetchdata.class.getSimpleName();

    // Movies json url
    private static final String url = "http://localhost/Api/index.php";
    private ProgressDialog pDialog;
    private List<User> movieList = new ArrayList<User>();
    private ListView listView;
    private CustomListAdapter adapter;


    ArrayList<User> arrayList ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fetchdata);

        arrayList = new ArrayList<User>();


        listView = (ListView) findViewById(R.id.listView);
        adapter = new CustomListAdapter(arrayList, this);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // changing action bar color
        //getActionBar().setBackgroundDrawable(
          //      new ColorDrawable(Color.parseColor("#1b1b1b")));

        // Creating volley request obj
        JsonArrayRequest userReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                User user = new User();

                                    user.setUsername(obj.getString("username"));
                                user.setUserEmail(obj.getString("email"));


                                user.setUserPass(obj.getString("pass"));
                                user.setUserPhone(obj.getString("phone"));

                                user.setUserHealthCondition(obj.getString("healthCondition"));
                                user.setUserBirthday(obj.getString("birthDate"));

                                user.setUserBlood(obj.getString("Blood"));
                                user.setUserGroupID(obj.getString("GroupID"));



                                // adding movie to movies array
                                arrayList.add(user);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();

            }
        });

        // Adding request to request queue
      //  AppController.getInstance().addToRequestQueue(movieReq);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(userReq);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}


