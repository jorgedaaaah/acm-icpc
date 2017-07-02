#include <iostream>
#include <string>
using namespace std;

int main(){
    int casos;
    cin >> casos;
    for (int i = 0; i<casos; i++){
        if(i!= 0){
            cout << endl;
        }
        int cartas [52];
        for (int j = 0; j<52;j++){
            cartas[j] = j;
        }
        char espacio;
        int jugadas;
        cin >> jugadas;
        int arr[jugadas][52];
        for (int j = 0; j<jugadas ; j++){
            for (int k = 0; k<52; k++){
                int aux;
                cin >> aux;
                if (aux != k+1)
                    arr[j][k] = aux;
                else
                    arr[j][k] = -1;
            }
        }
        int posicion;
        int auxCartas [52];
        for (int j = 0; j<52;j++){
            auxCartas[j] = cartas[j];

        }

        while( cin >> posicion ){
            int cont = 0;
            for (int j = 0; j<52;j++){
                if (arr[posicion-1][j] != -1){
                    auxCartas[cont] = cartas[arr[posicion-1][j]-1];
                }
                cont++;
            }
            //Actualizar las cartas
            for (int j = 0; j<52;j++){
                cartas[j] = auxCartas[j];
            }

        }
        string palabras [] = {" of Clubs", " of Diamonds", " of Hearts", " of Spades"};

        for (int j = 0; j<52; j++){

            int value = cartas[j];
            int trunc = (int)((value)/13);
            value++;
            if (value == 10 || value == 23|| value == 36 || value == 49){
                cout << "Jack" << palabras[trunc] << endl;
            }
            else{
                if (value == 11 || value == 24|| value == 37 || value == 50){
                    cout << "Queen" << palabras[trunc] << endl;
                }
                else{
                    if (value == 12 || value == 25|| value == 38 || value == 51){
                        cout << "King" << palabras[trunc] << endl;
                    }
                    else{
                        if (value == 13 || value == 26|| value == 39 || value == 52){
                            cout << "Ace" << palabras[trunc] << endl;
                        }
                        else{
                            if(trunc == 1){
                                cout << value-12 << palabras[trunc] << endl;
                            }
                            else{
                                if(trunc == 2){
                                    cout << value-25 << palabras[trunc] << endl;
                                }
                                else{
                                    if(trunc == 3){
                                        cout << value-38 << palabras[trunc] << endl;
                                    }
                                    else{
                                        cout << value+1 << palabras[trunc] << endl;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
