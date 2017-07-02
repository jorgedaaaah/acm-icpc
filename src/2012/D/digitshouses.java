
package problemh;

import java.util.Scanner;

public class digitshouses {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String houses = scan.nextLine();
            int space = houses.indexOf(" ");
            int inicio = Integer.parseInt(houses.substring(0, space));
            int fin = Integer.parseInt(houses.substring(space+1));
            int counter = 0;
            for (int i = inicio; i<=fin; i++){
                String value = i+"";
                boolean fake = false;
                for (int j = 0; j<value.length(); j++){
                    char car = value.charAt(j);
                    if (value.indexOf(car) != value.lastIndexOf(car)){
                        fake = true;
                        break;
                    }
                }
                if (!fake){
                    counter++;
                }
            }
            System.out.println(counter);
        }
    }
}
