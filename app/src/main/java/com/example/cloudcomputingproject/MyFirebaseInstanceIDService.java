package com.example.cloudcomputingproject;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

//public class pushNotification extends FirebaseMessagingService {
//
//    @SuppressLint("NewApi")
//    @Override
//    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
//        String title = remoteMessage.getNotification().getTitle();
//        String text = remoteMessage.getNotification().getBody();
//        String CHANNEL_ID = "MESSAGE";
//        NotificationChannel channel = new NotificationChannel(
//                CHANNEL_ID,
//                "Message Notification",
//                NotificationManager.IMPORTANCE_HIGH);
//        getSystemService(NotificationManager.class).createNotificationChannel(channel);
//        Notification.Builder notification = new Notification.Builder(this, CHANNEL_ID)
//                .setContentTitle(title)
//                .setContentText(text)
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setAutoCancel(true);
//        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        NotificationManagerCompat.from(this).notify(1, notification.build());
//        super.onMessageReceived(remoteMessage);
//    }
//}

import androidx.core.app.NotificationCompat;

public class MyFirebaseInstanceIDService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);
        getFirebaseMessage(message.getNotification().getTitle(),message.getNotification().getBody());
    }


    @SuppressLint("MissingPermission")
    private void getFirebaseMessage(String title, String massege) {
        NotificationCompat.Builder builder= new NotificationCompat.Builder(this,"myChannel")
                .setSmallIcon(R.drawable.baseline_person_24)
                .setContentTitle(massege)
                .setContentText(title)
                .setAutoCancel(true);
        NotificationManagerCompat manger=NotificationManagerCompat.from(this);
        manger.notify(101,builder.build());


    }

}