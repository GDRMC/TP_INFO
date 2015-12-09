package s3.tp12;

// QT :: Noir | Blanc | (QT QT QT QT)
// QT :: Vide
public class LireQT {

    private ArbreQT A;
    private String s;  //chaine � analyser
    private int index;
    private boolean erreurDetect;

    public LireQT(String s) {
        this.s = s;
        index = 0;
        erreurDetect = false;

        A = QT();										// debut analyse
        if (erreurDetect) {
            A = new AQTVide();
        }
    }

    private ArbreQT QT() {
        char c = s.charAt(index);
        index++;

        switch (c) {
            case 'B':
                return new Blanc();
            case 'N':
                return new Noir();
            case '(':
                ArbreQT lel = new AQTCons(QT(),QT(),QT(),QT());
                c = s.charAt(index);
                
                if (c == ')'){
                    index++;
                    return lel;
                }
            default:
                System.out.println("Erreur Syntaxe caractère " + index + "  : " + s);
                erreurDetect = true;

        }
        return new AQTVide();  // si on arrive ici c'est qu'il y a eu une erreur	
    }

    public ArbreQT get() {
        return this.A;
    }

}
