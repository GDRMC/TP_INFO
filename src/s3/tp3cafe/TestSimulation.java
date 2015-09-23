/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.tp3cafe;

/**
 *
 * @author USER
 */
public class TestSimulation {
    
    public static void main(String[]args){
        Cafe leBonCafe = new Cafe("McCafé",16);
        leBonCafe.ouverture(3);
        leBonCafe.gestion();
    }
    
}
