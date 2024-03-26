package com.example.try2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtx;
    private Button btn;
    private TextView tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8,tx9,tx10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtx=findViewById(R.id.editTextNumber);
        btn=findViewById(R.id.button);
        tx1=findViewById(R.id.textView2);


//        no need to do this alll as it is solved by String bulder
//        tx2=findViewById(R.id.textView3);
//        tx3=findViewById(R.id.textView4);
//        tx4=findViewById(R.id.textView5);
//        tx5=findViewById(R.id.textView6);
//        tx6=findViewById(R.id.textView7);
//        tx7=findViewById(R.id.textView8);
//        tx8=findViewById(R.id.textView9);
//        tx9=findViewById(R.id.textView10);
//        tx10=findViewById(R.id.textView11);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder answer=new StringBuilder();

                for (int i = 1; i <= 10; i++) {
                    answer = answer.append(edtx.getText()).append("X").append(i).append("=").append(Integer.parseInt(edtx.getText().toString())*i).append("\n");

                    tx1.setText(answer);
                }
                Toast.makeText(MainActivity.this, "YOUR TABLE IS READY", Toast.LENGTH_SHORT).show();



//                no need to do this alll as it is solved by String bulder
//                tx1.setText(edtx.getText().toString()+"x 1 ="+1*Integer.parseInt(edtx.getText().toString()));
//                tx2.setText(edtx.getText().toString()+"x 2 ="+2*Integer.parseInt(edtx.getText().toString()));
//                tx3.setText(edtx.getText().toString()+"x 3 ="+3*Integer.parseInt(edtx.getText().toString()));
//                tx4.setText(edtx.getText().toString()+"x 4 ="+4*Integer.parseInt(edtx.getText().toString()));
//                tx5.setText(edtx.getText().toString()+"x 5 ="+5*Integer.parseInt(edtx.getText().toString()));
//                tx6.setText(edtx.getText().toString()+"x 6 ="+6*Integer.parseInt(edtx.getText().toString()));
//                tx7.setText(edtx.getText().toString()+"x 7 ="+7*Integer.parseInt(edtx.getText().toString()));
//                tx8.setText(edtx.getText().toString()+"x 8 ="+8*Integer.parseInt(edtx.getText().toString()));
//                tx9.setText(edtx.getText().toString()+"x 9 ="+9*Integer.parseInt(edtx.getText().toString()));
//                tx10.setText(edtx.getText().toString()+"x 10 ="+10*Integer.parseInt(edtx.getText().toString()));

            }
        });



    }
}