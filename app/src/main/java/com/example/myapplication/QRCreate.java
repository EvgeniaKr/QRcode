package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class QRCreate extends AppCompatActivity {


    Button button_createQR;
    EditText edit_text_link;
    Bitmap bitmap;

    ImageView image_qr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcreate);
        button_createQR = findViewById(R.id.button_createQR);
        edit_text_link = findViewById(R.id.edit_text_link);
        image_qr = findViewById(R.id.image_qr);

        button_createQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String qrcode = edit_text_link.getText().toString();


                // generating dimension from width and height.

                 int dimen = 100;

                QRGEncoder qrgEncoder = new QRGEncoder(qrcode, null, QRGContents.Type.TEXT, dimen);
                qrgEncoder.setColorBlack(Color.WHITE);
                qrgEncoder.setColorWhite(Color.BLACK);
                try {
                    // Getting QR-Code as Bitmap
                    bitmap = qrgEncoder.getBitmap();
                    // Setting Bitmap to ImageView
                    image_qr.setImageBitmap(bitmap);
                } catch (Exception ex) {
                    Toast.makeText(QRCreate.this, "Enter some text to generate QR Code", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }
}