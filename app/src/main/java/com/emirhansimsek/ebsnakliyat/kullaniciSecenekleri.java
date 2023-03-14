package com.emirhansimsek.ebsnakliyat;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class kullaniciSecenekleri extends Fragment {

    public kullaniciSecenekleri() {
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
        View view = inflater.inflate(R.layout.fragment_kullanici_secenekleri, container, false);
        Button aracBul = (Button) view.findViewById(R.id.btn_kullaniciAracBul);
        aracBul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AracBul.class);
                startActivity(intent);
            }
        });
        return view;
    }
}