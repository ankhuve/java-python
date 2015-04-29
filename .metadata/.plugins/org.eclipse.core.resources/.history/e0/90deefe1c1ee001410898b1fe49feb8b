import java.util.Scanner;

public class NextNumber {

	public static void main( String[] args ){
		Scanner scan = new Scanner(System.in);
		int[] array;
		System.err.print("Mata in n: ");
		int n = scan.nextInt();
		array = new int[n];
		boolean check = false;
		int possible_b = 0;
		int possible_c = 0;

		for (int i=0; n>i ;i++) {
			int s = scan.nextInt();
			array[i] = s;
		}
		
		while(!check){
			for (int c=-9; c<=9; c++){
				for(int b=-9; b<=9; b++){
					for (int i=0; n-1>i ;i++) {
						System.out.println("Provar tal nr "+i);
						if (array[i]*b+c==array[i+1]){
							possible_b = b;
							possible_c = c;
							if(i==(n-2)){ // we're on the last number
								check = true; // found a solution, try next number with the same
							}
						} else{
							break;
						}
					}
				}
			}
			break;
		}


		if (check){ // we have a solution
			System.out.println(array[n-1]*possible_b+possible_c);
		} else{
			System.out.println("no");
		}
	}
}