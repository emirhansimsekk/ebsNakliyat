package com.emirhansimsek.ebsnakliyat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class dbHelper extends SQLiteOpenHelper {
    private Context context;
    // Database Version
    private static int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "ebsNakliyatDB.db";//database adı

    private static final String TABLE_NAME = "SURUCU_DB";
    private static String SURUCU_ID = "SURUCU_ID";
    private static String SURUCU_ISIM = "SURUCU_ISIM";
    private static String SURUCU_SOYISIM = "SURUCU_SOYISIM";
    private static String SURUCU_TELEFON = "SURUCU_TELEFON";
    private static String ARAC_KAPASITE = "ARAC_KAPASITE";
    private static String SURUCU_ILCE = "SURUCU_ILCE";



    private static final String TABLE_NAME1 = "SIPARIS_DB";
    private static String SIPARIS_ID = "SIPARIS_ID";
    private static String SIPARIS_KALKIS_ILCE = "SIPARIS_KALKIS_ILCE";
    private static String SIPARIS_VARIS_ILCE = "SIPARIS_VARIS_ILCE";
    private static String ESYA_SAYISI = "ESYA_SAYISI";
    private static String SIPARIS_TARIH = "SIPARIS_TARIH";
    private static String SIPARIS_DURUM = "SIPARIS_DURUM";
    private  static String ODEME_DURUM  = "ODEME_DURUM";




    public dbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String createTable = "CREATE TABLE " + TABLE_NAME + "("
                + SURUCU_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + SURUCU_ISIM + " VARCHAR,"
                + SURUCU_SOYISIM + " VARCHAR,"
                + SURUCU_TELEFON + " INT,"
                + ARAC_KAPASITE + " INT,"
                + SURUCU_ILCE + " VARCHAR);" ;


        String createTable2 = "CREATE TABLE " + TABLE_NAME1 + "("
                + SIPARIS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + SIPARIS_KALKIS_ILCE + " VARCHAR,"
                + SIPARIS_VARIS_ILCE + " VARCHAR,"
                + SIPARIS_TARIH + " INT,"
                + ESYA_SAYISI + " INT,"
                + SIPARIS_DURUM + " INT,"
                + ODEME_DURUM + " INT);" ;

        db.execSQL(createTable);
        //DATABASE_VERSION++;
        db.execSQL(createTable2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
    }

    public void surucuEkle(Surucu suruculer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(SURUCU_ISIM,suruculer.getSurucuIsim());
        contentValues.put(SURUCU_SOYISIM,suruculer.getSurucuSoyisim());
        contentValues.put(SURUCU_TELEFON,suruculer.getSurucuTelefon());
        contentValues.put(ARAC_KAPASITE,suruculer.getAracKapasite());
        contentValues.put(SURUCU_ILCE,suruculer.getSurucuIlce());
        long result =db.insert(TABLE_NAME,null,contentValues);
        if(result==-1){
            Toast msg = Toast.makeText(context,"Sürücü Eklenemedi",Toast.LENGTH_LONG);
            msg.show();
        }
        else {
            Toast msg = Toast.makeText(context,"Sürücü Eklendi",Toast.LENGTH_LONG);
            msg.show();
        }


        db.close();

    }

    Cursor readData(String ilce){
        String query= "SELECT * from SURUCU_DB where SURUCU_ILCE="+"'"+ilce+"'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;

        if(db != null){
           cursor = db.rawQuery(query,null);
        }
    return cursor;}

    Cursor readData(){
        String query= "SELECT * from SURUCU_DB ";
        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor = null;

        if(db!=null){
            cursor=db.rawQuery(query,null);
        }
    return cursor;}


    void delete(String id){
        String query = "DELETE FROM "+ TABLE_NAME + " WHERE SURUCU_ID="  + id ;
        SQLiteDatabase db = this.getWritableDatabase();
        if(db!=null){
            db.delete(TABLE_NAME,"SURUCU_ID=?",new String[]{id});
        }
        Log.v("if",query);
    }

    public void siparisEkle(Siparis siparisler){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(SIPARIS_KALKIS_ILCE, "ümraniye");
        contentValues.put(SIPARIS_VARIS_ILCE, "avcılar");
        contentValues.put(SIPARIS_TARIH, "10/02/2022");
        contentValues.put(ESYA_SAYISI, 3);
        contentValues.put(ODEME_DURUM, 0);
        contentValues.put(SIPARIS_DURUM, 0);

        long result = db.insert(TABLE_NAME1, null, contentValues);
        if(result == -1){
            Toast.makeText(context, "Sipariş Eklenemedi", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Sipariş Eklendi", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    Cursor readDataSiparis(){
        String query = "SELECT * FROM SIPARIS_DB";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db!= null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;}

    void deleteSiparis(String id ){
        String query = "DELETE FROM " + TABLE_NAME + "WHERE " + SIPARIS_ID + "="+ id;
        SQLiteDatabase db = getWritableDatabase();
        if (db!=null){
            db.delete(TABLE_NAME,"SURUCU_ID=?",new String[]{id});
        }
        Log.v("",query);
    }
}
