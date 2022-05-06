package com.example.Nosaveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TwitterActivity extends AppCompatActivity {
    Intent intent;
    EditText TwAddress;
    Button TwGo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);

        TwAddress = findViewById(R.id.Twadd);
        TwGo = findViewById(R.id.Twgo);

        TwGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://mobile.twitter.com/"+TwAddress.getText().toString()));
                startActivity(intent);
                Toast.makeText(TwitterActivity.this, "Go", Toast.LENGTH_SHORT).show();
            }
        });
    }
}