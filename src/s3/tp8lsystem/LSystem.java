package s3.tp8lsystem;

import java.util.HashMap;
import java.io.*;
import java.awt.Color;

public class LSystem
{

   private String axiome;
   private HashMap <Character, String> regles;
   private String expCourante;

   public LSystem()
   {
      /* definition regle derivation */
      this.regles = new HashMap <Character, String> ();




      this.expCourante = this.axiome;
   }

   public void derivation()
   {
      String nouvelleExp="";




      this.expCourante = nouvelleExp;
      System.out.println( this.expCourante );
   }

   public void resetExp()
   {
      this.expCourante = this.axiome;
   }


   public void interpretation()
   {
      Logo l = new Logo( 400, 300, 90, Color.black, Logo.PEN_DOWN, 6 );
      // lire l'expression et interpreter les symboles...

   }

   public int alea(int a, int b )
   {
      return (int) (Math.random()*(b-a+1)+a);
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
