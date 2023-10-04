package com.example.pazig_projekt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;
public class MainActivity extends AppCompatActivity {

    ImageButton SettingsButton;
    ImageButton StartButton;
    ImageButton ScoreButton;
    FirebaseFirestore firestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SettingsButton = (ImageButton) findViewById(R.id.SettingsButton4);
        StartButton = (ImageButton) findViewById(R.id.StartButton);
        ScoreButton = (ImageButton) findViewById(R.id.ScoreButton);

        SettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadSettings = new Intent (MainActivity.this, SettingsActivity.class);
                startActivity(intentLoadSettings);
            }
        });

        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadStart = new Intent (MainActivity.this, StartActivity.class);
                startActivity(intentLoadStart);
            }
        });

        ScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadScore = new Intent(MainActivity.this, ScoreActivity.class);
                startActivity(intentLoadScore);
            }
        });

        firestore=FirebaseFirestore.getInstance();

        Map<String,Object> users = new HashMap<>();
        users.put("firstName", "EASY");
        users.put("lastName", "TUTO");
        users.put("description", "Subscribe");

        firestore.collection("users").add(users).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Failure",Toast.LENGTH_LONG).show();

            }
        });


    }
}