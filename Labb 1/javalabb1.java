import java.io.*;
import java.util.Scanner;

public class ConcatStrings {
	public static void main( String[] args){
		try {
			Scanner scan = new Scanner(System.in);
			System.err.print("Mata in n: ");
			int n = scan.nextInt();
			String fullStr = null;
			for (int i=n; i>0 ;i-- ) {
				String s = scan.nextLine();
				fullStr += s;
			}
		} finally {
			System.out.println("fullStr");
			}
		



	}
}