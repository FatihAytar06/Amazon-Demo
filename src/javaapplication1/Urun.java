/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Fatih
 */
public class Urun {
    public String Ad, Marka, Model, Ozellik;
        public int StokAdedi, SecilenAdet;
        public int HamFiyat;
        public Urun(String Ad,String Marka,String Model,String Ozellik,int SecilenAdet,int HamFiyat,int stokAdedi) {
            this.Ad = Ad;
            this.Marka = Marka;
            this.Model = Model;
            this.Ozellik = Ozellik;
            this.SecilenAdet = SecilenAdet;
            this.HamFiyat = HamFiyat;
            this.StokAdedi = stokAdedi;

            this.StokAdedi = stokAdedi;
        }
}
class Buzdolabi extends Urun{
        private double IcHacim;
        private String EnerjiSinifi;
        public double KdvliFiyat;

    public Buzdolabi(String Ad, String Marka, String Model, String Ozellik, int SecilenAdet, int HamFiyat, int stokAdedi,String EnerjiSinifi,double icHacim) {
        super(Ad, Marka, Model, Ozellik, SecilenAdet, HamFiyat, stokAdedi);
        this.IcHacim=icHacim;
        this.EnerjiSinifi=EnerjiSinifi;
    }
       
    public double KdvUygula()
    {
        KdvliFiyat = (HamFiyat * 1.05)*SecilenAdet;
        return KdvliFiyat;
    }


}
class LedTv extends Urun{
        public String EkranCozunurlugu,EkranBoyutu;
        public double KdvliFiyat;
    public LedTv(String Ad, String Marka, String Model, String Ozellik, int SecilenAdet, int HamFiyat, int stokAdedi,String ekranCoz,String ekranBoyut) {
        super(Ad, Marka, Model, Ozellik, SecilenAdet, HamFiyat, stokAdedi);
        this.EkranBoyutu=EkranBoyutu;
        this.EkranCozunurlugu=ekranCoz;
    }
    public double KdvUygula()
        {
            KdvliFiyat = (HamFiyat * 1.18)*SecilenAdet;
            return KdvliFiyat;
        }


}
class Ceptel extends Urun{
        public String DahiliHafıza,RamKapasitesi,PilGucu;
        public double KdvliFiyat;
    public Ceptel(String Ad, String Marka, String Model, String Ozellik, int SecilenAdet, int HamFiyat, int stokAdedi,String dahiliHafiza,String ramKapasitesi,String pilGucu) {
        super(Ad, Marka, Model, Ozellik, SecilenAdet, HamFiyat, stokAdedi);
        this.DahiliHafıza=dahiliHafiza;
        this.RamKapasitesi=ramKapasitesi;
        this.PilGucu=pilGucu;
    }
    public double KdvUygula()
        {
            KdvliFiyat = (HamFiyat * 1.18)*SecilenAdet;
            return KdvliFiyat;
        }


}
class Laptop extends Urun{
        public String EkranCozunurlugu, EkranBoyutu, DahiliHafiza,RamKapasitesi, PilGucu;
        public double KdvliFiyat;
    public Laptop(String Ad, String Marka, String Model, String Ozellik, int SecilenAdet, int HamFiyat, int stokAdedi,String ekranCoz,String ekranBoyutu,String dahiliHafiza,String ram,String pilGucu) {
        super(Ad, Marka, Model, Ozellik, SecilenAdet, HamFiyat, stokAdedi);
        this.DahiliHafiza=dahiliHafiza;
        this.RamKapasitesi=ram;
        this.EkranCozunurlugu=ekranCoz;
        this.EkranBoyutu=ekranBoyutu;
        this.PilGucu=pilGucu;
    }
    public double KdvUygula()
        {
            KdvliFiyat = (HamFiyat * 1.18)*SecilenAdet;
            return KdvliFiyat;
        }


}
 class Sepet
    {
        public int secilenTv, secilenTelefon, secilenLaptop, secilenBuzdolabi;

        public void SepeteUrunEkle(Urun urun) {
            AlisverisEkrani form = new AlisverisEkrani("");
        
        }
      
    }