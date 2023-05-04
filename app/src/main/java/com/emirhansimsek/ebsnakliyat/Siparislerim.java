package com.emirhansimsek.ebsnakliyat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class Siparislerim extends AppCompatActivity {
    RecyclerView recyclerView;
    Siparis siparis;
    Surucu surucu;
    dbHelper dbHelper;
    customAdapterSiparislerim customAdap;
    customAdapter customAdap2;
    ArrayList<Siparis> siparisler;
    ArrayList<Surucu> suruculer;
    ArrayList<Integer> siparis_id;
    ArrayList<Integer> surucu_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siparislerim);

        dbHelper = new dbHelper(Siparislerim.this);
        recyclerView = findViewById(R.id.recyclerViewSiparislerim);
        siparis_id = new ArrayList<>();
        siparisler = new ArrayList<>();
        customAdap = new customAdapterSiparislerim(Siparislerim.this);
        //customAdap2 = new customAdapter(siparis_id,"kadıköy");
        recyclerView.setAdapter(customAdap);
        recyclerView.setLayoutManager(new LinearLayoutManager(Siparislerim.this));
        storeData();
        //Log.v(" ", String.valueOf(siparisler.get(1).getSiparisDurum()));
    }


    void storeData(){
        Cursor cursor = dbHelper.readDataSiparis();
        while (cursor.moveToNext()){
            siparis = new Siparis(cursor.getString(1),cursor.getString(2), cursor.getString(3)
                    ,cursor.getInt(4),cursor.getInt(5), cursor.getInt(6), cursor.getInt(7));
            siparisler.add(siparis);
            siparis_id.add(cursor.getInt(0));

        }
    }
    void storeDataSurucu(){
        Cursor cursor = dbHelper.readData();
        while(cursor.moveToNext()){
            surucu = new Surucu(cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4),
                    cursor.getString(5));
            suruculer.add(surucu);
            surucu_id.add(cursor.getInt(0));
        }
    }
}