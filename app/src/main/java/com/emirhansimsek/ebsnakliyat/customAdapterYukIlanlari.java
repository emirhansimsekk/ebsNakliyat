package com.emirhansimsek.ebsnakliyat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class customAdapterYukIlanlari extends RecyclerView.Adapter<customAdapterYukIlanlari.myViewHolder2> {
    private ArrayList<Siparis> siparisler;
    private Context context;
    private ArrayList surucu_id;
    int position;
    dbHelper dbHelper;
    Siparis siparis;
    customAdapterYukIlanlari(Context context, ArrayList siparisler, ArrayList surucu_id){
        this.context = context;
        this.siparisler = siparisler;
        this.surucu_id = surucu_id;
        dbHelper = new dbHelper(context);
        position = 0;
    }

    @NonNull
    @Override
    public myViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.yuk_ilanlari_row,parent,false);

        return new myViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull customAdapterYukIlanlari.myViewHolder2 holder, int position) {
        siparis = siparisler.get(position);
        holder.kalkisIlce.setText(String.valueOf(siparis.getKalkisIlce()));
        holder.varisIlce.setText(String.valueOf(siparis.getVarisIlce()));
        holder.tarih.setText(String.valueOf(siparis.getTarih()));
        holder.esyaSayisi.setText(String.valueOf(siparis.getAracKapasite()));
        holder.fiyat.setText("2165");
    }

    @Override
    public int getItemCount() {
        return siparisler.size();
    }

    public class myViewHolder2 extends RecyclerView.ViewHolder {
        TextView kalkisIlce, varisIlce, esyaSayisi, tarih, fiyat;
        public myViewHolder2(@NonNull View itemView) {
            super(itemView);
            kalkisIlce = itemView.findViewById(R.id.kalkisIlce);
            varisIlce = itemView.findViewById(R.id.varisIlce);
            esyaSayisi = itemView.findViewById(R.id.esyaSayisi);
            tarih = itemView.findViewById(R.id.tarih);
            fiyat = itemView.findViewById(R.id.fiyat);
            itemView.findViewById(R.id.yoneticiKabulEt).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
