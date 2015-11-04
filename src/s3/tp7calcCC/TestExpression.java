package s3.tp7calcCC;

    public class TestExpression {
       
        public static void main(String[] args)
        {
            Expression exp = new OperationBinaire('+',new Operande(1), new Operande(3));
            
            System.out.println("Expression:   "+exp);
            System.out.println("Postfix:   "+exp.postFix());
            System.out.println("Prefix:   "+exp.preFix());
            System.out.println("Infix:   "+exp.inFix());
            System.out.println("Valeur:   "+exp.getValeur());
            System.out.println("\n");
            
            Expression exp2 = new OperationBinaire('-',new Operande(25), new Operande(4));
            
            System.out.println("Expression:   "+exp2);
            System.out.println("Postfix:   "+exp2.postFix());
            System.out.println("Prefix:   "+exp2.preFix());
            System.out.println("Infix:   "+exp2.inFix());
            System.out.println("Valeur:   "+exp2.getValeur());
            System.out.println("\n");
            
            Expression exp3 = new OperationBinaire('*',new Operande(6), new Operande(7));
            
            System.out.println("Expression:   "+exp3);
            System.out.println("Postfix:   "+exp3.postFix());
            System.out.println("Prefix:   "+exp3.preFix());
            System.out.println("Infix:   "+exp3.inFix());
            System.out.println("Valeur:   "+exp3.getValeur());
            System.out.println("\n");
            
            Expression exp4 = new OperationBinaire('/',new Operande(10), new Operande(2));
            
            System.out.println("Expression:   "+exp4);
            System.out.println("Postfix:   "+exp4.postFix());
            System.out.println("Prefix:   "+exp4.preFix());
            System.out.println("Infix:   "+exp4.inFix());
            System.out.println("Valeur:   "+exp4.getValeur());
            System.out.println("\n");
            
            Expression exp5 = new OperationBinaire('^',new Operande(2), new Operande(8));
            
            System.out.println("Expression:   "+exp5);
            System.out.println("Postfix:   "+exp5.postFix());
            System.out.println("Prefix:   "+exp5.preFix());
            System.out.println("Infix:   "+exp5.inFix());
            System.out.println("Valeur:   "+exp5.getValeur());
            System.out.println("\n");
            
            Expression exp6 = new OperationUnaire('-',new Operande(2));
            
            System.out.println("Expression:   "+exp6);
            System.out.println("Postfix:   "+exp6.postFix());
            System.out.println("Prefix:   "+exp6.preFix());
            System.out.println("Infix:   "+exp6.inFix());
            System.out.println("Valeur:   "+exp6.getValeur());
            System.out.println("\n");
            
            Expression exp7 = new OperationUnaire('!',new Operande(-2));
            
            System.out.println("Expression:   "+exp7);
            System.out.println("Postfix:   "+exp7.postFix());
            System.out.println("Prefix:   "+exp7.preFix());
            System.out.println("Infix:   "+exp7.inFix());
            System.out.println("Valeur:   "+exp7.getValeur());
            System.out.println("\n");
            
            Syntax builder = new Syntax();
            Expression expN1 = builder.analyse("*5+4 3");
                
            
            
        }
      
    }
