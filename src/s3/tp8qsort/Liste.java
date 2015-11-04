package s3.tp8qsort;

import java.util.*;

public abstract class Liste {

    public abstract boolean estVide();

    public abstract int getPremier();

    public abstract Liste getReste();

    public abstract void afficher();

    public abstract boolean trouver(int val);

    public abstract int size();

    public abstract int somme();

    public abstract Liste placerFin(int val);

    public abstract Liste copie();

    public abstract Liste inferieurs(int s);

    public abstract Liste superieurs(int s);

    public abstract Liste concat(Liste L1);

    public abstract Liste QS();

    public abstract Liste inverser();

    public abstract Liste inserer(int s, int rang);

    public abstract void listeEnTab(ArrayList T);

}

//************************************************************************************************************
class ListeVide extends Liste // permet d'avoir une etiquette concrete permettant d'idenfier un arbre vide
{

    ListeVide() {
    }

    public boolean estVide() {
        return true;
    }

    public int getPremier() {
        return 0;
    }  //normalement impossible

    public Liste getReste() {
        return null;
    }

    public void afficher() {
        System.out.println();
    }

    public boolean trouver(int val) {
        return false;
    }

    public int somme() {
        return 0;
    }

    public int size() {
        return 0;
    }

    public Liste placerFin(int val) {
        return new ListeCons(val, new ListeVide());
    }

    public Liste copie() {
        return new ListeVide();
    }

    public Liste inferieurs(int s){
        return new ListeVide();
    }
    public Liste superieurs(int s){
        return new ListeVide();
    }
    public Liste QS(){
        return new ListeVide();
    }

    public Liste concat(Liste L1) {
        return L1.copie();
    }

    public Liste inverser() {
        return new ListeVide();
    }

    public Liste inserer(int s, int rang) {
        return new ListeCons(s, new ListeVide());
    }

    public void listeEnTab(ArrayList T) {

    }

}

//**********************************************************************************************************
class ListeCons extends Liste {

    private int valeur;
    private Liste suiv;

    public ListeCons(int val, Liste L) {
        this.valeur = val;
        this.suiv = L;
    }

    public ListeCons(int nbElements) {
        this.valeur = Alea(1, 100000);
        if(nbElements>0){
            this.suiv = new ListeCons(nbElements-1);
        } else {
            this.suiv = new ListeVide();
        }
    }

    public boolean estVide() {
        return false;
    }

    public int getPremier() {
        return this.valeur;
    }

    public Liste getReste() {
        return this.suiv;
    }

    public void afficher() {
        System.out.print(this.getPremier() + " ");
        this.getReste().afficher();
    }

    public boolean trouver(int val) {
        if (val == this.getPremier()) {
            return true;
        } else {
            return this.getReste().trouver(val);
        }
    }

    public int size() {
        return 1 + getReste().size();
    }

    public int somme() {
        return this.getPremier() + this.getReste().somme();
    }

    public Liste placerFin(int val) {
        return new ListeCons(this.getPremier(), this.getReste().placerFin(val));
    }

    public Liste copie() {
        return new ListeCons(getPremier(), getReste().copie());
    }

    public Liste inferieurs(int s) {
        if (this.getPremier() < s) {
            return new ListeCons(this.getPremier(), this.getReste().inferieurs(s));
        } else {
            return this.getReste().inferieurs(s);
        }
    }

    public Liste superieurs(int s) {
        if (this.getPremier() >= s) {
            return new ListeCons(this.getPremier(), this.getReste().superieurs(s));
        } else {
            return this.getReste().superieurs(s);
        }
    }

    public Liste QS() {
        int pivot = this.getPremier();
        Liste inf = this.getReste().inferieurs(pivot).QS();
        Liste sup = this.getReste().superieurs(pivot).QS();
        return inf.concat(new ListeCons(pivot, sup));
    }

    public Liste concat(Liste L1) {
        return new ListeCons(getPremier(), getReste().concat(L1));
    }

    public Liste inverser() {
        return getReste().inverser().placerFin(getPremier());
    }

    public Liste inserer(int s, int rang) {
        if (rang == 1) {
            return new ListeCons(s, getReste().copie());
        } else {
            return new ListeCons(getPremier(), getReste().inserer(s, rang - 1));
        }
    }

    public void listeEnTab(ArrayList T) {

    }

    private int Alea(int min, int max) {
        return (int) ((Math.random() * (max - min + 1)) + min);
    }

}
