package com.example.yaxar.rentsplit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle = getIntent().getExtras();
        Intent intent=getIntent();
        String userName=intent.getStringExtra("user");
        Context context = getApplicationContext();
        CharSequence text = "Welcome"+userName+"!";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();

    }
}
