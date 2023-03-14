package com.emirhansimsek.ebsnakliyat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class suruculer extends AppCompatActivity {
    RecyclerView recyclerView;

    dbHelper dbHelper;
    /*ArrayList<String> surucu_isim, surucu_soyisim, surucu_ilce;
    ArrayList<Integer> arac_kapasite , surucu_telefon, */
    ArrayList<Integer> surucu_id;
    customAdapterSuruculer customAdap;
    ArrayList<Surucu> suruculer;
    Surucu surucu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suruculer);

        dbHelper = new dbHelper(suruculer.this);
        recyclerView = findViewById(R.id.recyclerViewSuruculer);
        /*surucu_isim = new ArrayList<>();
        surucu_soyisim = new ArrayList<>();
        surucu_telefon = new ArrayList<>();
        arac_kapasite = new ArrayList<>();
        surucu_ilce = new ArrayList<>();*/
        surucu_id = new ArrayList<>();
        suruculer = new ArrayList<>();
        //customAdap = new customAdapterSuruculer(suruculer.this, surucu_id, surucu_isim, surucu_soyisim, surucu_ilce, arac_kapasite, surucu_telefon);
        customAdap = new customAdapterSuruculer(suruculer.this,suruculer,surucu_id);
        recyclerView.setAdapter(customAdap);
        recyclerView.setLayoutManager(new LinearLayoutManager(suruculer.this));
        storeData();

    }


        void storeData(){
            Cursor cursor = dbHelper.readData();
            while(cursor.moveToNext()){
                surucu = new Surucu(cursor.getString(1),cursor.getString(2),cursor.getInt(3)
                        ,cursor.getInt(4),cursor.getString(5));
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