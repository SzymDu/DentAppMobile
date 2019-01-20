package com.example.szymon.dentapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.szymon.dentapp.model.Appointment;

import org.w3c.dom.Text;

import java.util.List;

class AppointmentListAdapter extends ArrayAdapter<Appointment> {
    public AppointmentListAdapter(Context context, List<Appointment> objects) {
        super(context, R.layout.appointmentlist, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View custom = layoutInflater.inflate(R.layout.appointmentlist, parent, false);
        String fullname = getItem(position).getPatientIdpatient().getName() + " "
                 + getItem(position).getPatientIdpatient().getSurname();
        TextView  time = custom.findViewById(R.id.time);
        TextView date = custom.findViewById(R.id.data);
        TextView pacjent = custom.findViewById(R.id.pacjent);

        pacjent.setText(fullname);
        time.setText(getItem(position).getTime());
        date.setText(getItem(position).getDate().toString());

        return custom;

    }
}
