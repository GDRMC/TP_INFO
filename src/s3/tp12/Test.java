package s3.tp12;

public class Test {
    public static void main(String[]args){
        ReprUnique D = new ReprUnique();
        ArbreQT a1 = D.getRef(new Noir());
        ArbreQT a2 = D.getRef(new Noir());
        
        LireQT lect = new LireQT("(BBB(NNNN))");
        ArbreQT A = lect.get();
        A.afficher();
        es();
        
        LireQT lect2 = new LireQT("(BN(NNNN)B)");
        ArbreQT B = lect2.get();
        B.afficher();
        es();
        
        LireQT lect3 = new LireQT("(BB(NNNN)(BBB(NNNN)))");
        ArbreQT C = lect3.get();
        C.afficher();
        es();
    }
    
    public static void es(){
        System.out.println();
    }
}
