package s3.tp12;

public class Test {
    public static void main(String[]args){
        ReprUnique D = new ReprUnique();
        ArbreQT a1 = D.getRef(new Noir());
        ArbreQT a2 = D.getRef(new Noir());
        a1.afficher();
        
        LireQT lect = new LireQT("(BBB(NNNN))");
        ArbreQT A = lect.get();
    }
}
