/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Fatih
 */
public class AlisverisEkrani extends javax.swing.JFrame {
        int buzdolabi_stokFromValentina,laptop_stokFromValentina,telefon_stokFromValentina,tv_stokFromValentina;
        static String gmail;
        LedTv tv;
        Buzdolabi buzdolabi;
        Ceptel telefon;
        Laptop laptop;
        Sepet sepet = new Sepet();
        int buzdolabi_degeri = 0,tv_degeri=0,laptop_degeri=0,telefon_degeri=0;
        int siparisNumarasi;

    /**
     * Creates new form AlisverisEkrani
     */
  
    
    public AlisverisEkrani(String gmail) {
        initComponents();
        this.gmail=gmail;
        System.out.println("Eposta : "+gmail);
         try {
            /**
             * *** Bağlantı kurulumu ****
             */
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null) {
                System.out.println("Veritabanına bağlandı!");
            } else {
                System.out.println("Bağlantı girişimi başarısız!");
            }

            String sql = "SELECT stokadedi FROM urun WHERE urunadi=?";

            /**
             * *** Sorgu çalıştırma ****
             */
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "buzdolabi");
            ResultSet rs = stmt.executeQuery();

            /**
             * *** Bağlantı sonlandırma ****
             */
            conn.close();

            

            if (rs.next()) {
                /**
                 * *** Kayda ait alan değerlerini değişkene ata ****
                 */

                buzdolabi_stokFromValentina= rs.getInt("stokadedi");
               
            } 

            /**
             * *** Kaynakları serbest bırak ****
             */
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
          try {
            /**
             * *** Bağlantı kurulumu ****
             */
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null) {
                System.out.println("Veritabanına bağlandı!");
            } else {
                System.out.println("Bağlantı girişimi başarısız!");
            }

            String sql = "SELECT stokadedi FROM urun WHERE urunadi=?";

            /**
             * *** Sorgu çalıştırma ****
             */
            PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setString(1, "televizyon");
            ResultSet rs = stmt.executeQuery();

            /**
             * *** Bağlantı sonlandırma ****
             */
            conn.close();

            

            if (rs.next()) {
                /**
                 * *** Kayda ait alan değerlerini değişkene ata ****
                 */

                tv_stokFromValentina= rs.getInt("stokadedi");
               
            } 

            /**
             * *** Kaynakları serbest bırak ****
             */
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
           try {
            /**
             * *** Bağlantı kurulumu ****
             */
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null) {
                System.out.println("Veritabanına bağlandı!");
            } else {
                System.out.println("Bağlantı girişimi başarısız!");
            }

            String sql = "SELECT stokadedi FROM urun WHERE urunadi=?";

            /**
             * *** Sorgu çalıştırma ****
             */
            PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setString(1, "laptop");
            ResultSet rs = stmt.executeQuery();

            /**
             * *** Bağlantı sonlandırma ****
             */
            conn.close();

            

            if (rs.next()) {
                /**
                 * *** Kayda ait alan değerlerini değişkene ata ****
                 */

                laptop_stokFromValentina= rs.getInt("stokadedi");
               
            } 

            /**
             * *** Kaynakları serbest bırak ****
             */
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
            try {
            /**
             * *** Bağlantı kurulumu ****
             */
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null) {
                System.out.println("Veritabanına bağlandı!");
            } else {
                System.out.println("Bağlantı girişimi başarısız!");
            }

            String sql = "SELECT stokadedi FROM urun WHERE urunadi=?";

            /**
             * *** Sorgu çalıştırma ****
             */
            PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setString(1, "telefon");
            ResultSet rs = stmt.executeQuery();

            /**
             * *** Bağlantı sonlandırma ****
             */
            conn.close();

            

            if (rs.next()) {
                /**
                 * *** Kayda ait alan değerlerini değişkene ata ****
                 */

                telefon_stokFromValentina= rs.getInt("stokadedi");
               
            } 

            /**
             * *** Kaynakları serbest bırak ****
             */
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
       
        tv = new LedTv("Televizyon", "Vestel", "43UD8200", "Full HD", tv_stokFromValentina, 2300,100, "43 inç", "4K");
        buzdolabi = new Buzdolabi("Buzdolabı", "Samsung", "RT46K6000S8/TR", "No-Frost", buzdolabi_stokFromValentina, 3340,100, "A+", 468);
        telefon = new Ceptel("Telefon", "Samsung", "Galaxy-A71", "Akıllı Telefon", telefon_stokFromValentina, 3260,100, "128GB", "16GB", "4500mAh");
        laptop = new Laptop("Bilgisayar", "HP", "Pavillion", "Oyuncu Bilgisayarı", laptop_stokFromValentina, 5000,100, "15.6 inç", "4K", "512GB SSD", "8GB", "9 Saat");
            
        tv_stok.setText("Stok : "+tv_stokFromValentina);
        telefon_stok.setText("Stok : "+telefon_stokFromValentina);
        buzdolabi_stok.setText("Stok : "+buzdolabi_stokFromValentina);
        laptop_stok.setText("Stok : "+laptop_stokFromValentina);
        
        
        
