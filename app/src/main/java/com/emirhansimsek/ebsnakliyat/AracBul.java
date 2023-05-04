package com.emirhansimsek.ebsnakliyat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Year;
import java.util.Calendar;

public class AracBul extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText editText_aracBulEsyaSayisi;
    EditText editText_aracBulTarih;
    TextView textView;
    Context context;
    int aracBulEsyaSayisi;

    boolean bosAlan;
    customAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arac_bul);

        Spinner spinner_kalkisIlce = findViewById(R.id.spinner_aracBulKalkisIlce);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.surucuIlceler,R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner_kalkisIlce.setAdapter(adapter);
        spinner_kalkisIlce.setOnItemSelectedListener(this);

        Spinner spinner_varisIlce = findViewById(R.id.spinner_aracBulVarisIlce);
        spinner_varisIlce.setAdapter(adapter);
        spinner_varisIlce.setOnItemSelectedListener(this);


        editText_aracBulEsyaSayisi = findViewById(R.id.txt_aracBulKapasite);
        editText_aracBulTarih = findViewById(R.id.txt_aracBulTarih);
        context=getApplicationContext();
        aracBulEsyaSayisi=0;
        bosAlan=true;

        editText_aracBulTarih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(AracBul.this,  new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month=month+1;
                        editText_aracBulTarih.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                },year,month,dayOfMonth);
                datePickerDialog.show();
            }
        });
        findViewById(R.id.btn_aracBul).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_aracBulEsyaSayisi = editText_aracBulEsyaSayisi.getText().toString();
                String str_aracBulTarih = editText_aracBulTarih.getText().toString();
                String aracBulKalkisIlce = spinner_kalkisIlce.getSelectedItem().toString();
                String aracBulVarisIlce = spinner_varisIlce.getSelectedItem().toString();
                //dbS.createTable();

                if( (str_aracBulEsyaSayisi.isEmpty()) || (str_aracBulTarih.isEmpty()) || (aracBulKalkisIlce.isEmpty()) || (aracBulVarisIlce.isEmpty())){
                        Toast msg_null = Toast.makeText(context, "Hiçbir alanı boş bırakmayınız",Toast.LENGTH_LONG);
                        msg_null.show();
                        bosAlan=true;
                }

                else{
                        try {
                            aracBulEsyaSayisi = Integer.parseInt(str_aracBulEsyaSayisi);
                        }
                        catch (NullPointerException e){

                        }
                        bosAlan=false;
                }

                if(bosAlan==false){

                    Intent intent = new Intent(context,aracIlanlari.class);
                    intent.putExtra("kalkisIlce",aracBulKalkisIlce);
                    intent.putExtra("varisIlce",aracBulVarisIlce);
                    intent.putExtra("tarih",str_aracBulTarih);
                    intent.putExtra("esyaSayisi",str_aracBulEsyaSayisi);

                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}