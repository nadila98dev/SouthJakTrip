package com.example.southjaktrip;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Transportasi extends AppCompatActivity implements ExampleAdapter.OnItemClickLiListener {

    public static final String EXTRA_JUDUL = "judul";
    public static final String EXTRA_IMG = "imagev";
    public static final String EXTRA_ADD = "alamat";
    public static final String EXTRA_LINK = "link";
    public static final String EXTRA_DESC = "desc";
    public static final String EXTRA_TYPE = "typeplace";

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<ExampleItem> list;
    ExampleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportasi);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        recyclerView = (RecyclerView) findViewById(R.id.reyclerview3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<ExampleItem>();

        reference = FirebaseDatabase.getInstance().getReference().child("Transportasi");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    ExampleItem iw = dataSnapshot1.getValue(ExampleItem.class);
                    list.add(iw);
                }
                adapter = new ExampleAdapter(Transportasi.this, list);
                recyclerView.setAdapter(adapter);
                adapter.setOnItemClickListener(Transportasi.this);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Transportasi.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, DetailTransport.class);
        ExampleItem clickedItem = list.get(position);
        detailIntent.putExtra(EXTRA_IMG, clickedItem.getImagev());
        detailIntent.putExtra(EXTRA_JUDUL, clickedItem.getJudul());
        detailIntent.putExtra(EXTRA_ADD, clickedItem.getAlamat());
        detailIntent.putExtra(EXTRA_LINK, clickedItem.getLink());
        detailIntent.putExtra(EXTRA_DESC, clickedItem.getDesc());
        detailIntent.putExtra(EXTRA_TYPE, clickedItem.getTypeplace());

        startActivity(detailIntent);
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
