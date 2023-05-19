package com.example.cloudcomputingproject;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Handler h = new Handler();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                                           @Override
                                           public void onComplete(@NonNull Task<String> task) {
                                               if (!task.isSuccessful()) {
                                                   Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                                                   return;
                                               }

                                               // Get new FCM registration token
                                               String token = task.getResult();
                                               System.out.print("Token" + token);
                                           }


                        // Log and toast
//                        String msg = getString(R.string.msg_token_fmt, token);

                });
        FirebaseMessaging.getInstance().subscribeToTopic("notification");
//        FirebaseMessaging.getInstance().unsubscribeFromTopic("");



        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, DoctorOrPatient.class));
                finish();
            }
        }, 5000);

    }

}
