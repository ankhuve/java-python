public class City implements Comparable<City>{
    
    public String Name;
	public float[] Temps;
	public int ChosenMonth;

    // constructor
    public City(String name, float[] temperatures) {
        Name = name;
        Temps = temperatures;
    }
    
    public void setChosenMonth(int idx){
    	ChosenMonth = idx;
    }
    
    public String toString() {
//    	String tempString = "";
//    	for(int i=0; i<Temps.length;i++){
//    		tempString += " " + Temps[i];
//    	}
		return Name + " " + Temps[ChosenMonth];
	}
    
    public int compareTo(City c1) {
    	if ((this.Temps[ChosenMonth]) > ((City) c1).Temps[ChosenMonth]){
            return 1;
    	}
        else if (this.Temps[ChosenMonth] == ((City) c1).Temps[ChosenMonth] && this.Name.compareTo(((City) c1).Name) == -1){
        	return -1;
        }
        else if (this.Temps[ChosenMonth] == ((City) c1).Temps[ChosenMonth] && this.Name.compareTo(((City) c1).Name) == 1){
        	return 1;
        }

        else if (this.Temps[ChosenMonth] == ((City) c1).Temps[ChosenMonth] && this.Name.compareTo(((City) c1).Name) == 0){
        	return 0;
        }
        else {
            return -1;
        }
    }
}
