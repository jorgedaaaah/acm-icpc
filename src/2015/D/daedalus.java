package problemh;

import java.util.Scanner;

public class daedalus {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String in = scan.nextLine();
            String gamers[] = in.split(" ");
            int players = Integer.parseInt(gamers[0]);
            int games = Integer.parseInt(gamers[1]);
            int remain = 0;
            for (int i = 0; i < games; i++) {
                in = scan.nextLine();
                String separated[] = in.split(" ");
                int total = Integer.parseInt(separated[0]);
                int dead = Integer.parseInt(separated[1]);
                int counter = dead;
                boolean upper = counter > total ;
                if (counter > total) {
                        upper = true;
                    }
                for (int j = 2; j <= players; j++) {
                    counter += Integer.parseInt(separated[j]);
                    if (counter > total) {
                        upper = true;
                    }
                }
                if (upper) {
                    int extra = dead/10;
                    while (( counter - dead + (extra)) > total && extra >= 1) {
                        extra /= 10;
                    }
                    if (extra < dead && extra >= 1) {
                        remain += (extra);
                    }
                } else {
                    int extra = dead;
                    int revision = ((extra * 10) + (counter - dead));
                    while ( revision <= total && (extra*10) <= 10000) {
                        extra *= 10;
                        revision = ((extra * 10) + (counter - dead));
                    }
                    if (extra > dead || extra <= 10000) {
                        remain +=(extra - dead);
                    }
                }
            }
            
            System.out.println(remain);
        }
    }
}
