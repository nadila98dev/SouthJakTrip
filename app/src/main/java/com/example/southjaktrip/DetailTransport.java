package com.example.southjaktrip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.southjaktrip.Transportasi.EXTRA_ADD;
import static com.example.southjaktrip.Transportasi.EXTRA_DESC;
import static com.example.southjaktrip.Transportasi.EXTRA_IMG;
import static com.example.southjaktrip.Transportasi.EXTRA_JUDUL;
import static com.example.southjaktrip.Transportasi.EXTRA_LINK;
import static com.example.southjaktrip.Wisata.EXTRA_TYPE;

public class DetailTransport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_transport);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);



        final Intent intent = getIntent();
        final String judul = intent.getStringExtra(EXTRA_JUDUL);
        String imagev = intent.getStringExtra(EXTRA_IMG);
        String alamat = intent.getStringExtra(EXTRA_ADD);
        String link = intent.getStringExtra(EXTRA_LINK);
        String desc = intent.getStringExtra(EXTRA_DESC);
        String typeplace = intent.getStringExtra(EXTRA_TYPE);

        final TextView textViewTitle = findViewById(R.id.title_detailtrans);
        ImageView imageView = findViewById(R.id.img_detailtrans);
        TextView textViewLink = findViewById(R.id.link_detailtrans);
        TextView textViewDesc = findViewById(R.id.desc_detailtrans);
        TextView textViewAdd = findViewById(R.id.text_addresstrans);
        TextView textViewType = findViewById(R.id.tvTypeTrans);

        textViewTitle.setText(judul);
        textViewAdd.setText(alamat);
        textViewLink.setText(link);
        textViewDesc.setText(desc);
        textViewType.setText(typeplace);
        Picasso.get().load(imagev).into(imageView);

        Button btnrate = (Button) findViewById(R.id.btn_rate);
        btnrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent( DetailTransport.this, Rating.class);
                intent1.putExtra(EXTRA_JUDUL,judul);
                startActivity(intent1);
            }
        });

    }
}
