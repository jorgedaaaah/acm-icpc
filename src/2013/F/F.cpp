#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main(){
    int matches, goals;
    while (cin >> matches >> goals) {
        int ptje = 0;
        vector<int>rev;
        for (int i = 0; i < matches; i++) {
            int own, their;
            cin >> own >> their;
            if (own > their) {
                ptje += 3;
            } else {
                if (own == their && goals > 0) {
                    ptje += 3;
                    goals--;
                } else {
                    if (own == their) {
                        ptje++;
                    } else {
                        rev.push_back(their - own);
                    }
                }
            }
        }
        sort(rev.begin(), rev.end());
        if(goals > 0){
            for (int i = 0; i<rev.size();i++){

                if (goals == rev[i]){
                    goals = 0;
                    ptje += 1;
                    break;
                }
                else{
                    int diff = rev[i]+1;
                    if (goals >= diff){
                        goals -= diff;
                        ptje += 3;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        cout << ptje << endl;
    }
    return 0;
}
