import java.util.Scanner;
import java.lang.StringBuilder;

public class ConcatStrings {

	public static void main( String[] args){

		Scanner scan = new Scanner(System.in);
		StringBuilder fullStr = new StringBuilder();
		//System.err.print("Mata in n: ");
		int n = scan.nextInt();
		for (int i=n; i>0 ;i--) {
			String s = scan.next();
			fullStr.append(s);
		}

		System.out.println(fullStr);
	}
}