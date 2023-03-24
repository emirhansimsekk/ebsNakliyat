package com.emirhansimsek.ebsnakliyat;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class customAdapterSiparislerim extends RecyclerView.Adapter<customAdapterSiparislerim.myViewHolder3> {
    private ArrayList<Siparis> siparisler;
    private Context context;
    private ArrayList siparis_id, surucu_id;
    private ArrayList<Surucu> suruculer2;
    private ArrayList<Surucu> suruculer1;
    int position;
    dbHelper dbHelper;
    Siparis siparis;
    Surucu surucu;
    Surucu surucu1;

    customAdapterSiparislerim(Context context){
        this.context = context;
        siparisler = new ArrayList<>();
        siparis_id = new ArrayList();
        dbHelper = new dbHelper(context);
        suruculer2 = new ArrayList();
        //storeDataSurucu();
        storeDataSiparis();
    }


    @NonNull
    @Override
    public customAdapterSiparislerim.myViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.siparislerim_row,parent,false);

        return new myViewHolder3(view);
    }

    @Override
    public void onBindViewHolder(@NonNull customAdapterSiparislerim.myViewHolder3 holder, int position) {
        //siparis = siparisler.get(position);
        Cursor cursor = dbHelper.readData();
        while(cursor.moveToNext()){
            surucu = new Surucu(cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4),
                    cursor.getString(5));
            suruculer2.add(surucu);
        }

        holder.surucu_isim.setText(suruculer2.get(position).getSurucuIsim()+" "+suruculer2.get(position).getSurucuSoyisim());
        holder.kalkisIlce.setText(siparisler.get(position).getKalkisIlce());
        holder.varisIlce.setText(siparisler.get(position).getVarisIlce());
        holder.surucu_telefon.setText(String.valueOf(suruculer2.get(position).getSurucuTelefon()));
        holder.tarih.setText(siparis.getTarih());

            if (siparisler.get(position).getSiparisDurum() == 0) {
                holder.siparis_durum.setText("Onay Bekliyor");
                //holder.odeme_buton.setEnabled(false);
            } else {
                holder.siparis_durum.setText("Kabul Edildi");
                //holder.odeme_buton.setEnabled(true);
            }
        //holder.surucu_isim.setText(surucu.getSurucuIsim());


    }

    void storeDataSurucu(){
        Cursor cursor = dbHelper.readData();
        while(cursor.moveToNext()){
            surucu = new Surucu(cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4),
                    cursor.getString(5));
            suruculer2.add(surucu);
        }
    }


    void storeDataSiparis(){
        Cursor cursor = dbHelper.readDataSiparis();
        while (cursor.moveToNext()){
            siparis = new Siparis(cursor.getString(1),cursor.getString(2), cursor.getString(3)
                    ,cursor.getInt(4),cursor.getInt(5), cursor.getInt(6), cursor.getInt(7));
            siparisler.add(siparis);
            siparis_id.add(cursor.getInt(0));

        }
    }

    @Override
    public int getItemCount() {
        return siparisler.size();
    }


    public class myViewHolder3 extends RecyclerView.ViewHolder {
        TextView kalkisIlce, varisIlce, surucu_isim,surucu_telefon, tarih, siparis_durum,odeme_buton;
        public myViewHolder3(@NonNull View itemView) {
            super(itemView);
            kalkisIlce = itemView.findViewById(R.id.kalkisIlce);
            varisIlce = itemView.findViewById(R.id.varisIlce);
            surucu_isim = itemView.findViewById(R.id.surucu_isim);
            surucu_telefon = itemView.findViewById(R.id.surucu_telefon);
            tarih = itemView.findViewById(R.id.tarih);
            siparis_durum = itemView.findViewById(R.id.siparis_durum);
            /*odeme_buton = itemView.findViewById(R.id.odeme_buton);
            itemView.findViewById(R.id.odeme_buton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });*/
        }
    }
}
