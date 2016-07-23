import java.util.ArrayList;
import java.util.Scanner;
import java.util.BitSet;

public class Fonster {
	public static void main(String[] args){
		int totalArea = 0;
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); // get the number of windows
		scan.nextLine();
	
		ArrayList<Window> windowList = new ArrayList<Window>();
		ArrayList<BitSet> screen = new ArrayList<BitSet>();

		
		for(int i = 0; i<n; i++){
			int x1 = scan.nextInt();
			int y1 = scan.nextInt(); // start row
			int x2 = scan.nextInt();
			int y2 = scan.nextInt(); // end row
			Window newWindow = new Window(x1, x2, y1, y2-1);
			windowList.add(newWindow);
			scan.nextLine();
			

		}
		scan.close();
		
		for(int i = 0; i<10000; i++){
			BitSet row = new BitSet(10000);
			screen.add(row);
		}
		
		for(int yCoord = 0; yCoord<10000; yCoord++){
			
			for(int k = 0; k<n; k++){
				Window window = windowList.get(k);
				
				if(window.y1 == yCoord){
					BitSet row = screen.get(yCoord);
					
					int prevRow = row.cardinality();
					row.set(window.x1, window.x2);
					
					totalArea += row.cardinality() - prevRow;
				}
				else if(window.y1 < yCoord && window.y2 >= yCoord){
					BitSet row = screen.get(yCoord);
					
					int prevRow = row.cardinality();
					row.set(window.x1, window.x2);
					
					totalArea += row.cardinality() - prevRow;
				}
			}
			
		}
		
		System.out.println(totalArea);
		
	}
}
