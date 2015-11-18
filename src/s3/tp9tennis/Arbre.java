package s3.tp9tennis;

public abstract class Arbre {

    public abstract String getRacine();

    public abstract Arbre getAg();

    public abstract Arbre getAd();

    public abstract void setRacine(String s);

    public abstract void setAg(Arbre Ag);

    public abstract void setAd(Arbre Ad);

    public abstract boolean estVide();

    public abstract void afficher();

	//public abstract String lePlusAGauche();
	//public abstract Arbre supprimer( String val );
	//public abstract boolean trouver( String val );
    public abstract boolean estFeuille();

	//public abstract int nbFeuilles();
    public abstract int nbNoeuds();

    public abstract int hauteur();

	//public abstract boolean insereFeuille( String valeur);  //specif tournoi
	//public abstract void placerGagnant( String s);  // specif tournoi
}

class ArbreVide extends Arbre {

    ArbreVide() {
    }

    public String getRacine() {
        return null;
    }

    public Arbre getAg() {
        return this;
    }

    public Arbre getAd() {
        return this;
    }

    public void setRacine(String s) {
    }

    public void setAg(Arbre Ag) {
    }

    public void setAd(Arbre Ad) {
    }

    public boolean estVide() {
        return true;
    }

    public void afficher() {
        // System.out.print(" vide ");
    }

    public boolean estFeuille() {
        return false;
    }

    public int nbNoeuds() {
        return 0;
    }

    public int hauteur() {
        return 0;
    }

}

class ArbreCons extends Arbre {

    private String racine;
    private Arbre Ag;
    private Arbre Ad;

    public boolean estVide() {
        return false;
    }

    ArbreCons(String val, Arbre Ag, Arbre Ad) {
        this.racine = val;
        this.Ag = Ag;
        this.Ad = Ad;
    }

    ArbreCons(String val) {
        this.racine = val;
        this.Ag = new ArbreVide();
        this.Ad = new ArbreVide();
    }

    public String getRacine() {
        return this.racine;
    }

    public Arbre getAg() {
        return this.Ag;
    }

    public Arbre getAd() {
        return this.Ad;
    }

    public void setRacine(String s) {
        this.racine = s;
    }

    public void setAg(Arbre Ag) {
        this.Ag = Ag;
    }

    public void setAd(Arbre Ad) {
        this.Ad = Ad;
    }

    public boolean estFeuille() {
        return this.getAg().estVide() && this.getAd().estVide();
    }

    public void afficher() {
        System.out.print(this.getRacine() + " ");
        this.getAg().afficher();
        this.getAd().afficher();
    }

    public int nbNoeuds() {
        int nfg = 0, nfd = 0;
        nfg = getAg().nbNoeuds();
        nfd = getAd().nbNoeuds();
        return (1 + nfg + nfd);
    }

    public int hauteur() {
        int nfg = 0, nfd = 0;
        nfg = 1 + getAg().hauteur();
        nfd = 1 + getAd().hauteur();
        return Math.max(nfg, nfd);
    }

}