        ImageIcon icon1 = new ImageIcon(".\\src\\javaapplication1\\televizyon.jpg");
        
        Image image1 = icon1.getImage();
        Image imgScale1 = image1.getScaledInstance(imageLabel1.getWidth(),imageLabel1.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(imgScale1);
        imageLabel1.setIcon(scaledIcon1);
        
        ImageIcon icon2 = new ImageIcon(".\\src\\javaapplication1\\buzdolabi.jpg");
        
        Image image2 = icon2.getImage();
        Image imgScale2 = image2.getScaledInstance(imageLabel2.getWidth(),imageLabel2.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(imgScale2);
        imageLabel2.setIcon(scaledIcon2);
        
        ImageIcon icon3 = new ImageIcon(".\\src\\javaapplication1\\laptop.jpg");
        
        Image image3 = icon3.getImage();
        Image imgScale3 = image3.getScaledInstance(imageLabel3.getWidth(),imageLabel3.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(imgScale3);
        imageLabel3.setIcon(scaledIcon3);
        
        ImageIcon icon4 = new ImageIcon(".\\src\\javaapplication1\\telefon.jpg");
        
        Image image4 = icon4.getImage();
        Image imgScale4 = image4.getScaledInstance(imageLabel4.getWidth(),imageLabel4.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon4 = new ImageIcon(imgScale4);
        imageLabel4.setIcon(scaledIcon4);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        imageLabel1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fiyatLabel1 = new javax.swing.JLabel();
        tv_stok = new javax.swing.JLabel();
        tv_adet = new javax.swing.JSpinner();
        imageLabel2 = new javax.swing.JLabel();
        fiyatLabel2 = new javax.swing.JLabel();
        buzdolabi_stok = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        buzdolabi_adet = new javax.swing.JSpinner();
        imageLabel3 = new javax.swing.JLabel();
        fiyatLabel3 = new javax.swing.JLabel();
        laptop_stok = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        laptop_adet = new javax.swing.JSpinner();
        imageLabel4 = new javax.swing.JLabel();
        fiyatLabel4 = new javax.swing.JLabel();
        telefon_stok = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        telefon_adet = new javax.swing.JSpinner();
        urunEkleBtn = new javax.swing.JButton();
        sepetTemizleBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        toplamFiyatLabel = new javax.swing.JLabel();
        adetListBox = new java.awt.List();
        UrunListBox = new java.awt.List();
        fiyatListBox = new java.awt.List();
        onaylaBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Favorilere Ekle");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Adet :");

        fiyatLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fiyatLabel1.setText("Fiyat : 2300₺");

        tv_stok.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tv_stok.setText("Stok :");

        tv_adet.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        fiyatLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fiyatLabel2.setText("Fiyat : 3340₺");

        buzdolabi_stok.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buzdolabi_stok.setText("Stok :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Adet :");

        buzdolabi_adet.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        fiyatLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fiyatLabel3.setText("Fiyat : 5000₺");

        laptop_stok.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        laptop_stok.setText("Stok :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Adet :");

        laptop_adet.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        fiyatLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fiyatLabel4.setText("Fiyat : 3260₺");

        telefon_stok.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        telefon_stok.setText("Stok :");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Adet :");

        telefon_adet.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        urunEkleBtn.setText("Urun Ekle");
        urunEkleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urunEkleBtnActionPerformed(evt);
            }
        });

        sepetTemizleBtn.setText("Sepeti Temizle");
        sepetTemizleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sepetTemizleBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Adet");

        jLabel3.setText("Urun");

        jLabel4.setText("Kdv'li Fiyat");

        toplamFiyatLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        toplamFiyatLabel.setText("Kdv'li Toplam Fiyat :");

