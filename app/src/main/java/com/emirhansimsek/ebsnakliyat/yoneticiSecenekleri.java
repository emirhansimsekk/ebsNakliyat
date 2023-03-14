package com.emirhansimsek.ebsnakliyat;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class yoneticiSecenekleri extends Fragment  {



    public yoneticiSecenekleri() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_yonetici_secenekleri,container,false);
        Button surucuEkle = (Button) view.findViewById(R.id.btn_surucuEkleEkrani);
        surucuEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),SurucuEkle.class);
                startActivity(intent);
            }
        });

        Button surucuSil = (Button) view.findViewById(R.id.btn_surucuSilEkrani);
        surucuSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),suruculer.class);
                startActivity(intent);
            }
        });

        Button yukIlanlari = (Button) view.findViewById(R.id.btn_ilanlariGorEkrani);
        yukIlanlari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),YukIlanlari.class);
                startActivity(intent);
            }
        });

  return view;
    }


}