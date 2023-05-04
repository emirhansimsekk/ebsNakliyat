package com.emirhansimsek.ebsnakliyat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SurucuEkle extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText editText_surucuAdi;
    EditText editText_surucuSoyadi;
    EditText editText_surucuTelefonu;
    EditText editText_kapasite;
    Context context;
    ArrayList<Surucu> suruculer = new ArrayList<Surucu>();
    int sayac=0;
    int surucuTelefon;
    int aracKapasite;
    boolean bosAlan;
    SQLiteDatabase surucuDB;
    ContentValues contentValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surucu_ekle);
        Spinner spinner_surucuIlce=findViewById(R.id.spinner_surucuIlce);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.surucuIlceler, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner_surucuIlce.setAdapter(adapter);
        spinner_surucuIlce.setOnItemSelectedListener(this);


        editText_surucuAdi = findViewById(R.id.txt_surucuAdi);
        editText_surucuSoyadi = findViewById(R.id.txt_surucuSoyadi);
        editText_surucuTelefonu = findViewById(R.id.txt_surucuTelefonu);
        editText_kapasite = findViewById(R.id.txt_kapasite);
        context = getApplicationContext();
        aracKapasite=0;
        surucuTelefon=0;
        bosAlan = true;
        dbHelper dBhelper = new dbHelper(context);


        findViewById(R.id.btn_surucuEkle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String surucuAdi = editText_surucuAdi.getText().toString().replaceAll("\\s","");
                String surucuSoyadi = editText_surucuSoyadi.getText().toString().replaceAll("\\s","");
                String strSurucuTelefonu = editText_surucuTelefonu.getText().toString();
                String strAracKapasite = editText_kapasite.getText().toString();
                String surucuIlce = spinner_surucuIlce.getSelectedItem().toString();


                if ( (strSurucuTelefonu.isEmpty()) || (strAracKapasite.isEmpty()) || surucuAdi.isEmpty() || surucuSoyadi.isEmpty() || surucuIlce.equals("İlçe Seçiniz...")) {
                    Toast msg_null = Toast.makeText(context, "Hiçbir alanı boş bırakmayınız", Toast.LENGTH_LONG);
                    msg_null.show();
                    bosAlan = true;
                    Log.v("if: ",(String)strSurucuTelefonu+strAracKapasite+surucuAdi+surucuSoyadi+surucuIlce);

                }

                else {
                    try {
                        surucuTelefon = Integer.parseInt(strSurucuTelefonu);
                        aracKapasite = Integer.parseInt(strAracKapasite);
                    } catch (NumberFormatException e) {

                    }
                    bosAlan = false;
                }


                if (bosAlan == false) {

                    /*surucuAdi = surucuAdi.replaceAll("//s","");
                    surucuSoyadi = surucuSoyadi.replaceAll("//s","");*/


                    if ((!Pattern.matches("[a-zA-Z]+", surucuAdi) ||
                            !Pattern.matches("[a-zA-Z]+", surucuSoyadi))
                    ) {
                        Toast msg_toast = Toast.makeText(context, "Yanlış Bilgi Girdiniz, Lütfen Tekrar Deneyiniz", Toast.LENGTH_LONG);
                        msg_toast.show();

                    } /*else {
                        Surucu suruculer = new Surucu(surucuAdi, surucuSoyadi, surucuTelefon, aracKapasite, surucuIlce);

                        dBhelper.surucuEkle(suruculer.getSurucuIsim(),suruculer.getSurucuSoyisim(),suruculer.getSurucuTelefon(),
                                suruculer.getAracKapasite(),suruculer.getSurucuIlce());

                        Toast msg_toast = Toast.makeText(context, "Sürücü Başarıyla Eklendi", Toast.LENGTH_LONG);
                        msg_toast.show();
                    }*/
                    else {
                        Surucu suruculer = new Surucu(surucuAdi, surucuSoyadi, surucuTelefon, aracKapasite, surucuIlce);

                        dBhelper.surucuEkle(suruculer);

                        Toast msg_toast = Toast.makeText(context, "Sürücü Başarıyla Eklendi", Toast.LENGTH_LONG);
                        msg_toast.show();
                        editText_surucuAdi.setText("");
                        editText_surucuSoyadi.setText("");
                        editText_kapasite.setText("");
                        editText_surucuTelefonu.setText("");
                        spinner_surucuIlce.setSelection(0);

                    }
                }

            }

        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.v("item",(String)parent.getItemAtPosition(position));

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }




}