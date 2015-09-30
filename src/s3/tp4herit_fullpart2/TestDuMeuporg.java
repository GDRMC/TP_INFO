/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.tp4herit_fullpart2;

/**
 *
 * @author USER
 */
public class TestDuMeuporg {
    
    public static void main(String[]args){
        Chevalier link = new Chevalier(70,2,2);
        Excalibur machete = new Excalibur(60,3,3);
        Enchanteur gandalf = new Enchanteur(55,2,4);
        Truqueur frodon = new Truqueur(50,2,3);
        
        disp(link);
        disp(machete);
        disp(gandalf);
        disp(frodon);
        
        Combats howlingAbyss = new Combats(link,frodon,machete,gandalf);
        howlingAbyss.ouvrirArene();
        char result = howlingAbyss.combat();
        if(result=='A'){
            System.out.println("\nL'équipe A est déclarée gagnante !");
        } else if(result=='B'){
            System.out.println("\nL'équipe B est déclarée gagnante !");
        } else {
            System.out.println("\nProblem ? ( ͡° ͜ʖ ͡°)");
        }
        
    }
    
    public static void disp(Personnage e){
        System.out.println(e.toString());
    }
}
