package com.example.myapplication;

import static com.example.myapplication.ScanQR.LinkQR;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class ScanOpen extends AppCompatActivity {

    EditText link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_open);
        link = findViewById(R.id.editText_link);
        link.setText(LinkQR);
    }
}