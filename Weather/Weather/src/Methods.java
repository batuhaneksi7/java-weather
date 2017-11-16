
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class Methods {

    //comboboxdaki illeri doldurma fonk.
    public DefaultComboBoxModel comboboxDoldur() {

        DefaultComboBoxModel combo = new DefaultComboBoxModel();

        combo.addElement("Adana");
        combo.addElement("Adıyaman");
        combo.addElement("Afyon");
        combo.addElement("Ağrı");
        combo.addElement("Amasya");
        combo.addElement("Ankara");
        combo.addElement("Antalya");
        combo.addElement("Artvin");
        combo.addElement("Aydın");
        combo.addElement("Balıkesir");
        combo.addElement("Bilecik");
        combo.addElement("Bingöl");
        combo.addElement("Bitlis");
        combo.addElement("Bolu");
        combo.addElement("Burdur");
        combo.addElement("Bursa");
        combo.addElement("Çanakkale");
        combo.addElement("Çankırı");
        combo.addElement("Çorum");
        combo.addElement("Denizli");
        combo.addElement("Diyarbakır");
        combo.addElement("Edirne");
        combo.addElement("Elazığ");
        combo.addElement("Erzincan");
        combo.addElement("Erzurum");
        combo.addElement("Eskişehir");
        combo.addElement("Gaziantep");
        combo.addElement("Giresun");
        combo.addElement("Gümüşhane");
        combo.addElement("Hakkari");
        combo.addElement("Hatay");
        combo.addElement("Isparta");
        combo.addElement("Mersin");
        combo.addElement("Istanbul");
        combo.addElement("Izmir");
        combo.addElement("Kars");
        combo.addElement("Kastamonu");
        combo.addElement("Kayseri");
        combo.addElement("Kırklareli");
        combo.addElement("Kırşehir");
        combo.addElement("Kocaeli");
        combo.addElement("Konya");
        combo.addElement("Kütahya");
        combo.addElement("Malatya");
        combo.addElement("Manisa");
        combo.addElement("Kahramanmaraş");
        combo.addElement("Mardin");
        combo.addElement("Muğla");
        combo.addElement("Muş");
        combo.addElement("Nevşehir");
        combo.addElement("Niğde");
        combo.addElement("Ordu");
        combo.addElement("Rize");
        combo.addElement("Sakarya");
        combo.addElement("Samsun");
        combo.addElement("Siirt");
        combo.addElement("Sinop");
        combo.addElement("Sivas");
        combo.addElement("Tekirdağ");
        combo.addElement("Tokat");
        combo.addElement("Trabzon");
        combo.addElement("Tunceli");
        combo.addElement("Şanlıurfa");
        combo.addElement("Uşak");
        combo.addElement("Van");
        combo.addElement("Yozgat");
        combo.addElement("Zonguldak");
        combo.addElement("Aksaray");
        combo.addElement("Bayburt");
        combo.addElement("Karaman");
        combo.addElement("Kırıkkale");
        combo.addElement("Batman");
        combo.addElement("Şırnak");
        combo.addElement("Bartın");
        combo.addElement("Ardahan");
        combo.addElement("Iğdır");
        combo.addElement("Yalova");
        combo.addElement("Karabük");
        combo.addElement("Kilis");
        combo.addElement("Osmaniye");
        combo.addElement("Düzce");
        

        return combo; //combobox modelini döndür
    }

    //table doldur fonk.
    public DefaultTableModel tableDoldur(ArrayList<Varlik> ls) {

        DefaultTableModel table = new DefaultTableModel();

        //sütunları ekle
        table.addColumn("Şehir");
        table.addColumn("Sıcaklık");
        table.addColumn("Rüzgar");
        table.addColumn("Hava Durumu");

        //satırları ekle
        for (Varlik l : ls) {
            table.addRow(new String[]{l.getCity(), l.getTemp(), l.getWind(), l.getWeather()});
        }

        return table; //table modelini döndür
    }
    
  

}
