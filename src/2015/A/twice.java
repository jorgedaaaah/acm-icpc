package problemh;

import java.util.Scanner;

public class twice {

    static final String value = "99887766554433221100";
    static int counters[];
    static String result;

    public static int toInt(char c) {
        return c - 48;
    }
    
    public static void imprimir(){
        for (int i = 0; i<counters.length;i++){
            System.out.print(counters[i] + " ");
        }
        System.out.println("\n");
    }
    
    public static String cleanValue(){
        String res = value;
        for (int j = 0; j<counters.length; j++){
            for (int i = 0; i<counters[j];i++){
                res = res.replaceFirst(""+j, "");
            }
        }
        return res;
    }

    public static void getResult(char words[]) {
        int position = 0;
        boolean entro = false;
        for (char c : words) {
            int i = toInt(c);
            
            if ((counters[i]) > 1) {
                while (i < 0 || counters[i] > 1) {
                    int initial = i;
                    while (i >= 0 && counters[i] > 1) {
                        i--;
                    }
                    if (i == -1) {
                        position--;
                        counters[toInt(words[position])]--;
                        words[position]--;
                        i = toInt(words[position]);
                    } else {
                        words[position] = (char)(i+48);
                        break;
                    }
                }
                counters[i]++;
                String v = cleanValue();
                for (int x = 0; x < words.length; x++) {
                    if (x <= position) {
                        result += words[x];
                    } else {
                        int append = toInt(v.charAt(x - position -1));
                        result += append;
                    }
                }
                entro = true;
                break;
            } else {
                counters[i]++;
            }
            position++;
        }
        if (!entro) {
            result = String.valueOf(words);
        }
        while(result.startsWith("0")){
            result = result.substring(1);
        }
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String line = scan.nextLine();
            counters = new int[10];
            result = "";
            getResult(line.toCharArray());
            System.out.println(result);
        }
    }
}
