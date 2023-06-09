package com.emirhansimsek.ebsnakliyat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class aracIlanlari extends AppCompatActivity {

    RecyclerView recyclerView;

    dbHelper dbHelper;
    ArrayList<String> surucu_isim, surucu_soyisim, surucu_ilce;
    ArrayList<Integer> arac_kapasite , surucu_telefon, surucu_id;
    String kalkisIlce, varisIlce,tarih,str_esyaSayisi;
    int esyaSayisi;
    customAdapter customAdap;
    customAdapter customAdap1;
    ArrayList<Surucu> suruculer;
    Surucu surucu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arac_ilanlari);
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            kalkisIlce=extras.getString("kalkisIlce");
            varisIlce = extras.getString("varisIlce");
            tarih = extras.getString("tarih");
            str_esyaSayisi = extras.getString("esyaSayisi");
            if(str_esyaSayisi!=null){
                esyaSayisi = Integer.parseInt(str_esyaSayisi);
            }
            else{
                esyaSayisi=0;
            }


        }

        dbHelper = new dbHelper(aracIlanlari.this);
        recyclerView = findViewById(R.id.recyclerView);
        surucu_id = new ArrayList<>();
        suruculer = new ArrayList<>();
        surucu_isim = new ArrayList<>();
        surucu_soyisim = new ArrayList<>();
        surucu_telefon = new ArrayList<>();
        arac_kapasite = new ArrayList<>();
        surucu_ilce = new ArrayList<>();
        customAdap = new customAdapter(aracIlanlari.this, suruculer, surucu_id,kalkisIlce,varisIlce,tarih,esyaSayisi);
        recyclerView.setAdapter(customAdap);
        recyclerView.setLayoutManager(new LinearLayoutManager(aracIlanlari.this));
        storeData();
    }

    void storeData(){
        Cursor cursor = dbHelper.readData(kalkisIlce);
        while(cursor.moveToNext()){
            surucu = new Surucu(cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4),
                                cursor.getString(5));
            suruculer.add(surucu);
            surucu_id.add(cursor.getInt(0));
            /*surucu_isim.add(cursor.getString(1));
            surucu_soyisim.add(cursor.getString(2));
            surucu_telefon.add(cursor.getInt(3));
            arac_kapasite.add(cursor.getInt(4));
            surucu_ilce.add(cursor.getString(5));*/
        }
    }

}