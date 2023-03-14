package com.emirhansimsek.ebsnakliyat;

import static java.lang.Integer.parseInt;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class customAdapterSuruculer extends RecyclerView.Adapter<customAdapterSuruculer.myViewHolder1>  {
    private  ArrayList<Surucu> suruculer;
    private Context context;
    private ArrayList surucu_id, surucu_isim, surucu_soyisim, surucu_ilce,arac_kapasite , surucu_telefon;
    int position;
    dbHelper dBhelper;
    Surucu surucu;
    customAdapterSuruculer customAdapSuruculer;



  /*  customAdapterSuruculer(Context context,ArrayList surucu_id,
                           ArrayList surucu_isim,
                           ArrayList surucu_soyisim,
                           ArrayList surucu_ilce,
                           ArrayList arac_kapasite, ArrayList surucu_telefon){
        this.context = context;
        this.surucu_id = surucu_id;
        this.surucu_isim = surucu_isim;
        this.surucu_soyisim = surucu_soyisim;
        this.surucu_ilce = surucu_ilce;
        this.arac_kapasite = arac_kapasite;
        this.surucu_telefon = surucu_telefon;
        dBhelper=new dbHelper(context);
        position=0;

    }*/
    customAdapterSuruculer(Context context, ArrayList suruculer,ArrayList surucu_id){
        this.context = context;
        this.surucu_id = surucu_id;
        this.suruculer = suruculer;
        dBhelper = new dbHelper(context);
        position = 0;
    }

    @NonNull
    @Override
    public myViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.suruculer_row,parent,false);

        return new myViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull customAdapterSuruculer.myViewHolder1 holder, int position) {
       /* holder.isim.setText(String.valueOf(surucu_isim.get(position)) +" " + String.valueOf(surucu_soyisim.get(position)));
        holder.kapasite.setText( String.valueOf(arac_kapasite.get(position)));
        holder.telefon.setText( String.valueOf(surucu_telefon.get(position)));
        holder.ilce.setText(String.valueOf(surucu_ilce.get(position)));*/
           surucu = suruculer.get(position);
           holder.isim.setText(String.valueOf(surucu.getSurucuIsim()) + " " + String.valueOf(surucu.getSurucuSoyisim()));
           holder.kapasite.setText(String.valueOf(surucu.getAracKapasite()));
           holder.telefon.setText(String.valueOf(surucu.getSurucuTelefon()));
           holder.ilce.setText(String.valueOf(surucu.getSurucuIlce()));


    }

    @Override
    public int getItemCount() {
        return suruculer.size();
    }

    public class myViewHolder1 extends RecyclerView.ViewHolder {
        TextView isim, soyisim, kapasite, telefon,ilce;

        public myViewHolder1(@NonNull View itemView) {
            super(itemView);
            isim=itemView.findViewById(R.id.isim1);
            kapasite=itemView.findViewById(R.id.kapasite1);
            telefon=itemView.findViewById(R.id.telefon1);
            ilce=itemView.findViewById(R.id.ilce1);
            itemView.findViewById(R.id.surucu_sil).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        position=parseInt(String.valueOf(surucu_id.get(getAdapterPosition())));
                    }
                    catch (NullPointerException e){

                    }

                    dBhelper.delete(String.valueOf(position));
                    suruculer.remove(getAdapterPosition());
                    notifyDataSetChanged();
                    notifyItemRemoved(getAdapterPosition());
                }
            });
        }
    }
}
