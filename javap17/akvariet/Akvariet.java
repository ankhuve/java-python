import java.util.Scanner;
import java.lang.Math;
import java.lang.Double;

public class Akvariet {

	public static void main( String[] args){

        String coordsArray[];
        double x1, y1, z1, x2, y2, z2, sum = 0;

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

        scan.nextLine();
        String coords = scan.nextLine();

        // System.out.println("Har läst första koordinater");

        coordsArray = coords.split("\\s+");        

        x1 = Double.parseDouble(coordsArray[0]);
        y1 = Double.parseDouble(coordsArray[1]);
        z1 = Double.parseDouble(coordsArray[2]);

		for (int i=1; i < n ; i++) {
            coords = scan.nextLine();
            // System.out.println("Har läst koordinater nr " + i);
            coordsArray = coords.split("\\s+");

            x2 = Double.parseDouble(coordsArray[0]);
            y2 = Double.parseDouble(coordsArray[1]);
            z2 = Double.parseDouble(coordsArray[2]);

            sum += Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2) + Math.pow(z1-z2, 2));

            x1 = x2;
            y1 = y2;
            z1 = z2;
		}
        System.out.format("%.2f%n", sum);
	}
}