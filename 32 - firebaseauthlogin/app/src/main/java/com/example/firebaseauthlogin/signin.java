package com.example.firebaseauthlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class signin extends AppCompatActivity {

    private FirebaseAuth auth;
    private TextView email, password, signinerror;
    private Button loginbtn, signupbtn;
    private static final String TAG = "signin";

    private VideoView vv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        email = findViewById(R.id.signinemail);
        password = findViewById(R.id.signinpassword);
        signinerror = findViewById(R.id.signinerror);
        loginbtn = findViewById(R.id.loginbtn);
        signupbtn = findViewById(R.id.signuppagebtn);
        vv = findViewById(R.id.videoView);


        auth = FirebaseAuth.getInstance();



        vv.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.abcd));
        vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                vv.start();
            }
        });
        vv.start();




        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailin = email.getText().toString();
                String passin = password.getText().toString();

                if (!emailin.isEmpty() && !passin.isEmpty()){
                    Log.d(TAG, "onClick: empty success");
                    if (emailin.matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}")){
                        Log.d(TAG, "onClick: regex success");
                        if (passin.length() > 5){
                            Log.d(TAG, "onClick: password success");
                            auth.signInWithEmailAndPassword(emailin, passin)
                                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                        @Override
                                        public void onSuccess(AuthResult authResult) {
                                            Toast.makeText(signin.this, "SIGNIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(signin.this, MainActivity.class));
                                            finish();
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.d(TAG, "onFailure: "+ e.getStackTrace());
                                            signinerror.setText("ERROR IN LOGIN");
                                        }
                                    });
                        }else {
                            signinerror.setText("PASSWORD is less then 5");
                            Log.d(TAG, "onClick: pass fail");
                        }
                    }else {
                        signinerror.setText("INVALID EMAIL");
                        Log.d(TAG, "onClick: regex fail");
                    }

                }else {
                    signinerror.setText("EMAIL AND PASSWORD CAN NOT BE EMPTY");
                }
            }
        });


        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signin.this, signup.class));
                finish();
            }
        });
    }
}