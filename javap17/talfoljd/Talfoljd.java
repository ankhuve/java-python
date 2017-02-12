import java.util.Scanner;

public class Talfoljd {

    public static void main( String[] args ){
        Scanner scan = new Scanner(System.in);
        int[] array;

        // System.err.print("x: ");
        int x = scan.nextInt();

        // System.err.print("y: ");
        int y = scan.nextInt();

        int diff = y - x;
        int a1 = 0;
        int a0 = 0;

        for (int i = 0; i <= diff; i++) {
            a1 = x + i;

            int aCurr = a1;
            int step = 0;

            while (a1 != 1) {            
                // System.out.println();
                // om vi har ett jämnt tal
                if (aCurr % 2 == 0) {
                    // System.out.println(a0 + " % 2 = " + a0 % 2);
                    a1 = aCurr / 2;
                } else {
                    // System.out.println(a0 + " % 2 = " + a0 % 2);
                    a1 = (aCurr * 3) + 1;
                }

                aCurr = a1;
                step++;
                
            }
            System.out.println(step);
        }

        // int a1 = 0;
        // int aCurr = a0;
        // int step = 0;

        // while (a1 != 1 && step < 15) {            
        //     // System.out.println();
        //     // om vi har ett jämnt tal
        //     if (aCurr % 2 == 0) {
        //         // System.out.println(a0 + " % 2 = " + a0 % 2);
        //         a1 = aCurr / 2;
        //     } else {
        //         // System.out.println(a0 + " % 2 = " + a0 % 2);
        //         a1 = (aCurr * 3) + 1;
        //     }

        //     aCurr = a1;
        //     step++;
            
        //     // System.err.print(aCurr + " ");
        // }

        // System.out.println("Löstes på " + step + " antal steg.");
        

        

        // for (int i=0; n>i ;i++) {
        //     int s = scan.nextInt();
        //     array[i] = s;
        // }
    }
}