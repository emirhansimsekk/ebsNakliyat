package com.emirhansimsek.ebsnakliyat;

public class Siparis {
        String kalkisIlce;
        String varisIlce;
        String tarih;
        int aracKapasite;
        int siparis_durum;
        int odeme_durum;
        int surucu_id;


        public Siparis(String kalkisIlce, String varisIlce, String tarih, int aracKapasite,
                       int siparis_durum, int odeme_durum, int surucu_id){
                this.kalkisIlce = kalkisIlce;
                this.varisIlce = varisIlce;
                this.tarih = tarih;
                this.aracKapasite = aracKapasite;
                this.siparis_durum = siparis_durum;
                this.odeme_durum = odeme_durum;
                this.surucu_id = surucu_id;
        }
        public String getKalkisIlce(){
                return kalkisIlce;
        }
        public String getVarisIlce(){
                return varisIlce;
        }
        public String getTarih(){
                return tarih;
        }
        public int getAracKapasite(){
                return aracKapasite;
        }
        public int getSiparisDurum() { return siparis_durum; }
        public int getOdemeDurum() { return  odeme_durum; }
        public void setOdemeDurum(int odeme_durum){
                odeme_durum = 1;
        }
        public void setSiparisDurum(){
                siparis_durum = 1;
        }
        public int getSurucuID(){return surucu_id;}


}
