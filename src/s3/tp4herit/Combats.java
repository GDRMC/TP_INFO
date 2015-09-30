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
    File arene = new File();
    
    /**
     * CONSTRUCTEUR: Crée une arène de 4 combattants dispatchés dans 2 équipes. a et b l'une, et c et d dans l'autre. ATTENTION, insertion en croisé pour combat tour par tour !
     * @param a Combattant 1 equipe A
     * @param b Combattant 2 equipe A
     * @param c Combattant 1 equipe B
     * @param d Combattant 2 equipe B
     */
    Combats(Personnage a, Personnage b, Personnage c, Personnage d){
        this.arene.add(a); //A1
        this.arene.add(c); //B1
        this.arene.add(b); //A2
        this.arene.add(d); //B2
    }
}
