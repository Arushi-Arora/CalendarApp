package com.takusemba.spotlightsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;

import java.util.ArrayList;
import java.util.List;

public class WeekActivity extends AppCompatActivity  {
    WeekView mweekView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);
        mweekView=(WeekView)findViewById(R.id.weekView);
        mweekView.setMonthChangeListener(new MonthLoader.MonthChangeListener() {
            @Override
            public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
                List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();
                events.add(new WeekViewEvent(1234,"Event1",2017,7,11,10,23,2017,7,11,2,34));
                return events;
            }
        });


    }

}
