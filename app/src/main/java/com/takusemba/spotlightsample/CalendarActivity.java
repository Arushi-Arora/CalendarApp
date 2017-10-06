package com.takusemba.spotlightsample;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;

import java.util.Date;

public class CalendarActivity extends AppCompatActivity {
    CompactCalendarView compactCalendarView;


    FloatingActionButton fab;
    Button btnWeek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        fab=(FloatingActionButton)findViewById(R.id.fab);
        btnWeek=(Button)findViewById(R.id.btnWeek);
        btnWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalendarActivity.this,WeekActivity.class));
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalendarActivity.this,EventActivity.class));
            }
        });

        compactCalendarView=(CompactCalendarView)findViewById(R.id.compactCalendarView);
        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Log.d("CLICK", "onDayClick: ");
               startActivity(new Intent(CalendarActivity.this,EventsDisplay.class));
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {

            }
        });
    }
}
