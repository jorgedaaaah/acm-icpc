package problemh;

import java.util.Scanner;


public class hours {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            if (scan.nextInt() % 6 == 0){
                System.out.println("Y");
            }
            else{
                System.out.println("N");
            }
        }
    }
}