        onaylaBtn.setText("SEPETİ ONAYLA");
        onaylaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onaylaBtnActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Favorilere Ekle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Favorilere Ekle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Favorilere Ekle");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Favorilere Ekle");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(urunEkleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(telefon_adet, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(telefon_stok, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(fiyatLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)))
                                    .addComponent(sepetTemizleBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(198, 198, 198)
                                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imageLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tv_adet, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fiyatLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tv_stok, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imageLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buzdolabi_adet, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buzdolabi_stok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fiyatLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imageLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(laptop_adet, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(laptop_stok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fiyatLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(imageLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel4)
                        .addContainerGap(70, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(onaylaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(adetListBox, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(UrunListBox, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fiyatListBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(toplamFiyatLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fiyatLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tv_stok, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tv_adet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adetListBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(UrunListBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fiyatListBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(imageLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(fiyatLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buzdolabi_stok, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buzdolabi_adet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toplamFiyatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(onaylaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(imageLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imageLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fiyatLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fiyatLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addComponent(laptop_stok, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(laptop_adet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(telefon_stok, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(telefon_adet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(urunEkleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(sepetTemizleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void urunEkleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urunEkleBtnActionPerformed
       sepet.secilenBuzdolabi = (Integer)buzdolabi_adet.getValue();
            sepet.secilenLaptop = (Integer)laptop_adet.getValue();
            sepet.secilenTelefon = (Integer)telefon_adet.getValue();
            sepet.secilenTv = (Integer)tv_adet.getValue();
            //ürün adetleri 0 dan fazla ise seçilen koşula girilir
            if (sepet.secilenTv > 0||sepet.secilenBuzdolabi>0||sepet.secilenTelefon>0||sepet.secilenLaptop>0)
            {
                adetListBox.removeAll();
                UrunListBox.removeAll();
                fiyatListBox.removeAll();
                //seçilen televizyon sayısı 0 dan büyük ise seçilen koşula girilir ve işlem yapılır
                if (sepet.secilenTv > 0)
                {
                    //seçilen tv adedi stok adedinden fazla ise seçilen tv adedi stok adedine eşitlenecek şekilde maksimum tutar sınırlandırılır
                    if (sepet.secilenTv > tv.StokAdedi)
                    {
                        sepet.secilenTv = tv.StokAdedi;
                        tv.SecilenAdet = sepet.secilenTv;
                        //televizyon stok adedi sıfırlanmadı ise seçilen adet toplam televizyon sayısına eşitlenir
                        if (tv.StokAdedi != 0)
                        {
                            tv_degeri += sepet.secilenTv;
                            tv.SecilenAdet = tv_degeri;
                        }
                        //aksi halde televizyon stok adedi seçilen önceki toplam televizyon sayısına eşitlenir
                        else
                        {
                            tv.SecilenAdet = tv_degeri;
                        }
                        tv.StokAdedi = 0;
                    }
                    //seçilen adet stok adedinden az ise seçilen adet sayısı stok adedinden düşürülür
                    else
                    {
                        tv_degeri += sepet.secilenTv;
                        tv.StokAdedi -= sepet.secilenTv;
                        tv.SecilenAdet = tv_degeri;
                    }
                    tv_stok.setText("Stok : "+String.valueOf(tv_stokFromValentina)); 

                }
               //toplam seçilen televizyon sayısı sıfırdan farklı ise listbox lara ekleme yapılır
                if (tv_degeri!=0)
                {
                    UrunListBox.add("Televizyon");
                    adetListBox.add(String.valueOf(tv_degeri));
                    fiyatListBox.add(String.valueOf(tv.KdvUygula()));

                }

                //seçilen buzdolabı sayısı 0 dan büyük ise seçilen koşula girilir ve işlem yapılır
                if (sepet.secilenBuzdolabi > 0)
                {
                    //seçilen buzdolabı adedi stok adedinden fazla ise seçilen buzdolabı adedi stok adedine eşitlenecek şekilde maksimum tutar sınırlandırılır
                    if (sepet.secilenBuzdolabi > buzdolabi.StokAdedi)
                    {
                        sepet.secilenBuzdolabi = buzdolabi.StokAdedi;
                        buzdolabi.SecilenAdet = sepet.secilenBuzdolabi;
                        //buzdolabı stok adedi sıfırlanmadı ise seçilen adet toplam televizyon sayısına eşitlenir
                        if (buzdolabi.StokAdedi != 0)
                        {
                            buzdolabi_degeri += sepet.secilenBuzdolabi;
                            buzdolabi.SecilenAdet = buzdolabi_degeri;
                        }
                        //aksi halde buzdolabı stok adedi seçilen önceki toplam buzdolabı sayısına eşitlenir
                        else
                        {
                            buzdolabi.SecilenAdet = buzdolabi_degeri;
                        }

                        buzdolabi.StokAdedi = 0;

                    }
                    //seçilen adet stok adedinden az ise seçilen adet sayısı stok adedinden düşürülür
                    else
                    {
                        buzdolabi_degeri += sepet.secilenBuzdolabi;
                        buzdolabi.StokAdedi -= sepet.secilenBuzdolabi;
                        buzdolabi.SecilenAdet = buzdolabi_degeri;
                    }
                    buzdolabi_stok.setText("Stok : "+String.valueOf(buzdolabi_stokFromValentina));
                }
                //toplam seçilen buzdolabı sayısı sıfırdan farklı ise listbox lara ekleme yapılır
                if (buzdolabi_degeri!=0)
                {
                    UrunListBox.add("Buzdolabı");
                    adetListBox.add(String.valueOf(buzdolabi_degeri));
                    fiyatListBox.add(String.valueOf(buzdolabi.KdvUygula()));
                }
                //seçilen laptop sayısı 0 dan büyük ise seçilen koşula girilir ve işlem yapılır
                if (sepet.secilenLaptop > 0)
                {

                    //seçilen laptop adedi stok adedinden fazla ise seçilen laptop adedi stok adedine eşitlenecek şekilde maksimum tutar sınırlandırılır
                    if (sepet.secilenLaptop > laptop.StokAdedi)
                    {
                        sepet.secilenLaptop = laptop.StokAdedi;
                        laptop.SecilenAdet = sepet.secilenLaptop;
                        //laptop stok adedi sıfırlanmadı ise seçilen adet toplam televizyon sayısına eşitlenir
                        if (laptop.StokAdedi != 0)
                        {
                            laptop_degeri += laptop.SecilenAdet;
                            laptop.SecilenAdet = laptop_degeri;
                        }
                        //aksi halde laptop stok adedi seçilen önceki toplam laptop sayısına eşitlenir
                        else
                        {
                            laptop.SecilenAdet = laptop_degeri;
                        }
                        laptop.StokAdedi = 0;
                    }
                    //seçilen adet stok adedinden az ise seçilen adet sayısı stok adedinden düşürülür
                    else
                    {
                        laptop_degeri += sepet.secilenLaptop;
                        laptop.StokAdedi -= sepet.secilenLaptop;
                        laptop.SecilenAdet = laptop_degeri;
                    }
                    laptop_stok.setText("Stok : "+String.valueOf(laptop_stokFromValentina));

                }
                //toplam seçilen laptop sayısı sıfırdan farklı ise listbox lara ekleme yapılır
                if (laptop_degeri!=0)
                {
                    UrunListBox.add("Laptop");
                    adetListBox.add(String.valueOf(laptop_degeri));
                    fiyatListBox.add(String.valueOf(laptop.KdvUygula()));
                }


                //seçilen telefon sayısı 0 dan büyük ise seçilen koşula girilir ve işlem yapılır
                if (sepet.secilenTelefon > 0)
                {
                    //seçilen telefon adedi stok adedinden fazla ise seçilen telefon adedi stok adedine eşitlenecek şekilde maksimum tutar sınırlandırılır
                    if (sepet.secilenTelefon > telefon.StokAdedi)
                    {
                        sepet.secilenTelefon = telefon.StokAdedi;
                        telefon.SecilenAdet = sepet.secilenTelefon;
                        //telefon stok adedi sıfırlanmadı ise seçilen adet toplam televizyon sayısına eşitlenir
                        if (telefon.StokAdedi != 0)
                        {
                            telefon_degeri += telefon.SecilenAdet;
                            telefon.SecilenAdet = telefon_degeri;
                        }
                        //aksi halde telefon stok adedi seçilen önceki toplam telefon sayısına eşitlenir
                        else
                        {
                            telefon.SecilenAdet = telefon_degeri;
                        }
                        telefon.StokAdedi = 0;
                       
                    }
                    //seçilen adet stok adedinden az ise seçilen adet sayısı stok adedinden düşürülür
                    else
                    {
                        telefon_degeri += sepet.secilenTelefon;
                        telefon.StokAdedi -= sepet.secilenTelefon;
                        telefon.SecilenAdet = telefon_degeri;
                    }
                    telefon_stok.setText("Stok : "+String.valueOf(telefon_stokFromValentina)); 
                }
                //toplam seçilen telefon sayısı sıfırdan farklı ise listbox lara ekleme yapılır
                if (telefon_degeri!=0) {
                    UrunListBox.add("Telefon");
                    adetListBox.add(String.valueOf(telefon_degeri));
                    fiyatListBox.add(String.valueOf(telefon.KdvUygula()));
                }
            }
            
            if((Integer)tv_adet.getValue()!=0){
                try{   
                /***** Bağlantı kurulumu *****/
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
                if (conn != null)
                System.out.println("Veritabanına bağlandı!");
                else
                System.out.println("Bağlantı girişimi başarısız!");
            
            
                 String sql= "CALL urunal('2','Televizyon',"+(Integer)tv_adet.getValue()+","+tv.KdvliFiyat+",'"+gmail+"')";

                /***** Sorgu çalıştırma *****/
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.execute();
            
            
                /***** Bağlantı sonlandırma *****/
                conn.close();

                /***** Kaynakları serbest bırak *****/
                stmt.close();

            } catch (Exception e) {
                e.printStackTrace();
           
            }       
            
            }
            if((Integer)buzdolabi_adet.getValue()!=0){
             try{   
                /***** Bağlantı kurulumu *****/
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
                if (conn != null)
                System.out.println("Veritabanına bağlandı!");
                else
                System.out.println("Bağlantı girişimi başarısız!");
            
            
                String sql= "CALL urunal('1','Buzdolabı',"+(Integer)buzdolabi_adet.getValue()+","+buzdolabi.KdvliFiyat+",'"+gmail+"')";

                /***** Sorgu çalıştırma *****/
                PreparedStatement stmt = conn.prepareStatement(sql);
               
                stmt.execute();
            
            
                /***** Bağlantı sonlandırma *****/
                conn.close();

                /***** Kaynakları serbest bırak *****/
                stmt.close();

            } catch (Exception e) {
                e.printStackTrace();
           
            }       
            
            }
            if((Integer)telefon_adet.getValue()!=0){
             try{   
                /***** Bağlantı kurulumu *****/
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
                if (conn != null)
                System.out.println("Veritabanına bağlandı!");
                else
                System.out.println("Bağlantı girişimi başarısız!");
            
            
                 String sql= "CALL urunal('4','Telefon',"+(Integer)telefon_adet.getValue()+","+telefon.KdvliFiyat+",'"+gmail+"')";

                /***** Sorgu çalıştırma *****/
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.execute();
            
            
                /***** Bağlantı sonlandırma *****/
                conn.close();

                /***** Kaynakları serbest bırak *****/
                stmt.close();

            } catch (Exception e) {
                e.printStackTrace();
           
            }       
            
            }
            if((Integer)laptop_adet.getValue()!=0){
             try{   
                /***** Bağlantı kurulumu *****/
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
                if (conn != null)
                System.out.println("Veritabanına bağlandı!");
                else
                System.out.println("Bağlantı girişimi başarısız!");
            
            
                String sql= "CALL urunal('3','Laptop',"+(Integer)laptop_adet.getValue()+","+laptop.KdvliFiyat+",'"+gmail+"')";

                /***** Sorgu çalıştırma *****/
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.execute();
            
            
                /***** Bağlantı sonlandırma *****/
                conn.close();

                /***** Kaynakları serbest bırak *****/
                stmt.close();

            } catch (Exception e) {
                e.printStackTrace();
           
            }       
            
            }
             try {
            /**
             * *** Bağlantı kurulumu ****
             */
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null) {
                System.out.println("Veritabanına bağlandı!");
            } else {
                System.out.println("Bağlantı girişimi başarısız!");
            }

            String sql = "SELECT stokadedi FROM urun WHERE urunadi=?";

            /**
             * *** Sorgu çalıştırma ****
             */
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "buzdolabi");
            ResultSet rs = stmt.executeQuery();

            /**
             * *** Bağlantı sonlandırma ****
             */
            conn.close();

            

            if (rs.next()) {
                /**
                 * *** Kayda ait alan değerlerini değişkene ata ****
                 */

                buzdolabi_stokFromValentina= rs.getInt("stokadedi");
               
            } 

            /**
             * *** Kaynakları serbest bırak ****
             */
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
          try {
            /**
             * *** Bağlantı kurulumu ****
             */
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null) {
                System.out.println("Veritabanına bağlandı!");
            } else {
                System.out.println("Bağlantı girişimi başarısız!");
            }

            String sql = "SELECT stokadedi FROM urun WHERE urunadi=?";

            /**
             * *** Sorgu çalıştırma ****
             */
            PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setString(1, "televizyon");
            ResultSet rs = stmt.executeQuery();

            /**
             * *** Bağlantı sonlandırma ****
             */
            conn.close();

            

            if (rs.next()) {
                /**
                 * *** Kayda ait alan değerlerini değişkene ata ****
                 */

                tv_stokFromValentina= rs.getInt("stokadedi");
               
            } 

            /**
             * *** Kaynakları serbest bırak ****
             */
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
           try {
            /**
             * *** Bağlantı kurulumu ****
             */
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null) {
                System.out.println("Veritabanına bağlandı!");
            } else {
                System.out.println("Bağlantı girişimi başarısız!");
            }

            String sql = "SELECT stokadedi FROM urun WHERE urunadi=?";

            /**
             * *** Sorgu çalıştırma ****
             */
            PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setString(1, "laptop");
            ResultSet rs = stmt.executeQuery();

            /**
             * *** Bağlantı sonlandırma ****
             */
            conn.close();

            

            if (rs.next()) {
                /**
                 * *** Kayda ait alan değerlerini değişkene ata ****
                 */

                laptop_stokFromValentina= rs.getInt("stokadedi");
               
            } 

            /**
             * *** Kaynakları serbest bırak ****
             */
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
            try {
            /**
             * *** Bağlantı kurulumu ****
             */
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null) {
                System.out.println("Veritabanına bağlandı!");
            } else {
                System.out.println("Bağlantı girişimi başarısız!");
            }

            String sql = "SELECT stokadedi FROM urun WHERE urunadi=?";

            /**
             * *** Sorgu çalıştırma ****
             */
            PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setString(1, "telefon");
            ResultSet rs = stmt.executeQuery();

            /**
             * *** Bağlantı sonlandırma ****
             */
            conn.close();

            

            if (rs.next()) {
                /**
                 * *** Kayda ait alan değerlerini değişkene ata ****
                 */

                telefon_stokFromValentina= rs.getInt("stokadedi");
               
            } 

            /**
             * *** Kaynakları serbest bırak ****
             */
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
            
            tv_stok.setText("Stok : "+tv_stokFromValentina);
            telefon_stok.setText("Stok : "+telefon_stokFromValentina);
            buzdolabi_stok.setText("Stok : "+buzdolabi_stokFromValentina);
            laptop_stok.setText("Stok : "+laptop_stokFromValentina);
            
            toplamFiyatLabel.setText("Kdv'li Toplam Fiyat : "+(laptop.KdvliFiyat+tv.KdvliFiyat+buzdolabi.KdvliFiyat+telefon.KdvliFiyat)+"TL"); 
            tv_adet.setValue(0);
            buzdolabi_adet.setValue(0);
            telefon_adet.setValue(0);
            laptop_adet.setValue(0);
            
          
    }//GEN-LAST:event_urunEkleBtnActionPerformed

    private void sepetTemizleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sepetTemizleBtnActionPerformed
            laptop.StokAdedi += laptop_degeri;
            tv.StokAdedi += tv_degeri;
            telefon.StokAdedi += telefon_degeri;
            buzdolabi.StokAdedi += buzdolabi_degeri;
            tv_stok.setText("Stok : "+String.valueOf(tv_stokFromValentina)); 
            telefon_stok.setText("Stok : "+String.valueOf(telefon_stokFromValentina));
            buzdolabi_stok.setText("Stok : "+String.valueOf(buzdolabi_stokFromValentina));
            laptop_stok.setText("Stok : "+String.valueOf(laptop_stokFromValentina)); 
            laptop_degeri = 0;
            buzdolabi_degeri = 0;
            tv_degeri = 0;
            telefon_degeri = 0;
            laptop.KdvliFiyat = 0;
            tv.KdvliFiyat = 0;
            buzdolabi.KdvliFiyat = 0;
            telefon.KdvliFiyat = 0;
            toplamFiyatLabel.setText("Kdv'li Toplam Fiyat :");
            tv_adet.setValue(0);
            buzdolabi_adet.setValue(0);
            laptop_adet.setValue(0);
            telefon_adet.setValue(0);
            tv.SecilenAdet = 0;
            laptop.SecilenAdet = 0;
            buzdolabi.SecilenAdet = 0;
            telefon.SecilenAdet = 0;
            adetListBox.removeAll();
            UrunListBox.removeAll();
            fiyatListBox.removeAll();
            
             try {
                 Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
                if (conn != null)
                    System.out.println("Veritabanına bağlandı!");
                 else
                    System.out.println("Bağlantı girişimi başarısız!");
                String sql="CALL sepettemizle('"+gmail+"')";
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.execute();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
             try {
                 Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
                if (conn != null)
                    System.out.println("Veritabanına bağlandı!");
                 else
                    System.out.println("Bağlantı girişimi başarısız!");
                String sql="DELETE FROM siparis WHERE musterieposta=?";
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, gmail);
                stmt.execute();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
              try {
            /**
             * *** Bağlantı kurulumu ****
             */
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null) {
                System.out.println("Veritabanına bağlandı!");
            } else {
                System.out.println("Bağlantı girişimi başarısız!");
            }

            String sql = "SELECT stokadedi FROM urun WHERE urunadi=?";

            /**
             * *** Sorgu çalıştırma ****
             */
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "buzdolabi");
            ResultSet rs = stmt.executeQuery();

            /**
             * *** Bağlantı sonlandırma ****
             */
            conn.close();

            

            if (rs.next()) {
                /**
                 * *** Kayda ait alan değerlerini değişkene ata ****
                 */

                buzdolabi_stokFromValentina= rs.getInt("stokadedi");
               
            } 

            /**
             * *** Kaynakları serbest bırak ****
             */
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
          try {
            /**
             * *** Bağlantı kurulumu ****
             */
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null) {
                System.out.println("Veritabanına bağlandı!");
            } else {
                System.out.println("Bağlantı girişimi başarısız!");
            }

            String sql = "SELECT stokadedi FROM urun WHERE urunadi=?";

            /**
             * *** Sorgu çalıştırma ****
             */
            PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setString(1, "televizyon");
            ResultSet rs = stmt.executeQuery();

            /**
             * *** Bağlantı sonlandırma ****
             */
            conn.close();

            

            if (rs.next()) {
                /**
                 * *** Kayda ait alan değerlerini değişkene ata ****
                 */

                tv_stokFromValentina= rs.getInt("stokadedi");
               
            } 

            /**
             * *** Kaynakları serbest bırak ****
             */
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
           try {
            /**
             * *** Bağlantı kurulumu ****
             */
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null) {
                System.out.println("Veritabanına bağlandı!");
            } else {
                System.out.println("Bağlantı girişimi başarısız!");
            }

            String sql = "SELECT stokadedi FROM urun WHERE urunadi=?";

            /**
             * *** Sorgu çalıştırma ****
             */
            PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setString(1, "laptop");
            ResultSet rs = stmt.executeQuery();

            /**
             * *** Bağlantı sonlandırma ****
             */
            conn.close();

            

            if (rs.next()) {
                /**
                 * *** Kayda ait alan değerlerini değişkene ata ****
                 */

                laptop_stokFromValentina= rs.getInt("stokadedi");
               
            } 

            /**
             * *** Kaynakları serbest bırak ****
             */
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
            try {
            /**
             * *** Bağlantı kurulumu ****
             */
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null) {
                System.out.println("Veritabanına bağlandı!");
            } else {
                System.out.println("Bağlantı girişimi başarısız!");
            }

            String sql = "SELECT stokadedi FROM urun WHERE urunadi=?";

            /**
             * *** Sorgu çalıştırma ****
             */
            PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setString(1, "telefon");
            ResultSet rs = stmt.executeQuery();

            /**
             * *** Bağlantı sonlandırma ****
             */
            conn.close();

            

            if (rs.next()) {
                /**
                 * *** Kayda ait alan değerlerini değişkene ata ****
                 */

                telefon_stokFromValentina= rs.getInt("stokadedi");
               
            } 

            /**
             * *** Kaynakları serbest bırak ****
             */
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        tv_stok.setText("Stok : "+tv_stokFromValentina);
        telefon_stok.setText("Stok : "+telefon_stokFromValentina);
        buzdolabi_stok.setText("Stok : "+buzdolabi_stokFromValentina);
        laptop_stok.setText("Stok : "+laptop_stokFromValentina);
             
    }//GEN-LAST:event_sepetTemizleBtnActionPerformed

    private void onaylaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onaylaBtnActionPerformed
       String email = gmail;
        for(int i=0;i<UrunListBox.getItemCount();i++){
           String urunAdet = adetListBox.getItem(i).toString();
           String urunAdi = UrunListBox.getItem(i).toString();
           String urunFiyat = fiyatListBox.getItem(i).toString();
           int urunid=0;
           int sepetid=0;
           if(urunAdi.equals("Buzdolabı")){
               buzdolabi_stokFromValentina-=Integer.valueOf(urunAdet);
               urunid=1;
           }
           else if(urunAdi.equals("Televizyon")){
               tv_stokFromValentina-=Integer.valueOf(urunAdet);
               urunid=2;
           }
           else if(urunAdi.equals("Telefon")){
                telefon_stokFromValentina-=Integer.valueOf(urunAdet);
                urunid=4;
           }
           else if(urunAdi.equals("Laptop")){
               laptop_stokFromValentina-=Integer.valueOf(urunAdet);
               urunid=3;
           }
           
            try {
                 Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
                if (conn != null)
                    System.out.println("Veritabanına bağlandı!");
                 else
                    System.out.println("Bağlantı girişimi başarısız!");
                String sql="SELECT sepetid FROM sepet WHERE email=? AND urunadi=?";
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, email);
                stmt.setString(2, urunAdi);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    sepetid=rs.getInt("sepetid");
                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
           
           
           
           
           
       try
        {   
            /***** Bağlantı kurulumu *****/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
            
            
            String sql= "INSERT INTO siparis (musterieposta,urunadi,urunadedi,toplamfiyat,urunid,sepetid) VALUES (?,?,?,?,?,?)";

            /***** Sorgu çalıştırma *****/
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, urunAdi);
            stmt.setInt(3, Integer.valueOf(urunAdet));
            stmt.setDouble(4, Double.valueOf(urunFiyat));
            stmt.setInt(5, urunid);
            stmt.setInt(6, sepetid);
            stmt.execute();
            
            
            /***** Bağlantı sonlandırma *****/
            conn.close();

            /***** Kaynakları serbest bırak *****/
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
           
        }
       
       }
        
         try
        {   
            /***** Bağlantı kurulumu *****/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
            
            
            String sql= "CALL stokguncelle("+buzdolabi_stokFromValentina+",'buzdolabi')";

            /***** Sorgu çalıştırma *****/
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            
            
            /***** Bağlantı sonlandırma *****/
            conn.close();

            /***** Kaynakları serbest bırak *****/
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
           
        }
          try
        {   
            /***** Bağlantı kurulumu *****/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
            
            
            String sql= "CALL stokguncelle("+laptop_stokFromValentina+",'laptop')";
            /***** Sorgu çalıştırma *****/
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            
            
            /***** Bağlantı sonlandırma *****/
            conn.close();

            /***** Kaynakları serbest bırak *****/
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
           
        }
        try
        {   
            /***** Bağlantı kurulumu *****/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
            
            
            String sql= "CALL stokguncelle("+telefon_stokFromValentina+",'telefon')";

            /***** Sorgu çalıştırma *****/
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            
            
            /***** Bağlantı sonlandırma *****/
            conn.close();

            /***** Kaynakları serbest bırak *****/
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
           
        }
        try
        {   
            /***** Bağlantı kurulumu *****/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
            
            
            String sql= "CALL stokguncelle("+tv_stokFromValentina+",'televizyon')";

            /***** Sorgu çalıştırma *****/
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            
            
            /***** Bağlantı sonlandırma *****/
            conn.close();

            /***** Kaynakları serbest bırak *****/
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
           
        }
         try
        {   
            /***** Bağlantı kurulumu *****/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
            
            
            String sql= "SELECT*FROM siparis WHERE musterieposta=?";

            /***** Sorgu çalıştırma *****/
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, gmail);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                siparisNumarasi=rs.getInt("siparisid");
                
            }
            /***** Bağlantı sonlandırma *****/
            conn.close();

            /***** Kaynakları serbest bırak *****/
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
           
        }
        
        adetListBox.removeAll();
        UrunListBox.removeAll();
        fiyatListBox.removeAll();
         tv_stok.setText("Stok : "+tv_stokFromValentina);
        telefon_stok.setText("Stok : "+telefon_stokFromValentina);
        buzdolabi_stok.setText("Stok : "+buzdolabi_stokFromValentina);
        laptop_stok.setText("Stok : "+laptop_stokFromValentina);
        AdresBilgileri adresBilgileri = new AdresBilgileri(gmail,siparisNumarasi);
        this.setVisible(false);
        adresBilgileri.setVisible(true);
    }//GEN-LAST:event_onaylaBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       boolean kontrol=false;
        try
        {   
            /***** Bağlantı kurulumu *****/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
            
            
            String sql= "SELECT urunid FROM favoriler WHERE email=? AND urunadi=?";

            /***** Sorgu çalıştırma *****/
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, gmail);
            stmt.setString(2, "televizyon");
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                kontrol=true;
            
            }
            
            /***** Bağlantı sonlandırma *****/
            conn.close();

            /***** Kaynakları serbest bırak *****/
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
           
        }
        if(!kontrol){
        try
        {   
            /***** Bağlantı kurulumu *****/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
            
            
            String sql= "INSERT INTO favoriler(urunid,urunadi,email)VALUES(?,?,?)";

            /***** Sorgu çalıştırma *****/
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 2);
            stmt.setString(2, "televizyon");
            stmt.setString(3, gmail);
            stmt.execute();
            
            
            /***** Bağlantı sonlandırma *****/
            conn.close();

            /***** Kaynakları serbest bırak *****/
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
           
        }
        
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         boolean kontrol=false;
        try
        {   
            /***** Bağlantı kurulumu *****/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
            
            
            String sql= "SELECT urunid FROM favoriler WHERE email=? AND urunadi=?";

            /***** Sorgu çalıştırma *****/
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, gmail);
            stmt.setString(2, "buzdolabi");
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                kontrol=true;
            
            }
            
            /***** Bağlantı sonlandırma *****/
            conn.close();

            /***** Kaynakları serbest bırak *****/
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
           
        }
        if(!kontrol){
        try
        {   
            /***** Bağlantı kurulumu *****/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
            
            
            String sql= "INSERT INTO favoriler(urunid,urunadi,email)VALUES(?,?,?)";

            /***** Sorgu çalıştırma *****/
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 1);
            stmt.setString(2, "buzdolabi");
            stmt.setString(3, gmail);
            stmt.execute();
            
            
            /***** Bağlantı sonlandırma *****/
            conn.close();

            /***** Kaynakları serbest bırak *****/
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
           
        }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        boolean kontrol=false;
        try
        {   
            /***** Bağlantı kurulumu *****/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
            
            
            String sql= "SELECT urunid FROM favoriler WHERE email=? AND urunadi=?";

            /***** Sorgu çalıştırma *****/
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, gmail);
            stmt.setString(2, "laptop");
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                kontrol=true;
            
            }
            
            /***** Bağlantı sonlandırma *****/
            conn.close();

            /***** Kaynakları serbest bırak *****/
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
           
        }
        
        if(!kontrol){
        try
        {   
            /***** Bağlantı kurulumu *****/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
            
            
            String sql= "INSERT INTO favoriler(urunid,urunadi,email)VALUES(?,?,?)";

            /***** Sorgu çalıştırma *****/
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 3);
            stmt.setString(2, "laptop");
            stmt.setString(3, gmail);
            stmt.execute();
            
            
            /***** Bağlantı sonlandırma *****/
            conn.close();

            /***** Kaynakları serbest bırak *****/
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
           
        }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        boolean kontrol=false;
        try
        {   
            /***** Bağlantı kurulumu *****/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
            
            
            String sql= "SELECT urunid FROM favoriler WHERE email=? AND urunadi=?";

            /***** Sorgu çalıştırma *****/
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, gmail);
            stmt.setString(2, "telefon");
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                kontrol=true;
            
            }
            
            /***** Bağlantı sonlandırma *****/
            conn.close();

            /***** Kaynakları serbest bırak *****/
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
           
        }
        if(!kontrol){
        try
        {   
            /***** Bağlantı kurulumu *****/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VYProje",
                    "postgres", "147852");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
            
            
            String sql= "INSERT INTO favoriler(urunid,urunadi,email)VALUES(?,?,?)";

            /***** Sorgu çalıştırma *****/
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 4);
            stmt.setString(2, "telefon");
            stmt.setString(3, gmail);
            stmt.execute();
            
            
            /***** Bağlantı sonlandırma *****/
            conn.close();

            /***** Kaynakları serbest bırak *****/
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
           
        }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlisverisEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlisverisEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlisverisEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlisverisEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlisverisEkrani(gmail).setVisible(true);
            }
        });
       
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.List UrunListBox;
    private java.awt.List adetListBox;
    private javax.swing.JSpinner buzdolabi_adet;
    private javax.swing.JLabel buzdolabi_stok;
    private javax.swing.JLabel fiyatLabel1;
    private javax.swing.JLabel fiyatLabel2;
    private javax.swing.JLabel fiyatLabel3;
    private javax.swing.JLabel fiyatLabel4;
    private java.awt.List fiyatListBox;
    private javax.swing.JLabel imageLabel1;
    private javax.swing.JLabel imageLabel2;
    private javax.swing.JLabel imageLabel3;
    private javax.swing.JLabel imageLabel4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner laptop_adet;
    private javax.swing.JLabel laptop_stok;
    private javax.swing.JButton onaylaBtn;
    private javax.swing.JButton sepetTemizleBtn;
    private javax.swing.JSpinner telefon_adet;
    private javax.swing.JLabel telefon_stok;
    private javax.swing.JLabel toplamFiyatLabel;
    private javax.swing.JSpinner tv_adet;
    private javax.swing.JLabel tv_stok;
    private javax.swing.JButton urunEkleBtn;
    // End of variables declaration//GEN-END:variables
}
