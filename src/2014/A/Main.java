

import java.util.Scanner;


public class Main {
    public static void main (String args[]){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String v1[] = scan.nextLine().split(" ");
            String v2[] = scan.nextLine().split(" ");
            int i = 0;
            for (; i<5; i++){
                if (v1[i].equals(v2[i])){
                    System.out.println("N");
                    break;
                }
            }
            if (i == 5){
                System.out.println("Y");
            }
        }
    }
}
