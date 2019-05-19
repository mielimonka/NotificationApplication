package com.example.notificationapplication;


import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final String CHANNEL_ID = "YourChannel";
    private TextView mDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Calendar compareCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO: task 1

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //createNotificationChannel(); //leave it as a comment for now

        //TODO: use getInstance method for compareCalendar;
        //compareCalendar = ....

        mDate = (TextView) findViewById(R.id.date);

        //ToDO: set OnClick listener for mDate.
        // In onCLick method create a DatePickerDialog object, try to figure out,
        // what variables will you need for the object to work.
        // Here's a little hint: at one point use android.R.style.Theme_Holo_Light_Dialog_MinWidth.

        //your code




        //TODO: another hint. This object should be used in DatePickerDialog constructor
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //TODO: set EPOCH time for compareCalendar, use variables: year, moth, dayOfMonth
                // compareCalendar......

                //ToDO: create a showDate String. Try to figure out, what should it consist of.
                // Uncomment the line below.
                //month = month + 1; //we add one to the month variable, because Calendar sets values of
                //months as integers starting from 0, so our user will see May as a 4, June as a 5, and so on...

                //String showDate = .....

                //sendNotification(); // for now leave it as a comment
                mDate.setText(showDate);

            }
        };

    }

    //ToDO: Task 2
    // Uncomment the code below

//    private void createNotificationChannel() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//
//            //TODO: create objects needed in order to creat a NotificationChannel object
//
//            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
//
//            String description = "This is a temporary channel description";
//            channel.setDescription(description);
//
//            NotificationManager notificationManager = getSystemService(NotificationManager.class);
//            notificationManager.createNotificationChannel(channel);
//
//        }
//    }
//
//    private void sendNotification() {
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//        String text =dateFormat.format(compareCalendar.getTime());
//
//        notificationCall(text);
//
//
//
//    }
//
//
//
//    public void notificationCall(String text){
//        int notificationId = 1;
//        //TODO: create a NotificationCompat.Builder object
//        // hint: use premade String CHANNEL_ID
//
//
//        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.notify(notificationId,notificationBuilder.build());
//    }
}
