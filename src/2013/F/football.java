package problemh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class football {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int matches = scan.nextInt();
            int goals = scan.nextInt();
            int ptje = 0;
            ArrayList<Integer> rev = new ArrayList<Integer>();
            for (int i = 0; i < matches; i++) {
                int own = scan.nextInt();
                int their = scan.nextInt();
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
                            rev.add(their - own);
                        }
                    }
                }
            }
            int revSize = rev.size();
            if(revSize > 0 && goals > 0){
                Collections.sort(rev);
                int i = 0;
                int value = rev.get(i);
                while (value <= goals) {
                    if (goals == value){
                        goals = 0;
                        ptje += 1;
                        break;
                    }
                    else{
                        goals -= (value+1);
                        ptje += 3;
                        i++;
                    }
                    if (revSize == i){
                        break;
                    }   
                    value=rev.get(i);
                }
            }
            System.out.println(ptje);
        }
    }
}
