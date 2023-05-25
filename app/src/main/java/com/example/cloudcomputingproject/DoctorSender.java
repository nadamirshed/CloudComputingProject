package com.example.cloudcomputingproject;

import android.os.Message;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class DoctorSender {

    public void sendNotificationToPatient(String patientToken, String title, String message) {
        // إنشاء رسالة FCM
        Message fcmMessage = Message.builder()
                .setToken(patientToken)  // رمز الجهاز للمستلم (مريض)
                .putData("title", title)
                .putData("message", message)
                .build();

        try {
            // إرسال الرسالة
            String response = FirebaseMessaging.getInstance().send(fcmMessage);
            System.out.println("Message sent successfully: " + response);
        } catch (FirebaseMessagingException e) {
            System.out.println("Error sending message: " + e.getMessage());
        }
    }

    public void createNotification(String title, String message) {
        // إنشاء وعرض الإشعار
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channelId")
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1, builder.build());
    }
}


