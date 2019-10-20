package bo;

import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class Jeu {
    private Stack<Double> pile;
    private String calcul;
    private Boolean bool;

    public String getCalcul() {
        return calcul;
    }

    public void setCalcul(String calcul) {
        this.calcul = calcul;
    }

    public Stack<Double> getPile() {
        return pile;
    }

    public void setPile(Stack<Double> pile) {
        this.pile = pile;
    }

    public Jeu() {
        pile = new Stack<>();
        calcul = "";
        bool = true;
    }

    public Double random(Double min, Double max) {

        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    public int random(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }

    public void nbAleatoire(){
        Double r = random(0.0, 50.0);
        r = Math.floor(r * 100) / 100;
        pile.push(r);
        calcul = "" + r + "";
        System.out.println(r);
    }

    public void opeAleatoire(){
        Double num1 = pile.pop();
        Double num2 = pile.pop();
        int signe = random(0,3);
        switch (signe)
        {
            case 0:
                calcul = calcul + " + " + num2;
                num1 = num1 + num2;
                break;
            case 1:
                calcul = calcul + " - " + num2;
                num1 = num1 - num2;
                break;
            case 2:
                calcul = calcul + " * " + num2;
                num1 = num1 * num2;
                break;
            case 3:
                calcul = calcul + " / " + num2;
                num1 = num1 / num2;
                break;

        }
        pile.push(num1);
    }

    public void expression(int length) {
        nbAleatoire();
        for (int i = 0; i < length; i++) {
            if(pile.size() == 1 ){
                nbAleatoire();
            }else if(pile.size() >= 2){
                nbAleatoire();
                opeAleatoire();
            }
            opeAleatoire();
        }
    }
}
