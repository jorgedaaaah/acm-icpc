#include <iostream>

using namespace std;

class Nodo {

    public:
        int value;
        int min, max;
        Nodo *izq;
        Nodo *der;

        Nodo() {
            izq = der = NULL;
            min = max = 0;
            value = 1;
        }

        Nodo(int min, int max) {
            izq = der = NULL;
            value = 1;
            this->min = min;
            this->max = max;
        }
};

class Arbol {

    private:
        void insertar(Nodo *aux, int value, int pos, int left, int right) {
            int middle = (int) ((left + right) / 2);
            Nodo *temp;
            if (aux->izq == NULL && aux->der == NULL) {
                if (left == right) {
                    aux->min = pos;
                    aux->max = pos;
                    aux->value = value > 0 ? 1 : (value < 0 ? -1 : 0);
                } else {

                    if (pos <= middle) {
                        temp = new Nodo(left, middle);
                        aux->izq = temp;
                        insertar(aux->izq, value, pos, left, middle);
                    } else {
                        temp = new Nodo(middle + 1, right);
                        aux->der = temp;
                        insertar(aux->der, value, pos, middle + 1, right);
                    }
                }
            } else {
                if (pos <= middle) {
                    if (aux->izq == NULL) {
                        temp = new Nodo(left, middle);
                        aux->izq = temp;
                    }
                    insertar(aux->izq, value, pos, left, middle);
                } else {
                    if (aux->der == NULL) {
                        temp = new Nodo(middle + 1, right);
                        aux->der = temp;
                    }
                    insertar(aux->der, value, pos, middle + 1, right);
                }
            }
            aux->value
                    = aux->izq != NULL && aux->der != NULL
                            ? aux->izq->value * aux->der->value
                            : (aux->izq != NULL ? aux->izq->value
                            : (aux->der != NULL ? aux->der->value : aux->value));
        }

        void edit (Nodo *aux, int pos, int newValue, int izq, int der){
            if (aux->min == aux->max && aux->min == pos){
                aux->value = newValue > 0 ? 1 : (newValue < 0 ? -1 : 0);
            }
            else{
                int middle = (int)((izq+der)/2);
                if (pos <= middle){
                    edit(aux->izq, pos, newValue, izq, middle);
                }
                else{
                    edit(aux->der, pos, newValue, middle+1, der);
                }
            }
            aux->value
                    = aux->izq != NULL && aux->der != NULL
                            ? aux->izq->value * aux->der->value
                            : (aux->izq != NULL ? aux->izq->value
                            : (aux->der != NULL ? aux->der->value : aux->value));
        }



        int query(Nodo *aux, int izq, int der, int oLeft, int oRight){
            if (izq >= oLeft && der <= oRight){
                return aux->value;
            }
            else{
                if (der < oLeft || izq > oRight){
                    return 1;
                }
                else{
                    int middle = (int)((izq+der)/2);
                    int vLeft = aux->izq != NULL ? query(aux->izq, izq, middle, oLeft, oRight) : 1;
                    int vRight = aux->der != NULL ? query(aux->der, middle+1, der, oLeft, oRight) : 1;
                    return vLeft * vRight;
                }
            }
        }
        void imprimir(Nodo *aux) {
            cout << "[" << aux->min << "," << aux->max << "]: " << aux->value<< endl;
            if (aux->izq != NULL) {
                imprimir(aux->izq);
            }
            if (aux->der != NULL) {
                imprimir(aux->der);
            }
        }

    public:
        Nodo *nodo;
        int maxCantidad;

        Arbol(int maxCantidad) {
            this->nodo = new Nodo(1, maxCantidad);
            this->maxCantidad = maxCantidad;
        }
        void edit (int pos, int newValue){
            edit (nodo, pos, newValue, 1, maxCantidad);
        }
        int query(int left, int right){
            return query (nodo, 1, maxCantidad, left, right);
        }

        void imprimir(){
            imprimir(nodo);
        }
        void insertar(int pos, int value) {
            insertar(nodo, value, pos, 1, maxCantidad);
        }


};



int main() {
    int N,K;
    while (cin >> N >> K) {
        Arbol *arbol = new Arbol(N);
        for (int i = 1; i<= N; i++){
            int V;
            cin >> V;
            arbol->insertar(i, V);
        }
        for (int i = 0; i<K ; i++){
            char ch ;
            cin>> ch;
            int P, V;
            if (ch == 'C'){

                cin >> P >> V;
                arbol->edit(P, V);
            }
            else{
                //arbol.imprimir();
                cin >> P >> V;
                int res = arbol->query(P,V);
                if (res == 1){
                    cout << "+" ;
                }
                else{
                    if (res == -1){
                        cout << "-";
                    }
                    else{
                        cout << res;
                    }
                }
            }

        }
        cout << endl;
    }
    return 0;
}

