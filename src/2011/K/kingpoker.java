package problemh;

import java.util.Scanner;

public class kingpoker {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.equals("0 0 0")) {
            
            String str_cards[] = input.split(" ");
            int c1 = Integer.parseInt(str_cards[0]);
            int c2 = Integer.parseInt(str_cards[1]);
            int c3 = Integer.parseInt(str_cards[2]);
            boolean pair = false;
            boolean set = false;
            if (c1 == c2 && c1 == c3) {
                if (c1 == 13) {
                    System.out.println("*");
                } else {
                    int beat = c1 + 1;
                    System.out.println(beat + " " + beat + " " + beat);
                }
            } else {
                if (c1 != c2 && c1 != c3 && c2 != c3) {
                    System.out.println(1 + " " + 1 + " " + 2);
                } else {
                    if (c1 == c3) {
                        if (c1 == 13 && c2 == 12){
                            System.out.println("1 1 1");
                        }
                        else{
                            if (c2 == 13) {
                                System.out.println("1 " + (c1 + 1) + " " + (c1 + 1));
                            } else {
                                int n = (c2 + 1);
                                if (n == c1) {
                                    n++;
                                }
                                if (n > c1) {
                                    System.out.println(c1 + " " + c1 + " " + n);
                                } else {
                                    System.out.println(n + " " + c1 + " " + c1);
                                }
                            }
                        }
                    } else {
                        if (c1 == c2) {
                            if (c1 == 13 && c3 == 12){
                                System.out.println("1 1 1");
                            }
                            else{
                                if (c3 == 13) {
                                    System.out.println("1 " + (c1 + 1) + " " + (c1 + 1));
                                } else {
                                    int n = (c3 + 1);
                                    if (n == c1) {
                                        n++;
                                    }
                                    if (n > c1) {
                                        System.out.println(c1 + " " + c1 + " " + n);
                                    } else {
                                        System.out.println(n + " " + c1 + " " + c1);
                                    }
                                }
                            }
                        }
                        else{
                            if (c2==13 && c1 == 12){
                                System.out.println("1 1 1");
                            }
                            else{
                                if (c1 == 13) {
                                    System.out.println("1 " + (c2 + 1) + " " + (c2 + 1));
                                } else {
                                    int n = (c1 + 1);
                                    if (n == c2) {
                                        n++;
                                    }
                                    if (n > c2) {
                                        System.out.println(c2 + " " + c2 + " " + n);
                                    } else {
                                        System.out.println(n + " " + c2 + " " + c2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            input = scan.nextLine();
        }
    }
}
