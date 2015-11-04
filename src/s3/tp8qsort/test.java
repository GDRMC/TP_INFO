package s3.tp8qsort;

import java.util.ArrayList;

public class test {
    public static void main(String[]args){
        //LANCER AVEC UN BREAKPOINT SUR LE SOP DERNIERE LIGNE (OU PAS, au choix D:)
        Liste l = new ListeCons(10);
        Liste sorted= l.QS();
        l.afficher();
        sorted.afficher();
        ArrayList<Integer> tab = new ArrayList();
        sorted.listeEnTab(tab); //A BREAKPOINT POUR VOIR LE TABLEAU TRANQUILOU DANS LE DEBUGUEUR
    }
}
