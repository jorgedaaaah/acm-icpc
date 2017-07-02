#include <iostream>
#include <cmath>
//#include <set>
#include <map>
#include <algorithm>

using namespace std;

map<int, int>functions;
//set<int> posFunc;

long long *BValues;
int L,N,P,B;

/*
set<int> orderedFunction(int rangeLeft, int rangeRight){
    set<int> result;
    set<int>::iterator it;
    for (it = posFunc.begin(); it != posFunc.end(); it++ ){
        if (*it >= rangeLeft && *it <= rangeRight){
            result.insert(*it);
        }
    }
    return result;
}*/

/*
void updateBValues(){
    BValues[0] = 1;
    for (int i = 1; i<L;i++){
        BValues[i]=(B*BValues[i-1])%P;
    }
}*/

int main(){

    cin >> B >> P >> L >> N;
    while (B!= 0 && P != 0 && L != 0 && N != 0){
        char OP;
        //functions= new int [L];
        BValues = new long long [L]();
        //updateBValues();
        int funcCount = 0;
        //posFunc.reserve(L);
        for (long k = 0; k<N ; k++){
            cin >> OP;
            if (OP=='E'){
                int I, V;
                cin >> I >> V;
                functions[I-1] = V;
                //posFunc.insert(I-1);
                funcCount++;
            }
            else{
                long I,J;
                cin >> J >> I;
                if (funcCount > 0){
                    long long sum = 0;
                    /*
                    int duration = I-J;
                    for (int i = 0; i <= duration; i++){
                        if(functions[I-i-1] > 0){
                            sum+=BValues[i]*functions[I-i-1];
                        }
                    }*/
                    /*
                    set<int> values = orderedFunction(J-1,I-1);
                    for (set<int>::iterator it = values.begin() ; it != values.end(); it++){
                        //cout << "BValues: " << " " << BValues[I-*it-1] << " " << " POS: " << I-*it-1 << endl;
                        sum+=functions[*it]*BValues[I-*it-1];
                    }*/
                    map<int,int>::iterator x= functions.lower_bound(J-1);
                    map<int,int>::iterator maxi= functions.upper_bound(I-1);
                    for(x; x!=maxi; x++){
                        if(BValues[I-x->first-1] == 0){
                            BValues[I-x->first-1] = (exp(fmod((I-x->first-1)*log(B),P)));
                            cout << "BVALUES: ["<< I-x->first-1 << "]: " << BValues[I-x->first-1] <<  endl;
                        }
                        sum+=x->second*BValues[I-x->first-1];
                        sum%=P;
                    }
                    cout << (sum) << endl;
                }
                else{
                    cout << "0" << endl;
                }
            }
        }
        cout << "-" << endl;
        cin >> B >> P >> L >> N;
        //posFunc.clear();
        delete BValues;
    }
    return 0;
}






