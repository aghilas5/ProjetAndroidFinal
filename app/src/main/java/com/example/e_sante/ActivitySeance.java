package com.example.e_sante;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ActivitySeance extends AppCompatActivity {

    Button btnDate,btnheure;
    TextView textdate,textheure;
    DatePickerDialog picker;



    private int lastSelectedHour = -1;
    private int lastSelectedMinute = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_heureseance);
        btnDate=findViewById(R.id.btndate);
        textdate=findViewById(R.id.textDate);
        textheure=findViewById(R.id.textHeure);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(ActivitySeance.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                textdate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        btnheure=findViewById(R.id.btnheure);
        btnheure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSelectTime();

            }
        });


    }


    private void buttonSelectTime()  {
        if(this.lastSelectedHour == -1)  {
            // Get Current Time
            final Calendar c = Calendar.getInstance();
            this.lastSelectedHour = c.get(Calendar.HOUR_OF_DAY);
            this.lastSelectedMinute = c.get(Calendar.MINUTE);
        }

        final boolean is24HView = true;
        final boolean isSpinnerMode = false;

        // Time Set Listener.
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                textheure.setText(hourOfDay + ":" + minute );
                lastSelectedHour = hourOfDay;
                lastSelectedMinute = minute;
            }
        };

        // Create TimePickerDialog:
        TimePickerDialog timePickerDialog = null;


        if(isSpinnerMode)  {
            timePickerDialog = new TimePickerDialog(this,
                    android.R.style.Theme_Holo_Light_Dialog_NoActionBar,
                    timeSetListener, lastSelectedHour, lastSelectedMinute, is24HView);
        }
        // TimePicker in Clock Mode (Default):
        else  {
            timePickerDialog = new TimePickerDialog(this,
                    timeSetListener, lastSelectedHour, lastSelectedMinute, is24HView);
        }

        // Show
        timePickerDialog.show();
    }
}