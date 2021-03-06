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
		if (diffFromPerfect!=0){
			if (diffFromPerfect==1 && evenOrOdd==1){ // number stopped in top right corner: no additional rows, one additional column
				cols++;
			} else if (diffFromPerfect==1 && evenOrOdd==0){ // number stopped in bottom left corner: no additional rows, one additional column
				cols++;
			} else if(diffFromPerfect<=previousSqrt && evenOrOdd==0){ // number stopped on left side, no additional rows but one more col
				cols++;
			} else if(diffFromPerfect<=previousSqrt && evenOrOdd==1){ // number stopped on left side, no additional rows but one more col
				cols++;
			} else if(evenOrOdd==0){ // number went into a new row == we add both a col and a row
				cols++;
				rows++;
			} else { // number went into a new row == we add both a col and a row
				cols++;
				rows++;
			}
		}
		
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
		int k_rows = k_previousSqrt;
		int k_cols = k_previousSqrt;
		if (k_diffFromPerfect!=0){
			if (k_diffFromPerfect==1 && k_evenOrOdd==1){ // number stopped in top right corner: no additional rows, one additional column
				k_col = k_previousSqrt+1; // far right col
				k_row = 1; // top row
				k_cols++;
			} else if (k_diffFromPerfect==1 && k_evenOrOdd==0){ // number stopped in bottom left corner: no additional rows, one additional column
				k_col = 1; // far left col
				k_row = k_previousSqrt; // bottom row
				k_cols++;
			} else if(k_diffFromPerfect<=k_previousSqrt && k_evenOrOdd==0){ // number stopped on left side, no additional rows but one more col
				k_row = (k_previousSqrt+1)-(k_diffFromPerfect);
				k_col = 1;
				k_cols++;
			} else if(k_diffFromPerfect<=k_previousSqrt && k_evenOrOdd==1){ // number stopped on right side, no additional rows but one more col
				k_row = k_diffFromPerfect;
				k_col = k_previousSqrt+1;
				k_cols++;
			} else if(k_evenOrOdd==0){ // number went into a new row == we add both a col and a row at the bottom
				k_row = 1;
				k_col = (k_diffFromPerfect-k_previousSqrt);
				k_cols++;
				k_rows++;
			} else { // number went into a new row == we add both a col and a row on the top
				k_cols++;
				k_rows++;
				k_row = k_previousSqrt+1;
				k_col = (k_previousSqrt+1)-(k_diffFromPerfect-k_previousSqrt+1)+2;
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
		
		int correctRow = 0;
		int correctCol = 0;
		// find the correct row
		int b = (rows-k_rows)/2;
		int c = (cols-k_cols)/2;
		if(rows%2==1){ // uneven number of rows means that we started the last row on top
			if(k_rows%2==1){ // this means that the k-square is centered vertically
				correctRow = (b)+(k_row);
			} else{ // this means that the k-square is shifted one row down
				correctRow = (b)+(k_row+1);
			}
			
		} else{ // even number of rows means that the last row added is on the bottom
			if(k_rows%2==1){ // this means that the k-square is shifted one row up
				correctRow = (b)+(k_row);
			} else{ // this means that the k-square is centered vertically
				correctRow = (b)+(k_row);
			}
		}
		// find the correct column
		if(cols%2==1){ // uneven number of cols means that we started the last col to the left
			if(k_cols%2==1){ // this means that the k-square is centered horizontally
				correctCol = (c)+(k_col);
			} else{ // this means that the k-square is shifted one col to the right
				correctCol = (c)+(k_col+1);
			}
			
		} else{ // even number of cols means that the last col is on the right
			if(k_cols%2==1){ // // middle is shifted one row to the left
				correctCol = (c)+(k_col);
			} else{ // this means that the k-square is centered horizontally
				correctCol = (c)+(k_col);
			}
		}
		
		System.out.println(correctRow + " " + correctCol); // output correct coordinates
	}
}