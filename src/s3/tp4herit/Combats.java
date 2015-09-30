/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.tp4herit;

/**
 * Classe Combats, crée un combat sur le terrain entre 2 équipes de 2 combattants
 * @author USER
 */
public class Combats {
    Personnage a;
    Personnage b;
    Personnage c;
    Personnage d;
    
    File equipe1;
    File equipe2;
    
    /**
     * CONSTRUCTEUR: Crée une arène de 4 combattants dispatchés dans 2 équipes. a et b l'une, et c et d dans l'autre. ATTENTION, insertion en croisé pour combat tour par tour !
     * @param a Combattant 1 equipe A
     * @param b Combattant 2 equipe A
     * @param c Combattant 1 equipe B
     * @param d Combattant 2 equipe B
     */
    Combats(Personnage a, Personnage b, Personnage c, Personnage d){
        this.a=a; //A1
        this.b=b; //A2
        this.c=c; //B1
        this.d=d; //B2
    }
    
    public void ouvrirArene(){
        this.equipe1 = new File();
        this.equipe2 = new File();
        equipe1.add(a);
        equipe1.add(b);
        equipe2.add(c);
        equipe2.add(d);
        
        System.out.println("\n\nCréation de l'arène:\n---Composition des équipes:---\n");
        System.out.println("-Equipe A:-\n");
        System.out.println(a+"\n");
        System.out.println(b+"\n");
        System.out.println("-Equipe B:-\n");
        System.out.println(c+"\n");
        System.out.println(d);
        System.out.println("------------------------------");
    }
    
    public char combat(){
        System.out.println("\n\n-Début du combat !-");
        File arene = new File();
        boolean aEnVie = true;
        boolean bEnVIe = true;
        while((a.getVie()>0||b.getVie()>0)&&(c.getVie()>0||d.getVie()>0)){
            //importe le premier combattant de la file
            Personnage cbt1 = equipe1.get();
            Personnage cbt2 = equipe2.get();
            int degats1 = cbt1.attaque();
            int degats2 = cbt2.attaque();
            if(degats1 > degats2){
                System.out.println("Combattant équipe A type "+cbt1.getType()+" attaque combattant équipe B type "+cbt2.getType());
                cbt2.blesse();
                if(cbt2.getVie()>0){
                    equipe2.add(cbt2);
                    equipe1.add(cbt1);
                } else {
                    System.out.println("Combattant équipe B type "+cbt2.getType()+" est mort des suites de ses blessures...");
                    equipe1.add(cbt1);
                }
            }else if(degats2 > degats1){
                System.out.println("Combattant équipe B type "+cbt2.getType()+" attaque combattant équipe A type "+cbt1.getType());
                cbt1.blesse();
                if(cbt1.getVie()>0){
                    equipe1.add(cbt1);
                    equipe2.add(cbt2);
                } else {
                    System.out.println("Combattant équipe A type "+cbt1.getType()+" est mort des suites de ses blessures...");
                    equipe2.add(cbt2);
                }
            } else {
                System.out.println("Les dégats sont annulés... D:");
                equipe1.add(cbt1);
                equipe2.add(cbt2);
            }
        }
        
        if(a.getVie()<=0&&b.getVie()<=0){
            System.out.println("\n\nL'équipe A est décimée...");
            System.out.println("- Fin du combat ! -");
            resultTab();
            return 'B';
        } else if(c.getVie()<=0&&d.getVie()<=0) {
            System.out.println("\n\nL'équipe B est décimée...");
            resultTab();
            
            return 'A';
        } else {
            System.out.println("\n\nErreur inattendue O_o");
            System.out.println("- Fin du combat ! -");
            resultTab();
            return 'E';
        }
    }
    
    public void resultTab(){
        System.out.println("\n\nRésultats du combat:\n");
        System.out.println("-Equipe A:-\n");
        System.out.println(a+"\n");
        System.out.println(b+"\n");
        System.out.println("-Equipe B:-\n");
        System.out.println(c+"\n");
        System.out.println(d);
        System.out.println("------------------------------");
    }
}
