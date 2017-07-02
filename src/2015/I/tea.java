
package problemh;

import java.util.Scanner;

public class tea {
    public static void main (String args[]){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int correct = scan.nextInt();
            scan.nextLine();
            String values = scan.nextLine();
            String responses[]= values.split(" ");
            int sol = 0;
            for (String v : responses){
                if (correct == Integer.parseInt(v)){
                    sol++;
                }
            }
            System.out.println(sol);
        }
    }
}
