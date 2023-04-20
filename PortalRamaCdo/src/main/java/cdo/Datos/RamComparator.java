package cdo.Datos;

import java.util.Comparator;

public class RamComparator implements Comparator<Articulos> {
    // override the compare() method
    public int compare(Articulos l1, Articulos l2)
    {
        if (l1.getNum_art_prov().equals(l2.getNum_art_prov())) {
            return 0;
        }
        else if (l1.getNum_art_prov().equals("9250")) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
