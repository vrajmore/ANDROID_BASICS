package com.example.firebaseauthlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {

    private TextView email, password, signuperror;
    private Button createaccount, signin;

    private static final String TAG = "signup";
    private FirebaseAuth auth;

    private VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email = findViewById(R.id.signupemail);
        password = findViewById(R.id.signuppassword);
        signuperror = findViewById(R.id.signuperror);
        createaccount = findViewById(R.id.createaccbtn);
        signin = findViewById(R.id.signinpagebtn);
        vv = findViewById(R.id.videoView2);

        auth = FirebaseAuth.getInstance();


        vv.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.abcd));
        vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                vv.start();
            }
        });
        vv.start();

        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailin = email.getText().toString();
                String passin = password.getText().toString();

                if (!emailin.isEmpty() && !passin.isEmpty()) {
                    Log.d(TAG, "onClick: empty success");
                    if (emailin.matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}")) {
                        Log.d(TAG, "onClick: regex success");
                        if (passin.length() > 5){
                            Log.d(TAG, "onClick: password success");
                            auth.createUserWithEmailAndPassword(emailin, passin)
                                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                        @Override
                                        public void onSuccess(AuthResult authResult) {
                                            Toast.makeText(signup.this, "SIGNUP SUCCESSFUL", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(signup.this, MainActivity.class));
                                            finish();
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            signuperror.setText("ERROR IN CREATING USER");
                                        }
                                    });
                        }else {
                            signuperror.setText("PASSWORD is less then 5");
                            Log.d(TAG, "onClick: pass fail");
                        }
                    } else {
                        signuperror.setText("INVALID EMAIL");
                        Log.d(TAG, "onClick: regex fail");
                    }
                } else {
                    signuperror.setText("EMAIL or PASSWORD EMPTY");
                    Log.d(TAG, "onClick: empty fail");
                }

            }
        });


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signup.this, signin.class));
                finish();
            }
        });

    }
}