package s3.tp8qsort;

import java.util.ArrayList;

//Ne marche pas à cause d'un caractère spécial dans le fichier mais totalement introuvable, et une stack overflow sur l'appel récursif de dicho().

public class QStore {

    public static final int N = 2100;   // Nombre d'elements dans la liste au depart
//---------------------------------------------------------------------------
    private ArrayList<Integer> t;
//---------------------------------------------------------------------------
    public int compteurDicho; // voir la dichotomie O(lg N )
//---------------------------------------------------------------------------

    QStore() {
        this.compteurDicho = 0;
        t = new ArrayList();
    }
//---------------------------------------------------------------------------

    public void exec() {
        Liste l = new ListeCons(20);
        Liste lsorted = l.QS();
        ArrayList<Integer> arrayS = new ArrayList();
        lsorted.listeEnTab(arrayS); //A BREAKPOINT POUR VOIR LE TABLEAU TRANQUILOU DANS LE DEBUGUEUR
        int valeurrecherchee = 80000;
        System.out.println("Valeur recherchée = " + valeurrecherchee);
        this.Dicho(valeurrecherchee, 1, 100000);
    }

// recherche Dichotomique dans le tableau -----------
    public boolean Dicho(int n, int iDebut, int iFin) {
        int value = ((iFin - iDebut) / 2) + iDebut;
        this.compteurDicho++;
        boolean isInTab = false; //variable de présence de l'élément dans le tableau (initialement à false)

        System.out.println("Appel " + compteurDicho + " - iDebut=" + iDebut + " - milieu=" + value + " - iFin=" + iFin);

        if (value < n) {
            //INFERIEUR
            Dicho(n, iDebut, value);
        } else if (value > n) {
            //SUPERIEUR
            Dicho(n, value, iFin);
        } else if (value == n){
            //VALEUR EGALE
            isInTab = true; //passe la variable de présence à true
        }
        if (isInTab) {
            System.out.println("Valeur trouvée sur value=" + value);
        } else {
            System.out.println("Valeur demandée introuvable...");
        }
        return isInTab;
    }

    public boolean estTrie() {
        int i = 0;
        boolean retour = true;
        while (i < t.size() && retour == false) {
            if (t.get(i) < t.get(i + 1)) {
                i++;
            } else {
                retour = false;
            }
        }
        return retour;
    }
}
