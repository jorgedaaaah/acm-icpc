package assigningteams;

import java.util.Scanner;

public class AssigningTeams {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String players[] = scan.nextLine().split(" ");
            int first = Integer.parseInt(players[0]) + Integer.parseInt(players[3]);
            int second = Integer.parseInt(players[1]) + Integer.parseInt(players[2]);
            System.out.println(Math.abs(first-second));
        }
    }
}
