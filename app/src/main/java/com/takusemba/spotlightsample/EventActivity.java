package com.takusemba.spotlightsample;

import android.app.Dialog;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.domain.Event;

import java.util.ArrayList;

import devlight.io.library.ntb.NavigationTabBar;

import static com.takusemba.spotlightsample.MainActivity.db;

public class EventActivity extends AppCompatActivity {
    TextView tvEventStartTime,tvEventEndTime,tvEventStartTime2,tvEventEndTime2,tvEventRegular,tvEventCancelTime,tvEventSetTime,
            tvAddEvent;
    EditText etEventTitle,etEventDescription;
    RadioGroup radioGroup;

    TimePicker timePicker;

    Switch switchEventTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        etEventTitle=(EditText)findViewById(R.id.etEventTitle);
        etEventDescription=(EditText)findViewById(R.id.etEventDescription);
        tvEventStartTime=(TextView)findViewById(R.id.tvEventStartTime);
        tvEventEndTime=(TextView)findViewById(R.id.tvEventEndTime);
        tvEventStartTime2=(TextView)findViewById(R.id.tvEventStartTime2);
        tvEventEndTime2=(TextView)findViewById(R.id.tvEventEndTime2);
        tvEventRegular=(TextView)findViewById(R.id.tvEventRegular);
        switchEventTime=(Switch)findViewById(R.id.switchEventTime);
       // tvEventStartTime.setText(getIntent().getStringExtra("date"));
      //  tvEventEndTime.setText(getIntent().getStringExtra("date"));
        tvAddEvent=(TextView)findViewById(R.id.tvAddEvent);
        tvAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventTitle=etEventTitle.getText().toString();
                String eventDescription=etEventDescription.getText().toString();
                db.addTodo(new TodoAdd(eventTitle,eventDescription,""));
                Toast.makeText(EventActivity.this,"Event Added Successfully",Toast.LENGTH_SHORT).show();

            }
        });
        switchEventTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchEventTime.isChecked()){
                    tvEventStartTime2.setText("");
                    tvEventEndTime2.setText("");
                }
                else{
                    tvEventStartTime2.setText("13:00");
                    tvEventEndTime2.setText("13:00");
                }
            }
        });

        tvEventRegular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(EventActivity.this);
                dialog.setContentView(R.layout.dialog_event_type);
                dialog.setTitle("Event Type");
                dialog.show();
                radioGroup=(RadioGroup)dialog.findViewById(R.id.radioGroup);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                        RadioButton checkedRadioButton = (RadioButton) dialog.findViewById(checkedId);
                        String text=checkedRadioButton.getText().toString();
                        tvEventRegular.setText(text);
                    }
                });
            }
        });

        tvEventStartTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(EventActivity.this);
                dialog.setContentView(R.layout.event_time);
                dialog.show();
                timePicker=(TimePicker)dialog.findViewById(R.id.timePicker);
                tvEventCancelTime=(TextView)dialog.findViewById(R.id.tvEventCancelTime);
                tvEventSetTime=(TextView)dialog.findViewById(R.id.tvEventSetTime);

                tvEventCancelTime.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                tvEventSetTime.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int hour=timePicker.getCurrentHour();
                        int mins=timePicker.getCurrentMinute();
                        String time=hour+":"+mins;
                        tvEventStartTime2.setText(time);
                        dialog.dismiss();
                    }
                });
            }
        });


        tvEventEndTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(EventActivity.this);
                dialog.setContentView(R.layout.event_time);
                dialog.show();
                timePicker=(TimePicker)dialog.findViewById(R.id.timePicker);
                tvEventCancelTime=(TextView)dialog.findViewById(R.id.tvEventCancelTime);
                tvEventSetTime=(TextView)dialog.findViewById(R.id.tvEventSetTime);
                tvEventCancelTime.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                tvEventSetTime.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int hour=timePicker.getCurrentHour();
                        int mins=timePicker.getCurrentMinute();
                        String time=hour+":"+mins;
                        tvEventEndTime2.setText(time);
                        dialog.dismiss();
                    }
                });
            }
        });

    }
}
