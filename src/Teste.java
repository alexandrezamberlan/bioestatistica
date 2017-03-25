
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alexandrezamberlan
 */
public class Teste {

    public static void main(String a[]) {
        Set<String> tset = new TreeSet<String>();

        ArrayList alist = new ArrayList();
        alist.add(15);
        alist.add(1);
        alist.add(9);
        alist.add(2);
        alist.add(12);
        alist.add(3);
        alist.add(3);

        Util.ordenarListaPente(alist);
        /*
         for (int i = 0; i < alist.size(); i++) {
         System.out.println(alist.get(i));
         }
         */
        tset.addAll(alist);

        /*
         tset.add("china");
         tset.add("america");
         tset.add("britain");
         tset.add("zimbabwe");
         tset.add("india");
         tset.add("zimbabwe");
         tset.add("checksolvakia");
         tset.add("sri_lanka");
         */

        /*
         for (String str : tset) {
         System.out.println(str);
         }
         */
        DecimalFormat valor = new DecimalFormat("###.###");

        String resposta = valor.format(9.3988999);

        System.out.println(resposta);

    }

}
