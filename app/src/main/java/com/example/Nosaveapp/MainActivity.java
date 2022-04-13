package com.example.Nosaveapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView dev,name;
    EditText code,number;
    Button send;
    String codeNum = "+91";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dev = findViewById(R.id.dev);
        name = findViewById(R.id.name);
        code = findViewById(R.id.code);
        number = findViewById(R.id.num);
        send = findViewById(R.id.telego);

        dev.setText(R.string.createdby);
        name.setText(R.string.Devname);
        
        code.setText(codeNum);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(codeNum.equals("+91")){
                    if(number.length() == 10) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://wa.me/"+codeNum+number.getText().toString()));
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, codeNum+number.getText().toString(), Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Number must be 10 digit", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }



}