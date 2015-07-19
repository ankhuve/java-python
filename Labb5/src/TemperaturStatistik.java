import java.util.Scanner;
//import java.util.Arrays;


public class TemperaturStatistik {
	private static Scanner scan;

	public static void main( String[] args ){
		scan = new Scanner(System.in);
		String[] nTimes;
		int a = scan.nextInt();
		nTimes = new String[a]; // number of times
		
		String[] nPlaces;
		int b = scan.nextInt();
		nPlaces = new String[b]; // number of places
		
		for(int i=0;i<a;i++){
			String k = scan.nextLine();
			nTimes[i] = k;
		}
		
		for(int i=0;i<b;i++){
			String k = scan.nextLine();
			nPlaces[i] = k;
		}
		
		
//		
//		Arrays.sort(nTimes);
//		int[] topHalf = Arrays.copyOfRange(nTimes, (int)Math.ceil((nTimes.length/2)), nTimes.length);
//		int sum = 0;
//		for (int j = 0; j < topHalf.length; j++) {
//			int s = topHalf[j];
//			sum += s;
//		}
		
//		System.out.println(sum);
	}
}