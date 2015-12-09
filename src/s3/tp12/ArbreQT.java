package s3.tp12;

public abstract class ArbreQT {

    public abstract void afficher();

    public abstract boolean equals(ArbreQT a);
}

class AQTVide extends ArbreQT {

    public AQTVide() {
    }

    public void afficher() {
    }

    public boolean equals(ArbreQT a) {
        if (a instanceof AQTVide) {
            return true;
        } else {
            return false;
        }
    }
}

class AQTCons extends ArbreQT {

    private ArbreQT NO, NE, SO, SE;

    public AQTCons(ArbreQT no, ArbreQT ne, ArbreQT so, ArbreQT se) {
        this.NO = no;
        this.NE = ne;
        this.SO = so;
        this.SE = se;
    }

    public ArbreQT getNO() {
        return this.NO;
    }

    public ArbreQT getNE() {
        return this.NE;
    }

    public ArbreQT getSO() {
        return this.SO;
    }

    public ArbreQT getSE() {
        return this.SE;
    }

    public void afficher() {
        System.out.print("(");
        this.NO.afficher();
        this.NE.afficher();
        this.SO.afficher();
        this.SE.afficher();
        System.out.print(")");
    }

    public boolean equals(ArbreQT a) {
        AQTCons aa = (AQTCons) a;
        return (aa.getNO().equals(this.NO) && aa.getNE().equals(this.NE) && aa.getSO().equals(this.SO) && aa.getSE().equals(this.SE));
    }

}

class Blanc extends ArbreQT {

    public Blanc() {
    }

    public void afficher() {
        System.out.print(" B ");
    }

    public boolean equals(ArbreQT a) {
        if (a instanceof Blanc) {
            return true;
        } else {
            return false;
        }
    }

}

class Noir extends ArbreQT {

    public Noir() {
    }

    public void afficher() {
        System.out.print(" N ");
    }

    public boolean equals(ArbreQT a) {
        if (a instanceof Noir) {
            return true;
        } else {
            return false;
        }
    }

}
