package com.example.szymon.dentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.szymon.dentapp.model.Doctor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Profile extends AppCompatActivity {
    TextView mtEmail, mtPesel, mtName, mtMobile, mtDob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        if(getIntent().hasExtra("json")){
            try {
                JSONObject doctorObject = new JSONObject(getIntent().getStringExtra("json"));
                String logged = doctorObject.toString();
                System.out.println(doctorObject.get("surname"));
                ObjectMapper objectMapper = new ObjectMapper();
                Doctor doctor = objectMapper.readValue(logged, Doctor.class);
                String fullName = doctor.getName() + " " + doctor.getSurname();
               mtEmail = findViewById(R.id.email);
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
}
