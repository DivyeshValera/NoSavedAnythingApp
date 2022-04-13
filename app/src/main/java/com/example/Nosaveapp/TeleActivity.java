package com.example.Nosaveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TeleActivity extends AppCompatActivity {
    TextView dev,name;
    EditText number;
    Button go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tele);
        TextView title = findViewById(R.id.title);
        title.setText("Write Channel name and go on Telegram");


        dev = findViewById(R.id.dev);
        name = findViewById(R.id.name);
        number = findViewById(R.id.num);
        go = findViewById(R.id.telego);

        dev.setText("Developed by");
        name.setText("Divyesh V.");

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https:/t.me/"+number.getText().toString()));
                startActivity(intent);
                Toast.makeText(TeleActivity.this, number.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}