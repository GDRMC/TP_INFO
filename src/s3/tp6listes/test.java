package s3.tp6listes;

public class test {
    public static void main(String[]args){
        Liste l = new ListeCons("A",new ListeCons("B", new ListeCons("C", new ListeCons("D", new ListeVide()))));
        l.afficheIt();
        System.out.println(l.somme());
        System.out.println(l.getPremier());
        System.out.println(l.longueur());
        System.out.println(l.trouver("C"));
    }
}
