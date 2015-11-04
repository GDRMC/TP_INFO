package s3.tp8lsystem;

import java.util.HashMap;
import java.io.*;
import java.awt.Color;

public class LSystem {

    private String axiome;
    private HashMap<Character, String> regles;
    private String expCourante;

    public LSystem() {
        /* definition regle derivation */
        this.regles = new HashMap<Character, String>();

        this.axiome = "X+Y";

        this.regles.put('X', "X+Y++Y-X--XX-Y+");
        this.regles.put('Y', "-X+YY++Y+X--X-Y");
        this.regles.put('+', "+");
        this.regles.put('-', "-");

        this.expCourante = this.axiome;
    }

    public void derivation() {
        String nouvelleExp = "";
        char c;
        for (int i = 0; i < this.expCourante.length(); i++) {
            c = this.expCourante.charAt(i);
            nouvelleExp = nouvelleExp + this.regles.get(c);
        }
        this.expCourante = nouvelleExp;
        System.out.println(this.expCourante);
    }

    public void resetExp() {
        this.expCourante = this.axiome;
    }

    public void interpretation() {
        Logo l = new Logo(400, 300, 90, Color.black, Logo.PEN_DOWN, 6);
        // lire l'expression et interpreter les symboles...
        char c;
        for (int i = 0; i < this.expCourante.length(); i++) {
            c = this.expCourante.charAt(i);
            switch (c) {
                case 'X':
                    l.av();
                    break;
                case 'Y':
                    l.av();
                    break;
                case '+':
                    l.rotG(60);
                    break;
                case '-':
                    l.rotD(60);
                    break;
            }
        }

    }

    public int alea(int a, int b) {
        return (int) (Math.random() * (b - a + 1) + a);
    }

}
// Fractal
// axiome :"X"
// 'X'->"X+Y++Y-X--XX-Y+"
// 'Y'->"-X+YY++Y+X--X-Y"

// Plante
//  axiome ="X"
//  'X'->"F-[[X]+X]+F[+FX]-X"
//  'F'->"FF"
// Arbre
// axiome ="0"
// '0'->"1[-0]+0"
// '1'->,"11"
