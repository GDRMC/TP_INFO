package s3.tp8qsort;

import java.util.ArrayList;

public class QStore {

    public static final int N = 2100;   // Nombre d'elements dans la liste au depart
//---------------------------------------------------------------------------
    private ArrayList<Integer> T;
//---------------------------------------------------------------------------
    public int compteurDicho; // voir la dichotomie O(lg N )
//---------------------------------------------------------------------------

    QStore() {
        this.compteurDicho = 0;
        T = new ArrayList();
    }
//---------------------------------------------------------------------------

    public void exec() {
	// test
    }

// recherche Dichotomique dans le tableau -----------
    public boolean Dicho(int n, int iDebut, int iFin) {

    }

// methode EstTri� ----------------------------------
    public boolean estTrie() {
        return false;
    }

}
