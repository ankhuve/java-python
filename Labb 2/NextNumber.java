import java.util.Scanner;

public class NextNumber {

	public static void main( String[] args){

		Scanner scan = new Scanner(System.in);
		int[] array;
		System.err.print("Mata in n: ");
		int n = scan.nextInt();
		array = new int[n];

		for (int i=0; n>i ;i++) {
			int s = scan.nextInt();
			array[i] = s;
		}
		for (int i=0; n>i ;i++) {
			System.out.println(array[i]);
		}
	}
}