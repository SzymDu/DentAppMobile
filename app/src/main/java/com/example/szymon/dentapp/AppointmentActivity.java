package com.example.szymon.dentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.szymon.dentapp.model.Appointment;
import com.example.szymon.dentapp.model.Doctor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppointmentActivity extends AppCompatActivity {
    TextView mtName, mtSurname, mtDate, mtTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        populateListView();
    }

    private void populateListView() {
        if(getIntent().hasExtra("appointment")){
            JSONArray appointmentArray = null;
            try {
                appointmentArray = new JSONArray(getIntent().getStringExtra("appointment"));
                List<Appointment> appointments = new ArrayList<Appointment>();
                ArrayList<Appointment> apoint= new Gson().fromJson(appointmentArray.toString(), new TypeToken<List<Appointment>>(){}.getType());
                ObjectMapper objectMapper = new ObjectMapper();
                List<Appointment> myObjects = Arrays.asList(objectMapper.readValue(appointmentArray.toString(), Appointment[].class));
                ListAdapter adapter = new AppointmentListAdapter(this, myObjects);
                ListView listView = findViewById(R.id.appointmentList);
                listView.setAdapter(adapter);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
