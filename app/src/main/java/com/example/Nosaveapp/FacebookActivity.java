package com.example.Nosaveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FacebookActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intent;
    EditText YAddress;
    Button YGo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);

        YAddress = findViewById(R.id.yaddress);

        YGo = findViewById(R.id.ygo);

        YGo.setOnClickListener(FacebookActivity.this);

    }
    private void YoutubeRedirect() {
        intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.facebook.com/"+YAddress.getText().toString()));
        startActivity(intent);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ygo:YoutubeRedirect();
            break;
        }
    }

}