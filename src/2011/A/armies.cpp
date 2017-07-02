#include <iostream>

using namespace std;

// pos: left -2
// pos: right-1
int findNext(int *arr, int pos, int max){

    while (pos > 0 && pos < (max+1) && arr[pos-1] != 0){
        pos = arr[pos-1];

    }
    return pos;
}

int main(){
    int s,b;
    cin >>s >> b;
    while(s!=0 && b!=0){
        int *attacksL = new int [s];
        int *attacksR = new int [s];
        for (int i = 0; i<s; i++){
            attacksL[i] = 0;
            attacksR[i] = 0;
        }
        for (int i = 0; i<b; i++){
            int left, right;
            cin >> left >> right;
            bool entroL = false;
            bool entroR = false;
            if (left > 1 && right < s){
                if (left != right){
                    if (attacksL[left-2] == 0){
                        attacksL[left-1] = left-1;
                        attacksR[left-1] = right+1;
                    }
                    else{
                        attacksL[left-1] = findNext(attacksL, left-1, s) ;
                        entroL = true;
                    }

                    if (attacksR[right] == 0){
                        attacksR[right-1] = right+1;
                        attacksL[right-1] = left-1;
                    }
                    else{
                        attacksR[right-1] = findNext(attacksR, right+1, s);
                        entroR = true;
                    }
                    if (entroL){

                        attacksL[right-1] = attacksL[left-1];

                        attacksR[left-1] = attacksR[right-1];
                    }
                    if(entroR){
                        attacksR[left-1] = attacksR[right-1];
                        attacksL[right-1] = attacksL[left-1];
                    }
                }
                else{
                    if (attacksL[left-2] == 0 && attacksR[right] == 0){
                        attacksL[left-1] = left-1;
                        attacksR[left-1] = right+1;
                    }
                    else{
                        attacksL[left-1] = findNext(attacksL, left-1, s) ;
                        attacksR[left-1] = findNext(attacksR, right+1, s);

                    }
                }
            }
            if (right == s){
                attacksR[s-1] = s+1;
                attacksR[left-1] = s+1;
                attacksL[left-1] = attacksL[left-2] == 0 ? left-1 : findNext(attacksL, left-1, s);
            }

            if (left == 1){
                attacksL[0] = -1;
                attacksR[right-1] = attacksR[right] == 0 ? right+1 : findNext(attacksR, right+1, s);
                attacksL[right-1] = -1;
            }


            if (attacksL[left-1] > 0){
                cout << attacksL[left-1];
            }
            else{
                cout << "*";
            }
            cout << " ";
            if (attacksR[right-1] < s+1){
                cout <<attacksR[right-1];
            }
            else{
                cout << "*";
            }
            cout << endl;


        }
        cout << "-" << endl;
        cin >>s >> b;
    }
    return 0;
}
