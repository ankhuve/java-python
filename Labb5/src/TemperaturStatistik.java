import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TemperaturStatistik {
	private static Scanner scan;

	public static void main( String[] args ){
		scan = new Scanner(System.in);
		Object[] cityList;
		
		String[] monthArray;
//		System.out.print("Tidpunkter: ");
		int a = scan.nextInt();
		monthArray = new String[a]; // array with months
		
		String[] citiesArray;
//		System.out.print("Stader: ");
		int b = scan.nextInt();
		scan.nextLine(); // get to the new line
		citiesArray = new String[b]; // array with cities
		
		
		// get all the months
		for(int i=0;i<a;i++){
//			System.out.print("Tidpunkt "+(i+1)+": ");
			String k = scan.nextLine();
			monthArray[i] = k;
		}
		
		cityList = new Object[b];

		
		// get all the cities
		for(int j=0;j<b;j++){
//			System.out.print("Namn pa stad: ");
			String city = scan.next(); // get city name
			citiesArray[j] = city;
			float[] temperatures;
			temperatures = new float[a];
			for(int i=0;i<a;i++){ // get temperatures for city
//				System.out.print("Temperatur, "+monthArray[i]+": ");
				temperatures[i] = scan.nextFloat();
			}
			scan.nextLine();
			cityList[j] = new City(city, temperatures); // create a new City object
		}
		
//		System.out.print("\nSortera pa tidpunkt: ");
		String monthToSortBy = scan.nextLine();
		int index = -1;
		for (int i=0;i<monthArray.length;i++) {
		    if (monthArray[i].equals(monthToSortBy)) {
		        index = i; // get the index of the month given
		        break;
		    }
		}
		
		List<City> sortList = new ArrayList<City>();
		
		for(int k=0;k<b;k++){
			((City) cityList[k]).setChosenMonth(index); // set the chosen month
			sortList.add((City) cityList[k]);
		}
		
		// works so far, time to compare and sort stuff
		
		Collections.sort(sortList);
		Iterator<City> itr = sortList.iterator();
		
		while(itr.hasNext()){
			Object element = itr.next();
			System.out.println(((City)element).toString());
		}
				
	}
}