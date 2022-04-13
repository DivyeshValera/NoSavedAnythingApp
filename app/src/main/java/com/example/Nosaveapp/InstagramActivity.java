package com.example.Nosaveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class InstagramActivity extends AppCompatActivity implements View.OnClickListener {
Intent intent;
EditText instaAddress;
Button iGo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);

        instaAddress = findViewById(R.id.iaddress);
        iGo = findViewById(R.id.igo);

        iGo.setOnClickListener(InstagramActivity.this);

    }
    private void instagramRedirect() {
        intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.instagram.com/"+instaAddress.getText().toString()));
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        instagramRedirect();

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}