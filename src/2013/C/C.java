package fibonacci;

import java.util.Scanner;

public class C {
    
    static long[] powKeys = new long[55];
    static long[] powValues = new long[56];
        
    public static long funcion(long revisar){
        
        long total = 0;
        int i = 0;
        int pos = 1;
        int remain = 1;
        while (revisar >= 1){
            if (powKeys[i] > revisar){
                
                if(pos!= 1){
                    total+=(powValues[i-1]+1)+(powKeys[i-1])*remain;
                    remain++;
                }
                else{
                    total+=(powValues[i-1]+1);
                }
                revisar-=powKeys[i-1];
                i = 0;
                pos--;
                
            }
            
            i++;
        }
        return total;
    }
    
    public static void main(String args[]){
        
        powValues[0] = 0;
        for (int i = 0; i<55; i++){
            powKeys[i] = ((long)Math.pow(2, i));
            powValues[i+1] = powValues[i]*2 + powKeys[i] ;
        }
        
        
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String input = scan.nextLine();
            String v [] = input.split(" ");
            long A = Long.parseLong(v[0]);
            long B = Long.parseLong(v[1]);

            System.out.println(funcion(B)-funcion(A-1));
        }
    }
}
