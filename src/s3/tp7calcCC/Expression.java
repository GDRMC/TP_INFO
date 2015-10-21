package s3.tp7calcCC;

//
// <Expression>       ::= <Operande> | <OperationUnaire> | <OperationBinaire>
// <Operande>         ::= <entierRelatif>
// <entierRelatif>    ::= ['-'] '1'..'9' ['0'..'9']*
// <OperationUnaire>  ::= <OperateurUnaire> <Exp>
// <Exp>              ::= <Expression>
// <OperateurUnaire>  ::= '-'
// <OperationBinaire> ::= <ExpGauche> <OperateurBinaire> <ExpDroite>
// <ExpGauche>        ::= <Expression>
// <ExpDroite>        ::= <Expression>
// <OperateurBinaire> ::= '+' | '-' | '*' | '/'
//
public abstract class Expression {
    
    public abstract boolean estOperande();
    public abstract boolean estOperation();
    public abstract boolean estOperationUnaire();
    public abstract boolean estOperationBinaire();

    public abstract String toString();
    public abstract char getOperateur();
    public abstract int getValeur();
    public abstract String inFix();
    public abstract String postFix();
    public abstract String preFix();
}

//classe opération binaire
class OperationBinaire extends Expression {
    
    private Operande a;
    private Operande b;
    private char o;
    
    OperationBinaire(char o, Operande a, Operande b){
        this.a = a;
        this.b = b;
        this.o = o;
    }

    public int getValeur() { 
        int result = 0;
        switch(o){
            case '+':
                result = a.getValeur()+b.getValeur();
                break;
            case '-':
                result = a.getValeur()-b.getValeur();
                break;
            case '*':
                result = a.getValeur()*b.getValeur();
                break;
            case '/':
                result = a.getValeur()/b.getValeur();
                break;
            case '^':
                result = (int)Math.pow(a.getValeur(), b.getValeur());
                break;
        }
        return result;
    }
    
    public String inFix() { return "("+this.a.getValeur()+this.getOperateur()+this.b.getValeur()+")"; }
    public String preFix() { return this.o+" "+this.a.getValeur()+" "+this.b.getValeur(); }
    public String postFix() { return this.a.getValeur()+" "+this.b.getValeur()+" "+this.o; }

    public String toString() { return inFix(); }
    public char getOperateur() { return this.o; }
    public boolean estOperande() { return false; }
    public boolean estOperation() { return true; }
    public boolean estOperationUnaire() { return false; }
    public boolean estOperationBinaire() { return true;}
    
}

//classe opération binaire
class OperationUnaire extends Expression {
    
    private Operande a;
    private char o;
    
    OperationUnaire(char o, Operande a){
        this.a = a;
        this.o = o;
    }

    public int getValeur() { 
        int result = 0;
        switch(o){
            case '-':
                result = Math.negateExact(this.a.getValeur());
                break;
            case '!':
                if(a.getValeur()<0){
                    result = Math.abs((int)a.getValeur());
                } else {
                    result = a.getValeur();
                }
        }
        return result;
    }
    
    public String inFix() { return this.a.toString()+this.getOperateur(); }
    public String preFix() { return this.o+this.a.toString(); }
    public String postFix() { return this.a.toString()+this.o; }

    public String toString() { return inFix(); }
    public char getOperateur() { return this.o; }
    public boolean estOperande() { return false; }
    public boolean estOperation() { return true; }
    public boolean estOperationUnaire() { return false; }
    public boolean estOperationBinaire() { return true;}
    
}

//classe opérande
class Operande extends Expression {

    private int val;
    
    Operande(int i) {
        this.val = i;
    }

    public int getValeur() { return this.val; }
    public String inFix() { return String.valueOf(val); }
    public String preFix() { return String.valueOf(val); }
    public String postFix() { return String.valueOf(val); }

    public String toString() { return inFix(); }
    public char getOperateur() { return 'o'; }
    public boolean estOperande() { return true; }
    public boolean estOperation() { return false; }
    public boolean estOperationUnaire() { return false; }
    public boolean estOperationBinaire() { return false; }
    
}