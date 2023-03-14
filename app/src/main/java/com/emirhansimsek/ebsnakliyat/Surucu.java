package com.emirhansimsek.ebsnakliyat;

public class Surucu {
        private String surucuIsim;
        private String surucuSoyisim;
        private int surucuTelefon;
        private int aracKapasite;
        private String surucuIlce;





            public Surucu(String surucuIsim, String surucuSoyisim, int surucuTelefon, int aracKapasite,String surucuIlce){
                this.surucuIsim = surucuIsim;
                this.surucuSoyisim = surucuSoyisim ;
                this.surucuTelefon = surucuTelefon ;
                this.aracKapasite = aracKapasite ;
                this.surucuIlce = surucuIlce;
            }
    public String getSurucuIsim(){ return surucuIsim; }

    public String getSurucuSoyisim(){ return surucuSoyisim; }

    public int getSurucuTelefon(){ return surucuTelefon; }

    public int getAracKapasite() { return aracKapasite; }

    public String getSurucuIlce(){ return surucuIlce; }
}
