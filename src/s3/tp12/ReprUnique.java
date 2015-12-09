package s3.tp12;

import java.util.ArrayList;

public class ReprUnique {

    private ArrayList<ArbreQT> dico;

    public ReprUnique() {
        dico = new ArrayList();
    }

    public ArbreQT getRef(ArbreQT a) {
        ArbreQT rep = a;
        boolean found = false;
        int cpt = 0;
        while(!found&&cpt<dico.size()){
            if(a.equals(this.dico.get(cpt))){
                found = true;
                rep = dico.get(cpt);
            }
            cpt++;
        }
        if(!found){
            this.dico.add(rep);
        }
        return rep;
    }
}
