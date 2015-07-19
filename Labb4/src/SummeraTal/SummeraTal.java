import java.util.Scanner;
import java.util.Arrays;


public class SummeraTal {
	public static void main( String[] args ){
		Scanner scan = new Scanner(System.in);
		int[] array;
		int n = scan.nextInt();
		array = new int[n];
		int i;
		for(i=0;i<n;i++){
			int k = scan.nextInt();
			array[i] = k;
		}
		
		Arrays.sort(array);
		int[] topHalf = Arrays.copyOfRange(array, (int)Math.ceil((array.length/2)), array.length);
		int sum = 0;
		for (int j = 0; j < topHalf.length; j++) {
			int s = topHalf[j];
			sum += s;
		}
		
		System.out.println(sum);
	}
}