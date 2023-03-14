package com.emirhansimsek.ebsnakliyat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class anaSayfa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);

        findViewById(R.id.btn_yoneticiGirisi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.btn_yoneticiGirisi).setEnabled(false);
                findViewById(R.id.btn_kullaniciGirisi).setEnabled(true);
                findViewById(R.id.btn_Cikis).setVisibility(View.VISIBLE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.linearLayout_anaSayfa, yoneticiSecenekleri.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // name can be null
                        .commit();


            }
        });
        findViewById(R.id.btn_kullaniciGirisi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.btn_yoneticiGirisi).setEnabled(true);
                findViewById(R.id.btn_kullaniciGirisi).setEnabled(false);
                findViewById(R.id.btn_Cikis).setVisibility(View.VISIBLE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.linearLayout_anaSayfa, kullaniciSecenekleri.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // name can be null
                        .commit();
            }
        });

        findViewById(R.id.btn_Cikis).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.linearLayout_anaSayfa);
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                findViewById(R.id.btn_yoneticiGirisi).setEnabled(true);
                findViewById(R.id.btn_kullaniciGirisi).setEnabled(true);
                findViewById(R.id.btn_Cikis).setVisibility(View.INVISIBLE);
            }
        });
    }
}