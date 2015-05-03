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
//				System.out.println("1" + " " + (previousSqrt+1));
				cols++;
				lastCol = 1;
			} else if (diffFromPerfect==1 && evenOrOdd==0){ // number stopped in bottom left corner: no additional rows, one additional column
//				System.out.println("1" + " " + (previousSqrt+1));
				cols++;
			} else if(diffFromPerfect<=previousSqrt && evenOrOdd==0){ // number stopped on left side, no additional rows but one more col
				cols++;
			} else if(diffFromPerfect<=previousSqrt && evenOrOdd==1){ // number stopped on left side, no additional rows but one more col
				cols++;
				lastCol = 1;
			} else if(evenOrOdd==0){ // number went into a new row == we add both a col and a row
				cols++;
				rows++;
			} else { // number went into a new row == we add both a col and a row
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
		int k_rows = k_previousSqrt;
		int k_cols = k_previousSqrt;
		System.out.println(k_previousSqrt + " " + k_perfectSquare + " " + k_diffFromPerfect);
		if (k_diffFromPerfect!=0){
			if (k_diffFromPerfect==1 && k_evenOrOdd==1){ // number stopped in top right corner: no additional rows, one additional column
				System.out.println("1" + " " + (k_previousSqrt+1));
				k_col = k_previousSqrt+1; // far right col
				k_row = 1; // top row
				k_cols++;
			} else if (k_diffFromPerfect==1 && k_evenOrOdd==0){ // number stopped in bottom left corner: no additional rows, one additional column
				System.out.println("1" + " " + (k_previousSqrt+1));
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
		System.out.println("k_row: "+k_row + " k_col: " + k_col); // we now know the coordinates of k in the k-square
		
		// time to find out where number 1 is
		int middleCol;
		int middleRow;
		if (cols%2==1){ // if we have an odd number of total cols
			middleCol = (int)Math.ceil((double)cols/2);
		} else{
			middleCol = (cols/2);
		}
		
		if (rows%2==1){ // if we have an odd number of total rows
			middleRow = (int)Math.ceil((double)rows/2);
			System.out.println(middleRow);
			System.out.println("Ojaemnt");
		} else{
			middleRow = (rows/2);
		}
		
		int correctRow = 0;
		int correctCol = 0;
		// find the correct row
		if(rows%2==1){ // uneven number of rows means that we started the last row on top
			if(k_rows%2==1){ // this means that the k-square is centered vertically
				correctRow = ((rows-k_rows)/2)+(k_row);
//				System.out.println("Ett ett");
			} else{ // this means that the k-square is shifted one row down
				correctRow = ((rows-k_rows)/2)+(k_row+1);
//				System.out.println("Tv� ett");
			}
			
		} else{ // even number of rows means that the last row added is on the bottom
			if(k_rows%2==1){ // this means that the k-square is shifted one row up
				correctRow = ((rows-k_rows)/2)+(k_row);
//				System.out.println("Ett tv� ");
			} else{ // this means that the k-square is centered vertically
				correctRow = ((rows-k_rows)/2)+(k_row);
//				System.out.println("Tv� tv�");
			}
		}
		// find the correct column
		if(cols%2==1){ // uneven number of rows means that we started the last row on top
			if(k_cols%2==1){ // this means that the k-square is centered vertically
				correctCol = ((cols-k_cols)/2)+(k_col);
				System.out.println("Ett ett");
			} else{ // this means that the k-square is shifted one row down
				correctCol = ((cols-k_cols)/2)+(k_col+1);
				System.out.println("Tv� ett");
			}
			
		} else{ // even number of rows means that the last row added is on the bottom
			if(k_cols%2==1){ // this means that the k-square is shifted one row up
				correctCol = ((cols)/2)+(k_col);
				System.out.println("Ett tv� ");
			} else{ // this means that the k-square is centered vertically
				correctCol = ((cols-k_cols)/2)+(k_col);
				System.out.println("Tv� tv�");
			}
		}
		
//		int correctRow = middleRow
		System.out.println("Middle row: "+middleRow + " Middle col: " + middleCol);
		System.out.println("k rows: "+k_rows + " k cols: " + k_cols);
		System.out.println("k �r p� rad: "+correctRow + " och kolumn: "+ correctCol);
		
		
		System.out.println(middleRow + " " + middleCol);
	}
}