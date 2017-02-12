import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

public class Enigma {
	public static void main( String[] args ){
		
        char[] encrypted, clearText;
        List<Integer> hits = new ArrayList<Integer>();

		Scanner scan = new Scanner(System.in);
		String encryptedStr = scan.nextLine();
		String clearTextStr = scan.nextLine();

        encrypted = encryptedStr.toCharArray();
        clearText = clearTextStr.toCharArray();

        int numPos = encrypted.length - clearText.length;
        boolean match;

        for(int j = 0; j <= numPos; j++) {
            match = false;
            for(int i = 0; i < clearText.length; i++) {
                if (encrypted[j + i] == clearText[i]) {
                    // we found a letter that was the same
                    match = true;
                    break;
                }
            }
            if(!match) {
                hits.add(j + 1);
            } 
        }

        if(hits.isEmpty()) {
            System.out.println("-1");
        } else {
            StringBuilder listString = new StringBuilder();

            for (int s : hits) {
                listString.append(s+" ");
            }
            System.out.println(listString);
        }
	}
}