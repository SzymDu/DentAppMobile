package com.example.szymon.dentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.szymon.dentapp.model.Doctor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Profile extends AppCompatActivity implements View.OnClickListener {
    TextView mtEmail, mtPesel, mtName, mtMobile, mtDob;
    Button appointmentButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        if(getIntent().hasExtra("json")){
            try {
                JSONObject doctorObject = new JSONObject(getIntent().getStringExtra("json"));
                String logged = doctorObject.toString();
                ObjectMapper objectMapper = new ObjectMapper();
                Doctor doctor = objectMapper.readValue(logged, Doctor.class);
                String fullName = doctor.getName() + " " + doctor.getSurname();
               mtEmail = findViewById(R.id.email);
               appointmentButton = findViewById(R.id.appointmentButton);
               appointmentButton.setOnClickListener(this);
               mtPesel = findViewById(R.id.pesel);
               mtName = findViewById(R.id.name);
               mtDob = findViewById(R.id.dateOfBirth);
               mtMobile = findViewById(R.id.mobileNumber);
               mtEmail.setText(doctor.getEmail());
               mtPesel.setText(doctor.getPesel());
               mtName.setText(fullName);
               mtDob.setText(doctor.getDateOfBirth());
               mtMobile.setText(doctor.getPhoneNumber());
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (JsonParseException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.appointmentButton:
                getAppointment();
                break;
        }
    }

    private void getAppointment() {
        try {
            final OkHttpClient client = new OkHttpClient();
            final String URL  = "http://10.0.2.2:8080/appointment/bydoctorid";
            MediaType JSON = MediaType.parse("application/json");
            JSONObject doctorObject = new JSONObject(getIntent().getStringExtra("json"));
            String logged = doctorObject.toString();
            ObjectMapper objectMapper = new ObjectMapper();
            Doctor doctor = objectMapper.readValue(logged, Doctor.class);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("iddoctor", doctor.getIddoctor() );
            RequestBody requestBody = RequestBody.create(JSON, jsonObject.toString());
            Request request = new Request.Builder()
                    .url(URL)
                    .post(requestBody).build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final String res = response.body().string();
                    Profile.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JSONArray data = new JSONArray(res);
                                Intent intent = new Intent(Profile.this, AppointmentActivity.class);
                                intent.putExtra("appointment" ,data.toString());
                                startActivity(intent);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    );
                }
            });
            } catch (JSONException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } }
    }

