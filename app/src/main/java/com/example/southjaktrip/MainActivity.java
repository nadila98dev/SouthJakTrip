package com.example.southjaktrip;


import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class MainActivity extends AppCompatActivity {

    MediaPlayer audioBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        audioBackground = MediaPlayer.create(this, R.raw.ondel_ondel);

        audioBackground.setLooping(true);

        audioBackground.setVolume(30,30);

        audioBackground.start();


        Button btnwisata = (Button) findViewById(R.id.btnwisata);
        Button btntransport = (Button) findViewById(R.id.btntransport);
        Button btnlogin = (Button) findViewById(R.id.loginbtn_logo);
        Button btnregister = (Button) findViewById(R.id.registerbtn_logo);
        Button btnabout = (Button) findViewById(R.id.about_button);
        btnwisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(MainActivity.this, Wisata.class);
                startActivity(int2);
            }
        });
        btntransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int4 = new Intent(MainActivity.this, Transportasi.class);
                startActivity(int4);
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int5 = new Intent(MainActivity.this, Login.class);
                startActivity(int5);

            }
        });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int6 = new Intent(MainActivity.this, Register.class);
                startActivity(int6);
            }
        });
        btnabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int7 = new Intent(MainActivity.this, About.class);
                startActivity(int7);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
