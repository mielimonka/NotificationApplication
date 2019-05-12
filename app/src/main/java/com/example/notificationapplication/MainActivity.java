package com.example.notificationapplication;


import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final String CHANNEL_ID = "YourChannel";

    private TextView mDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Calendar compareCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        compareCalendar = Calendar.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDate = (TextView) findViewById(R.id.date);
        createNotificationChannel();
        mDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener,year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                compareCalendar.set(year,month,dayOfMonth);
                month = month + 1;
                String showDate = month + "/" + dayOfMonth + "/" + year;
                sendNotification();
                mDate.setText(showDate);

            }
        };


    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            //tu wpisz swój kod

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);

            //tu wpisz swój kod

        }
    }

    private void sendNotification() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String text =dateFormat.format(compareCalendar.getTime());

        notificationCall(text);



    }




    public void notificationCall(String text){
        int notificationId = 1;

        //tu wpisz kod, w którym stworzysz obiekt notificationBuilder

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId,notificationBuilder.build());
    }
}
