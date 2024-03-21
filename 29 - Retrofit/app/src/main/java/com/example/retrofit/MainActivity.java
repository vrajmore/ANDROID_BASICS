package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text =findViewById(R.id.textView);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderapi jsonPlaceHolderapi = retrofit.create(JsonPlaceHolderapi.class);
        Call<List<Post>> call = jsonPlaceHolderapi.getpost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()){
                    text.setText("code "+ response.code());
                    return;
                }
                List<Post> posts = response.body();

                for (Post post: posts){
                    String content = "";
                    content += "ID"+ post.getId()+ "\n";
                    content += "User ID"+ post.getUserId()+ "\n";
                    content += "Title"+ post.getTitle()+ "\n";
                    content += "TEXT"+ post.getText()+ "\n\n";

                    text.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                text.setText(t.getMessage());
            }
        });

    }
}