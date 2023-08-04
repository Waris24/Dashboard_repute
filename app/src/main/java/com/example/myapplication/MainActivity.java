package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button  button2, button3, button4;
    private ImageButton button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        // Set click listeners for the buttons
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                launchDataActivity("http://dms.reptest.in/WebApi/Inbound_CNo");
                break;
            case R.id.button2:
                launchDataActivity("http://dms.reptest.in/Login/User_login?username=dmsdel&password=del123");
                break;
            case R.id.button3:
                launchDataActivity("http://dms.reptest.in/WebApi/Inbound_CNo");
                break;
            case R.id.button4:
                launchDataActivity("http://dms.reptest.in/WebApi/Inbound_CNo");
                break;
        }
    }

    private void launchDataActivity(String apiUrl) {
        Intent intent = new Intent(MainActivity.this, DisplayDataActivity.class);
        intent.putExtra("apiUrl", apiUrl);
        startActivity(intent);
    }
}
