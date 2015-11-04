package s3.tp8qsort;

public class test {
    public static void main(String[]args){
        //LANCER AVEC UN BREAKPOINT SUR LE SOP DERNIERE LIGNE
        Liste l = new ListeCons(10);
        Liste sorted= l.QS();
        l.afficher();
        sorted.afficher();
        System.out.println("lel");
    }
}
