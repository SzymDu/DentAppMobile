package com.example.szymon.dentapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import static android.Manifest.permission.READ_CONTACTS;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_READ_CONTACTS = 0;
    EditText email, password;
    TextView test;
    Button logButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         email = findViewById(R.id.etEmail);
        password =  findViewById(R.id.etPassword);
        logButton =  findViewById(R.id.logButton);
        logButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.logButton:
                doLogin();
                break;
        }
    }
    private void doLogin(){
        final OkHttpClient client = new OkHttpClient();
        final String URL  = "http://10.0.2.2:8080/doctor/byemail";
        MediaType JSON = MediaType.parse("application/json");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("email", "laczki323q@wp.pl");
            jsonObject.put("password", "laczki3");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody requestBody = RequestBody.create(JSON, jsonObject.toString());
        Request request = new Request.Builder().url(URL).post(requestBody).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final okhttp3.Response response) throws IOException {
                if(response != null){
                    final String my = response.body().string();

                    Login.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JSONObject data = new JSONObject(my);
                                Intent intent = new Intent(Login.this, Profile.class);
                                intent.putExtra("json" ,data.toString());
                                startActivity(intent);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
    }
}
