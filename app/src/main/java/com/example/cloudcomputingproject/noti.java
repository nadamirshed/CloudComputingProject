package com.example.cloudcomputingproject;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import com.google.firebase.messaging.FirebaseMessagingService;




import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;




import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;


    public class noti extends FirebaseMessagingService {
        public static final String CHANNEL_1_ID = "channel1";
        public static final String CHANNEL_2_ID = "channel2";
        //    @Override
//    public void onMessageReceived(@NonNull RemoteMessage message) {
//        super.onMessageReceived(message);
//        getFirebaseMessage(message.getNotification().getTitle(),message.getNotification().getBody());
//    }
//
//
//    @SuppressLint("MissingPermission")
//    private void getFirebaseMessage(String title, String massege) {
//        NotificationCompat.Builder builder= new NotificationCompat.Builder(this,"myChannel")
//                .setSmallIcon(R.drawable.baseline_person_24)
//                .setContentTitle(massege)
//                .setContentText(title)
//                .setAutoCancel(true);
//        NotificationManagerCompat manger=NotificationManagerCompat.from(this);
//        manger.notify(101,builder.build());
//
//
//    }
//
//}
        public void onCreate() {
            super.onCreate();


            createNotificationChannels();
        }

        private void createNotificationChannels() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel1 = new NotificationChannel(
                        CHANNEL_1_ID,
                        "Channel 1",
                        NotificationManager.IMPORTANCE_HIGH
                );
                channel1.setDescription("This is Channel 1");

                NotificationChannel channel2 = new NotificationChannel(
                        CHANNEL_2_ID,
                        "Channel 2",
                        NotificationManager.IMPORTANCE_LOW
                );
                channel2.setDescription("This is Channel 2");

                NotificationManager manager = getSystemService(NotificationManager.class);
                manager.createNotificationChannel(channel1);
                manager.createNotificationChannel(channel2);
            }
        }
    }


