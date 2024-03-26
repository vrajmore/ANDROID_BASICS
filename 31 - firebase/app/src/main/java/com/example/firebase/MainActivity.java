package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebase.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseDatabase database;
    DatabaseReference reference;

    private TextView fname, lname, age, userid, outputtext;
    private Button submit, refresh;

    List<Users> dataList = new ArrayList<Users>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        age = findViewById(R.id.age);
        userid = findViewById(R.id.userid);
        submit = findViewById(R.id.button);
        refresh = findViewById(R.id.button2);
        outputtext = findViewById(R.id.outputtext);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!fname.getText().toString().isEmpty() &&
                        !lname.getText().toString().isEmpty() &&
                        !age.getText().toString().isEmpty() &&
                        !userid.getText().toString().isEmpty()){

                    Users users = new Users(fname.getText().toString(), lname.getText().toString(), Integer.parseInt(age.getText().toString()), userid.getText().toString());
                    database = FirebaseDatabase.getInstance();
                    reference = database.getReference("entered data");
                    reference.child(userid.getText().toString())
                            .setValue(users)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    fname.setText("");
                                    lname.setText("");
                                    age.setText("");
                                    userid.setText("");
                                    Toast.makeText(MainActivity.this, "DATA ADDED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });





        database = FirebaseDatabase.getInstance();
        reference = database.getReference("entered data");



        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                dataList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Users users1 = dataSnapshot.getValue(Users.class);
                    dataList.add(users1);
                }
                refresh.callOnClick();

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder output = new StringBuilder();
                output.setLength(0);
                for (int i = 0; i < dataList.size(); i++) {
                    output.append("NAME:- ")
                            .append(dataList.get(i).firstname+" ")

                            .append(dataList.get(i).lastname+"\n")
                            .append(" AGE: ")
                            .append(dataList.get(i).age+"\n")
                            .append(" ID: ")
                            .append(dataList.get(i).userid)
                            .append("\n\n");

                }
                outputtext.setText(output);

            }
        });
    }

}
