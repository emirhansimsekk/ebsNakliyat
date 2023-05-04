package com.emirhansimsek.ebsnakliyat;



import static java.lang.Integer.parseInt;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class customAdapter extends RecyclerView.Adapter<customAdapter.myViewHolder> {
    private ArrayList<Surucu> suruculer;
    private Context context;
    private ArrayList  surucu_isim, surucu_soyisim, surucu_ilce,arac_kapasite , surucu_telefon;
    private ArrayList<Integer> surucu_id;
    private ArrayList<Integer> siparis_id;
    int position;
    dbHelper dBhelper;
    Surucu surucu;
    Siparis siparis;
    String varis;

    String kalkisIlce, varisIlce, tarih;
    int esyaSayisi;
    customAdapter(Context context, ArrayList suruculer, ArrayList surucu_id,String kalkisIlce, String varisIlce, String tarih, int esyaSayisi){

        this.context = context;
        this.suruculer = suruculer;
        this.surucu_id = surucu_id;
        dBhelper = new dbHelper(context);
        this.varisIlce=varisIlce;
        this.kalkisIlce=kalkisIlce;
        this.tarih= tarih;
        this.esyaSayisi = esyaSayisi;
        position = 0;

    }




    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.arac_ilanlari_row,parent,false);
        /*Bundle extras = getIntent().getExtras();
        if(extras!=null){
            kalkisIlce=extras.getString("aracBul_kalkisIlce");
            varisIlce = extras.getString("aracBul_varisIlce");

        }*/

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull customAdapter.myViewHolder holder, int position) {
        /*holder.isim.setText( String.valueOf(surucu_isim.get(position)) +" " + String.valueOf(surucu_soyisim.get(position)));
        holder.kapasite.setText( String.valueOf(arac_kapasite.get(position)));
        holder.telefon.setText( String.valueOf(surucu_telefon.get(position)));*/

        surucu = suruculer.get(position);
        holder.isim.setText( String.valueOf(surucu.getSurucuIsim()) +" " + String.valueOf(surucu.getSurucuSoyisim()));
        holder.kapasite.setText( String.valueOf(surucu.getAracKapasite()));
        holder.telefon.setText( String.valueOf(surucu.getSurucuTelefon()));

    }

    @Override
    public int getItemCount() {
        return suruculer.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView isim, soyisim, kapasite, telefon;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            isim = itemView.findViewById(R.id.isim1);
            kapasite = itemView.findViewById(R.id.kapasite1);
            telefon = itemView.findViewById(R.id.telefon1);
            itemView.findViewById(R.id.teklif_iste).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        position=parseInt(String.valueOf(getAdapterPosition()));
                    }
                    catch (NullPointerException e){

                    }

                    surucu = suruculer.get(position);
                    siparis = new Siparis(kalkisIlce,varisIlce, tarih, esyaSayisi,
                            0,0,surucu_id.get(position));;

                    dBhelper.siparisEkle(siparis);
                    String toast=String.valueOf(position);
                    itemView.findViewById(R.id.teklif_iste).setEnabled(false);

                }

            });

        }
    }
}
