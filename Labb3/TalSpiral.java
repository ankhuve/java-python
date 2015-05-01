import java.util.Scanner;

public class TalSpiral {

	private static Scanner scan;

	public static void main( String[] args ){
		scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int previousSqrt = (int)Math.floor(Math.sqrt(n));
		int perfectSquare = previousSqrt*previousSqrt;
		int evenOrOdd = 1; // odd means the square ended in top right corner
		if (perfectSquare%2==0){ // the perfect square ended in the bottom left
			evenOrOdd = 0;
		}
		int diffFromPerfect = n-perfectSquare;
		
		// Calculate how many rows and columns the "square" consists of
		int rows = previousSqrt;
		int cols = previousSqrt;
		int lastRow = 0; // 0 == last row we add is on top of the square, 1 == under
		int lastCol = 0; // 0 == last column we add is to the left of the square, 1 == to the right
		System.out.println(previousSqrt + " " + perfectSquare + " " + diffFromPerfect);
		if (diffFromPerfect!=0){
			if (diffFromPerfect==1 && evenOrOdd==1){ // number stopped in top right corner: no additional rows, one additional column
				System.out.println("L�gger till en ny kolumn till h�ger");
				System.out.println("1" + " " + (previousSqrt+1));
				cols++;
				lastCol = 1;
			} else if (diffFromPerfect==1 && evenOrOdd==0){ // number stopped in bottom left corner: no additional rows, one additional column
				System.out.println("L�gger till en ny kolumn till v�nster");
				System.out.println("1" + " " + (previousSqrt+1));
				cols++;
			} else if(diffFromPerfect<=previousSqrt && evenOrOdd==0){ // number stopped on left side, no additional rows but one more col
				System.out.println("L�gger till en ny kolumn till v�nster");
				cols++;
			} else if(diffFromPerfect<=previousSqrt && evenOrOdd==1){ // number stopped on left side, no additional rows but one more col
				System.out.println("L�gger till en ny kolumn till h�ger");
				cols++;
				lastCol = 1;
			} else if(evenOrOdd==0){ // number went into a new row == we add both a col and a row
				System.out.println("L�gger till en ny rad ovanf�r och en kolumn till v�nster");
				cols++;
				rows++;
			} else { // number went into a new row == we add both a col and a row
				System.out.println("L�gger till en ny rad under och en kolumn till h�ger");
				cols++;
				rows++;
				lastCol = 1;
				lastRow = 1;
			}
		}
		System.out.println("Rows: "+rows + " Cols: " + cols); // we now know how big the n-square is
		
		// time to find out where k is!
		int k_previousSqrt = (int)Math.floor(Math.sqrt(k));
		int k_perfectSquare = k_previousSqrt*k_previousSqrt;
		int k_evenOrOdd = 1; // odd means the square ended in top right corner
		if (k_perfectSquare%2==0){ // the perfect square ended in the bottom left
			k_evenOrOdd = 0;
		}
		int k_diffFromPerfect = k-k_perfectSquare;
		
		// Calculate how many rows and columns the "square" consists of
		int k_row;
		int k_col;
		int k_lastRow = 0; // 0 == last row we add is on top of the square, 1 == under
		int k_lastCol = 0; // 0 == last column we add is to the left of the square, 1 == to the right
		System.out.println(k_previousSqrt + " " + k_perfectSquare + " " + k_diffFromPerfect);
		if (k_diffFromPerfect!=0){
			if (k_diffFromPerfect==1 && k_evenOrOdd==1){ // number stopped in top right corner: no additional rows, one additional column
				System.out.println("1" + " " + (k_previousSqrt+1));
				k_col = k_previousSqrt+1; // far right col
				k_row = 1; // top row
			} else if (k_diffFromPerfect==1 && k_evenOrOdd==0){ // number stopped in bottom left corner: no additional rows, one additional column
				System.out.println("1" + " " + (k_previousSqrt+1));
				k_col = 1; // far left col
				k_row = k_previousSqrt; // bottom row
			} else if(k_diffFromPerfect<=k_previousSqrt && k_evenOrOdd==0){ // number stopped on left side, no additional rows but one more col
				k_row = (k_previousSqrt+1)-(k_diffFromPerfect-1);
				k_col = 1;
			} else if(k_diffFromPerfect<=k_previousSqrt && k_evenOrOdd==1){ // number stopped on right side, no additional rows but one more col
				k_row = k_diffFromPerfect;
				k_col = k_previousSqrt+1;
			} else if(k_evenOrOdd==0){ // number went into a new row == we add both a col and a row
//				System.out.println("L�gger till en ny rad ovanf�r och en kolumn till v�nster");
				k_row = 1;
				k_col = (k_diffFromPerfect-k_previousSqrt);
				
			} else { // number went into a new row == we add both a col and a row
//				System.out.println("L�gger till en ny rad under och en kolumn till h�ger");
				k_row = k_previousSqrt+1;
				k_col = (k_previousSqrt+1)-(k_diffFromPerfect-k_previousSqrt+1);
			}
		} else{ // k is a perfect square
			if (k_evenOrOdd==1){
				k_row = 1;
				k_col = k_previousSqrt;
			} else{
				k_row = k_previousSqrt;
				k_col = 1;
			}
		}
		System.out.println("k_row: "+k_row + " k_col: " + k_col); // we now know how big the n-square is
	}
}