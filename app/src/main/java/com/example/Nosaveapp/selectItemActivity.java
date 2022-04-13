package com.example.Nosaveapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class selectItemActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener {
    Button go;
    TextView ttle;
    Intent intent;
    Spinner selectItem;
    EditText addressOfUri;
    ArrayAdapter adapter;
    String[] AppName = {"Mail","WhatsApp","Telegram","Instagram","Youtube"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_item);

        ttle = findViewById(R.id.title);
        ttle.setText("Select Any One");
        selectItem = findViewById(R.id.selectAny);
        addressOfUri = findViewById(R.id.address);
        go = findViewById(R.id.Go);

        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,AppName);
        selectItem.setAdapter(adapter);
        go.setOnClickListener(selectItemActivity.this);
        selectItem.setOnItemSelectedListener(selectItemActivity.this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapter.getItem(i).toString().equals("WhatsApp")){
            Intent intent = new Intent(selectItemActivity.this,MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "WhatsApp", Toast.LENGTH_SHORT).show();
        }
        if (adapter.getItem(i).toString().equals("Telegram")){
            Intent intent = new Intent(selectItemActivity.this,TeleActivity.class);
            startActivity(intent);

            Toast.makeText(this, "Telegram", Toast.LENGTH_SHORT).show();
        }
        if (adapter.getItem(i).toString().equals("Instagram")){
            Intent intent = new Intent(getApplicationContext(),InstagramActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Instagram", Toast.LENGTH_SHORT).show();
        }
        if (adapter.getItem(i).toString().equals("Youtube")){
            Intent intent = new Intent(getApplicationContext(),YoutubeActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Youtube", Toast.LENGTH_SHORT).show();
        }
    }
    private void instagramRedirect() {
        intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("mailto:"+addressOfUri.getText().toString()));
        startActivity(intent);
    }
    @Override
    public void onClick(View view) {
        instagramRedirect();

    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.daynight, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.DN).setTitle(R.string.Dm);
        }else{
            menu.findItem(R.id.DN).setTitle(R.string.Nm);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.DN: int nightMode = AppCompatDelegate.getDefaultNightMode();

                if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    Toast.makeText(this, "Day Mode", Toast.LENGTH_SHORT).show();
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    Toast.makeText(this, "Night Mode", Toast.LENGTH_SHORT).show();
                }
                recreate();
                break;
            case R.id.change:Intent intent = new Intent(selectItemActivity.this,TeleActivity.class);
                startActivity(intent);

                break;

        }
        return super.onOptionsItemSelected(item);
    }


}