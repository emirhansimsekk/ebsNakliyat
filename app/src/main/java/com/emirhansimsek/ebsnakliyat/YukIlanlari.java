package com.emirhansimsek.ebsnakliyat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class YukIlanlari extends AppCompatActivity {
    RecyclerView recyclerView;
    dbHelper dbHelper;
    ArrayList<Integer> siparis_id;
    customAdapterYukIlanlari customAdap;
    ArrayList<Siparis> siparisler;
    Siparis siparis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuk_ilanlari);


        dbHelper = new dbHelper(YukIlanlari.this);
        recyclerView = findViewById(R.id.recyclerViewYukIlanlari);
        siparis_id = new ArrayList<>();
        siparisler = new ArrayList<>();
        customAdap = new customAdapterYukIlanlari(YukIlanlari.this,siparisler,siparis_id);
        recyclerView.setAdapter(customAdap);
        recyclerView.setLayoutManager(new LinearLayoutManager(YukIlanlari.this));
        storeData();

    }

    void storeData(){
        Cursor cursor = dbHelper.readDataSiparis();
        while (cursor.moveToNext()){
            siparis = new Siparis(cursor.getString(1),cursor.getString(2), cursor.getString(3)
                    ,cursor.getInt(4),cursor.getInt(5), cursor.getInt(6));
            siparisler.add(siparis);
            siparis_id.add(cursor.getInt(0));

        }
    }
}