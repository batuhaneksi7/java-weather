
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Batuhan Ekşi
 * 130202091
 */
public class MainFrame extends javax.swing.JFrame {

    

    ArrayList<String> ids = new ArrayList<>();
    ArrayList<Varlik> list = new ArrayList<>();
    ArrayList<String> citys = new ArrayList<>();
    String id = "";

    //program ilk çalıştığında çalışıcak method (yapıcı)
    public MainFrame() {
        initComponents();

        Methods ns = new Methods();
        jComboBox1.setModel(ns.comboboxDoldur()); //combobox doldur

        DefaultTableModel table = new DefaultTableModel();

        table.addColumn("Şehir");
        table.addColumn("Sıcaklık");
        table.addColumn("Rüzgar");
        table.addColumn("Hava Durumu");

        jTable1.setModel(table); // table doldur
        
        //timertask içinde güncelleme işlemleri 
        //kendi içinde ayrı bir thread oluşturur
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                for (String item : ids) { //ids Arraylistindeki her id için tabloda güncelleme yap
                     try {
            String hurl = "http://api.openweathermap.org/data/2.5/weather?id=" + item + "&mode=xml&appid=61d2bb72068a55593de62b7ff5e41b06&units=metric";
            String hData = Jsoup.connect(hurl).timeout(30000).execute().body();
            Document hdoc = Jsoup.parse(hData, "", Parser.xmlParser());
            Elements elms = hdoc.select("current");
            Elements elmstemp = elms.select("temperature");
            Elements elmscity = elms.select("city");
            Elements elmswind = elms.select("wind");
            Elements elmsspeed = elmswind.select("speed");
            Elements elmsweather = elms.select("weather");

            Varlik v = new Varlik();

            v.setTemp(elmstemp.attr("value"));
            v.setCity(elmscity.attr("name"));
            v.setWeather(elmsweather.attr("value"));
            v.setWind(elmsspeed.attr("name"));

            list.add(v);
            System.out.println("Timer Çalıştı!!");
            Methods m = new Methods();
            jTable1.setModel(m.tableDoldur(ls));

        } catch (Exception e) {
            System.err.println("Hata : " + e);
        }
        
                }
            }
        };
        
        
        Timer t = new Timer();
        t.schedule(tt, 1000,5000); //timertaskin içindeki run methodunu çalıştır, her 5 saniyide bir güncelleme yap

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("İl Seçim"));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("İller: ");

        jButton1.setText("Ekle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1)
                .addComponent(jButton1))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tablo"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ArrayList<Varlik> ls = new ArrayList<>();
    //ekleme butonu action
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //seçilen şehirin apideki idsini belirle
        if (jComboBox1.getSelectedItem() == "Adana") {
            id = "325363";
        } else if (jComboBox1.getSelectedItem() == "Adıyaman") {
            id = "325330";
        } else if (jComboBox1.getSelectedItem() == "Afyon") {
            id = "325303";
        } else if (jComboBox1.getSelectedItem() == "Ağrı") {
            id = "309647";
        } else if (jComboBox1.getSelectedItem() == "Amasya") {
            id = "752015";
        } else if (jComboBox1.getSelectedItem() == "Ankara") {
            id = "323786";
        } else if (jComboBox1.getSelectedItem() == "Antalya") {
            id = "323777";
        } else if (jComboBox1.getSelectedItem() == "Artvin") {
            id = "751817";
        } else if (jComboBox1.getSelectedItem() == "Aydın") {
            id = "322830";
        } else if (jComboBox1.getSelectedItem() == "Balıkesir") {
            id = "322165";
        } else if (jComboBox1.getSelectedItem() == "Bilecik") {
            id = "750598";
        } else if (jComboBox1.getSelectedItem() == "Bingöl") {
            id = "321082";
        } else if (jComboBox1.getSelectedItem() == "Bitlis") {
            id = "299582";//tatvan
        } else if (jComboBox1.getSelectedItem() == "Balıkesir") {
            id = "322830";
        } else if (jComboBox1.getSelectedItem() == "Bolu") {
            id = "750516";
        } else if (jComboBox1.getSelectedItem() == "Burdur") {
            id = "320392";
        } else if (jComboBox1.getSelectedItem() == "Bursa") {
            id = "750269";
        } else if (jComboBox1.getSelectedItem() == "Çanakkale") {
            id = "749780";
        } else if (jComboBox1.getSelectedItem() == "Çankırı") {
            id = "742657";//korgun ilcesi
        } else if (jComboBox1.getSelectedItem() == "Çorum") {
            id = "748879";
        } else if (jComboBox1.getSelectedItem() == "Denizli") {
            id = "317109";
        } else if (jComboBox1.getSelectedItem() == "Diyarbakır") {
            id = "316541";
        } else if (jComboBox1.getSelectedItem() == "Edirne") {
            id = "747712";
        } else if (jComboBox1.getSelectedItem() == "Elazığ") {
            id = "315808";
        } else if (jComboBox1.getSelectedItem() == "Erzincan") {
            id = "315373";
        } else if (jComboBox1.getSelectedItem() == "Erzurum") {
            id = "315368";
        } else if (jComboBox1.getSelectedItem() == "Gaziantep") {
            id = "314830";
        } else if (jComboBox1.getSelectedItem() == "Giresun") {
            id = "746881";
        } else if (jComboBox1.getSelectedItem() == "Gümüşhane") {
            id = "746425";
        } else if (jComboBox1.getSelectedItem() == "Hakkari") {
            id = "318137";
        } else if (jComboBox1.getSelectedItem() == "Hatay") {
            id = "311111";//iskenderun
        } else if (jComboBox1.getSelectedItem() == "Isparta") {
            id = "311073";
        } else if (jComboBox1.getSelectedItem() == "Mersin") {
            id = "1732826";
        } else if (jComboBox1.getSelectedItem() == "Istanbul") {
            id = "745044";
        } else if (jComboBox1.getSelectedItem() == "Izmir") {
            id = "311046";
        } else if (jComboBox1.getSelectedItem() == "Kars") {
            id = "743952";
        } else if (jComboBox1.getSelectedItem() == "Kastamonu") {
            id = "743882";
        } else if (jComboBox1.getSelectedItem() == "Kayseri") {
            id = "308464";
        } else if (jComboBox1.getSelectedItem() == "Kırklareli") {
            id = "743166";
        } else if (jComboBox1.getSelectedItem() == "Kırşehir") {
            id = "307515";
        } else if (jComboBox1.getSelectedItem() == "Kocaeli") {
            id = "742902";
        } else if (jComboBox1.getSelectedItem() == "Konya") {
            id = "306571";
        } else if (jComboBox1.getSelectedItem() == "Kütahya") {
            id = "305268";
        } else if (jComboBox1.getSelectedItem() == "Malatya") {
            id = "304922";
        } else if (jComboBox1.getSelectedItem() == "Manisa") {
            id = "304827";
        } else if (jComboBox1.getSelectedItem() == "Kahramanmaraş") {
            id = "310859";
        } else if (jComboBox1.getSelectedItem() == "Mardin") {
            id = "304797";
        } else if (jComboBox1.getSelectedItem() == "Muğla") {
            id = "304184";
        } else if (jComboBox1.getSelectedItem() == "Muş") {
            id = "304081";
        } else if (jComboBox1.getSelectedItem() == "Nevşehir") {
            id = "303831";
        } else if (jComboBox1.getSelectedItem() == "Niğde") {
            id = "303827";
        } else if (jComboBox1.getSelectedItem() == "Ordu") {
            id = "741100";
        } else if (jComboBox1.getSelectedItem() == "Rize") {
            id = "740483";
        } else if (jComboBox1.getSelectedItem() == "Sakarya") {
            id = "752850";
        } else if (jComboBox1.getSelectedItem() == "Samsun") {
            id = "740264";
        } else if (jComboBox1.getSelectedItem() == "Siirt") {
            id = "300822";
        } else if (jComboBox1.getSelectedItem() == "Sinop") {
            id = "739600";
        } else if (jComboBox1.getSelectedItem() == "Sivas") {
            id = "300619";
        } else if (jComboBox1.getSelectedItem() == "Tekirdağ") {
            id = "738927";
        } else if (jComboBox1.getSelectedItem() == "Tokat") {
            id = "738743";
        } else if (jComboBox1.getSelectedItem() == "Trabzon") {
            id = "738648";
        } else if (jComboBox1.getSelectedItem() == "Tunceli") {
            id = "298846";
        } else if (jComboBox1.getSelectedItem() == "Şanlıurfa") {
            id = "298333";
        } else if (jComboBox1.getSelectedItem() == "Uşak") {
            id = "298299";
        } else if (jComboBox1.getSelectedItem() == "Van") {
            id = "298117";
        } else if (jComboBox1.getSelectedItem() == "Yozgat") {
            id = "296562";
        } else if (jComboBox1.getSelectedItem() == "Zonguldak") {
            id = "737022";
        } else if (jComboBox1.getSelectedItem() == "Aksaray") {
            id = "324496";
        } else if (jComboBox1.getSelectedItem() == "Bayburt") {
            id = "750938";
        } else if (jComboBox1.getSelectedItem() == "Karaman") {
            id = "309527";
        } else if (jComboBox1.getSelectedItem() == "Kırıkkale") {
            id = "307654";
        } else if (jComboBox1.getSelectedItem() == "Batman") {
            id = "321836";
        } else if (jComboBox1.getSelectedItem() == "Şırnak") {
            id = "300640";
        } else if (jComboBox1.getSelectedItem() == "Bartın") {
            id = "751057";
        } else if (jComboBox1.getSelectedItem() == "Ardahan") {
            id = "751952";
        } else if (jComboBox1.getSelectedItem() == "Iğdır") {
            id = "311665";
        } else if (jComboBox1.getSelectedItem() == "Yalova") {
            id = "738025";
        } else if (jComboBox1.getSelectedItem() == "Karabük") {
            id = "744562";
        } else if (jComboBox1.getSelectedItem() == "Kilis") {
            id = "307864";
        } else if (jComboBox1.getSelectedItem() == "Osmaniye") {
            id = "303195";
        } else if (jComboBox1.getSelectedItem() == "Düzce") {
            id = "747764";
        }

        
        try {
            //xml linkine bağlan parse et 
            String hurl = "http://api.openweathermap.org/data/2.5/weather?id=" + id + "&mode=xml&appid=61d2bb72068a55593de62b7ff5e41b06&units=metric";
            String hData = Jsoup.connect(hurl).timeout(30000).execute().body();
            Document hdoc = Jsoup.parse(hData, "", Parser.xmlParser());
            Elements elms = hdoc.select("current");
            Elements elmstemp = elms.select("temperature");
            Elements elmscity = elms.select("city");
            Elements elmswind = elms.select("wind");
            Elements elmsspeed = elmswind.select("speed");
            Elements elmsweather = elms.select("weather");
            
            

            Varlik v = new Varlik();//varlik nesnesi oluşturuldu

            //nesne setter ları ile xmlden parse edilen değerleri nesneye doldur
            v.setTemp(elmstemp.attr("value"));
            v.setCity(elmscity.attr("name"));
            v.setWeather(elmsweather.attr("value"));
            v.setWind(elmsspeed.attr("name"));

            
            //eğer şehir listede varsa ekleme yapma ve kullanıcıya mesaj göster
            boolean kontrol = false;
            for (String item : citys) {
                if (item.equals(""+v.getCity())) {
                    JOptionPane.showMessageDialog(this, "Şehir listede ekli!");   
                    kontrol = true;
                    break;
                    
                }
            }
                //şehir listede değilse arrayliste nesneyi ekle, şehirler arrayine şehiri ekle
                //idler arrayine idyi ekle (Güncelleme için initComponents(); altındaki timertaskde lazım olucak)
                if (!kontrol) {
                ls.add(v);
                citys.add(""+v.getCity());
                ids.add(id);
            }
                
            Methods m = new Methods();
            jTable1.setModel(m.tableDoldur(ls));//tabloyu doldur

        } catch (Exception e) {
            System.err.println("Hata : " + e);
        }
        
        
        id = "";


    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
