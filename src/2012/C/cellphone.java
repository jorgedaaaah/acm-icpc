
import java.util.ArrayList;
import java.util.Scanner;

public class cellphone {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int it = scan.nextInt();
            Agenda ag = new Agenda();
            for (int i = 0; i < it; i++) {
                String word = scan.next();
                ag.agregarLetra(word);
            }
            String df = String.format("%.2f", ag.calcularPromedio(it));
            System.out.println(df.replace(",", "."));
        }
    }
}

class Agenda {

    Nodo agendaTotal;

    public Agenda() {
        agendaTotal = new Nodo();
    }

    public void agregarLetra(String word) {
        agregarLetra(agendaTotal, word);
    }
    private void agregarLetra(Nodo agenda, String word) {

        if (word.length() > 0) {
            char c = word.charAt(0);
            Nodo temp = new Nodo(c);

            if (!agenda.contains(temp)) {
                temp.cantLetras++;
                agregarLetra(temp, word.substring(1));
                agenda.addChild(temp);
            } else {
                agregarLetra(agenda.getNode(c), word.substring(1));
            }
        }
    }

    public void imprimir() {
        imprimir(agendaTotal);
    }

    private void imprimir(Nodo agenda) {
        for (Nodo n : agenda.child) {
            imprimir(n);
        }
    }

    public int sumarPalabras(Nodo agenda) {
        int suma = 0;
        for (Nodo n : agenda.child) {
            if (agenda.letter == '-' || agenda.cantLetras != n.cantLetras){
                suma+= n.cantLetras + sumarPalabras(n);
            }
            else{
                suma+= sumarPalabras(n);
            }
        }
        return suma;
    }

    public double calcularPromedio(int total) {
        int suma = sumarPalabras(agendaTotal);
        double value = (double) (suma) / total;
        return value;
    }
}

class Nodo {

    char letter;
    int cantLetras;
    ArrayList<Nodo> child;

    public Nodo() {
        letter = '-';
        child = new ArrayList();
        cantLetras = 0;
    }

    public Nodo(char c) {
        letter = c;
        child = new ArrayList();
        cantLetras = 0;
    }

    public Nodo getNode(char c) {
        for (Nodo n : child) {
            if (n.letter == c) {
                n.cantLetras++;
                return n;
            }
        }
        return null;
    }

    public boolean contains(Nodo n) {
        for (int i = 0; i < child.size(); i++) {
            if (child.get(i).letter == n.letter) {
                return true;
            }
        }
        return false;
    }

    public void addChild(Nodo n) {
        child.add(n);
    }
    
}
