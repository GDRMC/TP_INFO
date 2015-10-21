package s3.tp6listes;

public abstract class Liste {

    public abstract boolean estVide(); //redefinition obligatoire
    public abstract String getPremier();
    public abstract Liste getReste();
    public abstract void afficher();
    public abstract void afficherInverse();
    public abstract void afficheIt();
    public abstract boolean rechercheIt(String val);
    public abstract String somme();
    public abstract int longueur();
    public abstract Liste copie();
    public abstract boolean trouver(String value);
    
}

class ListeVide extends Liste {

    ListeVide() {

    }

    public boolean estVide() {
        return true;
    }

    public String getPremier() {
        return null;
    }

    public Liste getReste() {
        return null;
    }

    public void afficheIt() {
        Liste l1 = this;
        while (!l1.estVide()) {
            System.out.print(l1.getPremier() + "");
            l1 = l1.getReste();
        }
    }

    public boolean rechercheIt(String val) {
        return false; //lel
    }

    public int longueur() {
        return 0;
    }

    public String somme() {
        return "";
    }

    public void afficher() {
        System.out.println("\n");
    }

    public Liste copie() {
        return new ListeVide();
    }

    public boolean trouver(String value) {
        return false;
    }

    public void afficherInverse() {
        
    }
}

class ListeCons extends Liste {

    private String valeur;
    private Liste suiv;

    ListeCons(String val, Liste L) {
        this.valeur = val;
        this.suiv = L;
    }

    public boolean estVide() {
        return false;
    }

    public String getPremier() {
        return this.valeur;
    }

    public Liste getReste() {
        return this.suiv;
    }

    public void afficheIt() {
        Liste l1 = this;
        while (!l1.estVide()) {
            System.out.println(l1.getPremier());
            l1 = l1.getReste();
        }
    }

    public boolean rechercheIt(String val) {
        Liste l1 = this;
        while (!l1.estVide() && l1.getPremier() != val) {
            l1 = l1.getReste();
        }
        return !l1.estVide();
    }

    public int longueur() {
        return 1 + this.getReste().longueur();
    }

    public String somme() {
        return this.getPremier() + this.getReste().somme();
    }

    public void afficher() {
        System.out.print(this.getPremier());
        this.getReste().afficheIt();
    }
    
    public void afficherInverse(){
        
    }

    public Liste copie() {
        return new ListeCons(this.getPremier(), this.getReste().copie());
    }

    public boolean trouver(String value) {
        if (this.valeur == value){
            return true;
        } else {
            this.trouver(value);
            return false;
        }
    }

}