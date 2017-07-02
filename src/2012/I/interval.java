
import java.util.Scanner;

class Nodo {

    int value;
    int min, max;
    Nodo izq;
    Nodo der;

    public Nodo() {
        izq = der = null;
        min = max = 0;
        value = 1;
    }

    public Nodo(int min, int max) {
        izq = der = null;
        value = 1;
        this.min = min;
        this.max = max;
    }
}

class Arbol {

    Nodo nodo;
    int maxCantidad;

    public Arbol(int maxCantidad) {
        this.nodo = new Nodo(1, maxCantidad);
        this.maxCantidad = maxCantidad;
    }

    private void insertar(Nodo aux, int value, int pos, int left, int right) {
        int middle = (int) ((left + right) / 2);
        Nodo temp;
        if (aux.izq == null && aux.der == null) {
            if (left == right) {
                aux.min = pos;
                aux.max = pos;
                aux.value = value > 0 ? 1 : (value < 0 ? -1 : 0);
            } else {

                if (pos <= middle) {
                    temp = new Nodo(left, middle);
                    aux.izq = temp;
                    insertar(aux.izq, value, pos, left, middle);
                } else {
                    temp = new Nodo(middle + 1, right);
                    aux.der = temp;
                    insertar(aux.der, value, pos, middle + 1, right);
                }
            }
        } else {
            if (pos <= middle) {
                if (aux.izq == null) {
                    temp = new Nodo(left, middle);
                    aux.izq = temp;
                }
                insertar(aux.izq, value, pos, left, middle);
            } else {
                if (aux.der == null) {
                    temp = new Nodo(middle + 1, right);
                    aux.der = temp;
                }
                insertar(aux.der, value, pos, middle + 1, right);
            }
        }
        aux.value
                = aux.izq != null && aux.der != null
                        ? aux.izq.value * aux.der.value
                        : (aux.izq != null ? aux.izq.value 
                        : (aux.der != null ? aux.der.value : aux.value));
    }
    
    private void edit (Nodo aux, int pos, int newValue, int izq, int der){
        if (aux.min == aux.max && aux.min == pos){
            aux.value = newValue > 0 ? 1 : (newValue < 0 ? -1 : 0);
        }
        else{
            int middle = (int)((izq+der)/2);
            if (pos <= middle){
                edit(aux.izq, pos, newValue, izq, middle);
            }
            else{
                edit(aux.der, pos, newValue, middle+1, der);
            }
        }
        aux.value
                = aux.izq != null && aux.der != null
                        ? aux.izq.value * aux.der.value
                        : (aux.izq != null ? aux.izq.value 
                        : (aux.der != null ? aux.der.value : aux.value));
    }
    
    public void edit (int pos, int newValue){
        edit (nodo, pos, newValue, 1, maxCantidad);
    }
    
    private int query(Nodo aux, int izq, int der, int oLeft, int oRight){
        if (izq >= oLeft && der <= oRight){
            return aux.value;
        }
        else{
            if (der < oLeft || izq > oRight){
                return 1;
            }
            else{
                int middle = (int)((izq+der)/2);
                int vLeft = aux.izq != null ? query(aux.izq, izq, middle, oLeft, oRight) : 1;
                int vRight = aux.der != null ? query(aux.der, middle+1, der, oLeft, oRight) : 1;
                return vLeft * vRight;
            }
        }
    }
    
    public int query(int left, int right){
        return query (nodo, 1, maxCantidad, left, right);
    }

    private void imprimir(Nodo aux) {
        System.out.println("[" + aux.min + "," + aux.max + "]: " + aux.value);
        if (aux.izq != null) {
            imprimir(aux.izq);
        }
        if (aux.der != null) {
            imprimir(aux.der);
        }
    }
    
    public void imprimir(){
        imprimir(nodo);
    }
    

    public void insertar(int pos, int value) {
        insertar(nodo, value, pos, 1, maxCantidad);
    }
}

public class interval {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            
            int N = scan.nextInt();
            int K = scan.nextInt();
            Arbol arbol = new Arbol(N);
            for (int i = 1; i<= N; i++){
                arbol.insertar(i, scan.nextInt());
            }
            for (int i = 0; i<K ; i++){
                char ch = scan.next().charAt(0);
                if (ch == 'C'){
                    arbol.edit(scan.nextInt(), scan.nextInt());
                }
                else{
                    //arbol.imprimir();
                    int res = arbol.query(scan.nextInt(), scan.nextInt());
                    if (res == 1){
                        System.out.print("+");
                    }
                    else{
                        if (res == -1){
                            System.out.print("-");
                        }
                        else{
                            System.out.print(res);
                        }
                    }
                }
                
            }
            System.out.println("");
        }
    }
}
