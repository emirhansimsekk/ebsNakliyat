package com.emirhansimsek.ebsnakliyat;

public class Siparis {
        String kalkisIlce;
        String varisIlce;
        String tarih;
        int aracKapasite;
        int siparis_durum;
        int odeme_durum;


        public Siparis(String kalkisIlce, String varisIlce, String tarih, int aracKapasite, int siparis_durum, int odeme_durum){
                this.kalkisIlce = kalkisIlce;
                this.varisIlce = varisIlce;
                this.tarih = tarih;
                this.aracKapasite = aracKapasite;
                siparis_durum=0;
                odeme_durum=0;
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
        public void setSiparisDurum(int siparis_durum){
                siparis_durum = 1;
        }


}
