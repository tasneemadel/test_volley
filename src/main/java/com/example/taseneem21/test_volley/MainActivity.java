package com.example.taseneem21.test_volley;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

/*
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
*/
public class MainActivity extends Activity implements View.OnClickListener {

    public static final String REGISTER_URL = "http://localhost/Api/index.php";

    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "pass";
    public static final String KEY_EMAIL = "email";
// `phone`, `GroupID`, `Blood`, `birthDate`, `healthCondition`
public static final String KEY_PHONE = "phone";
    public static final String KEY_GROUPID = "GroupID";
    public static final String KEY_Blood = "Blood";
    public static final String KEY_BIRTHDATE = "birthDate";
    public static final String KEY_HealthDate = "healthCondition";

    private EditText editTextUsername;
    private EditText editTextEmail;
    private EditText editTextPassword;

    private EditText editTextPhone;
    private EditText editTextGroupID;
    private EditText editTextBlood;

    private EditText editTextbirthdate;
    private EditText editTexthealthCondition;

    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextEmail= (EditText) findViewById(R.id.editTextEmail);

        editTextBlood= (EditText) findViewById(R.id.blood);
        editTextbirthdate= (EditText) findViewById(R.id.birthdate);

        editTexthealthCondition= (EditText) findViewById(R.id.healthcondition);
        editTextPhone= (EditText) findViewById(R.id.phone);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(this);
    }

    private void registerUser() throws JSONException {

        final String username = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        final String email = editTextEmail.getText().toString().trim();


        final String phone = editTextPhone.getText().toString().trim();
        final String blood= editTextBlood.getText().toString().trim();
        final String birthdate = editTextbirthdate.getText().toString().trim();
        final String healthcondition = editTexthealthCondition.getText().toString().trim();

        final String GroupId = editTextGroupID.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        Log.d("Error.Response", error.toString());
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME,username);
                params.put(KEY_PASSWORD,password);
                params.put(KEY_EMAIL, email);

                params.put(KEY_BIRTHDATE,birthdate);
                params.put(KEY_Blood,blood);
                params.put(KEY_PHONE, phone);
                params.put(KEY_HealthDate, healthcondition);
                params.put(KEY_GROUPID, GroupId);
                return params;
            }};

   RequestQueue requestQueue = Volley.newRequestQueue(this);
    requestQueue.add(stringRequest);

      //  AppController.getInstance().addToRequestQueue(stringRequest, tag_json_obj);
    }



    @Override
    public void onClick(View v) {
        try{
        //registerUser();
            Intent i = new Intent(MainActivity.this, fetchdata.class);
            startActivity(i);
        }
        catch (Exception e){

        }

    }
}