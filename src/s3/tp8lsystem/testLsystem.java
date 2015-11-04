package s3.tp8lsystem;

import java.awt.*;



public class testLsystem
{

   public static void main( String [] args )
   {
      LSystem l = new LSystem();
      int nbDerivation = 4;
      for(int i=0;i<nbDerivation;i++){
          l.derivation();
      }

      l.interpretation();


   }

}
