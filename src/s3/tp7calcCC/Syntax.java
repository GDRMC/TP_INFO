/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.tp7calcCC;

public class Syntax {

    private String chaine;
    private int index;

    Syntax() {
        this.index = 0;
    }

    public Expression analyse(String s) {
        this.chaine = s;
        return exp();
    }

    private Expression exp() {
        if (this.index < this.chaine.length()) {
            if (chaine.charAt(index) == '+' || chaine.charAt(index) == '-' || chaine.charAt(index) == '*' || chaine.charAt(index) == '/') {
                
            }
        }
            // analyse et construction d'une expression
        return null;
    }
}
