import java.util.Scanner;

public class OrdTillTal {
	public static void main( String[] args ){
		
		long sum = 0;
		long finalSum = 0;
		
		Scanner scan = new Scanner(System.in);
		String fullNumber = scan.nextLine();
		String[] numberInParts = fullNumber.split("\\s+");
		
		for(String part : numberInParts){
			if(part.equals("ett")) {
                sum += 1;
            }
			else if(part.equals("en")) {
                sum += 1;
            }
            else if(part.equals("två")) {
                sum += 2;
            }
            else if(part.equals("tre")) {
                sum += 3;
            }
            else if(part.equals("fyra")) {
                sum += 4;
            }
            else if(part.equals("fem")) {
                sum += 5;
            }
            else if(part.equals("sex")) {
                sum += 6;
            }
            else if(part.equals("sju")) {
                sum += 7;
            }
            else if(part.equals("åtta")) {
                sum += 8;
            }
            else if(part.equals("nio")) {
                sum += 9;
            }
            else if(part.equals("tio")) {
                sum += 10;
            }
            else if(part.equals("elva")) {
                sum += 11;
            }
            else if(part.equals("tolv")) {
                sum += 12;
            }
            else if(part.equals("tretton")) {
                sum += 13;
            }
            else if(part.equals("fjorton")) {
                sum += 14;
            }
            else if(part.equals("femton")) {
                sum += 15;
            }
            else if(part.equals("sexton")) {
                sum += 16;
            }
            else if(part.equals("sjutton")) {
                sum += 17;
            }
            else if(part.equals("arton")) {
                sum += 18;
            }
            else if(part.equals("nitton")) {
                sum += 19;
            }
            else if(part.equals("tjugo")) {
                sum += 20;
            }
            else if(part.equals("trettio")) {
                sum += 30;
            }
            else if(part.equals("fyrtio")) {
                sum += 40;
            }
            else if(part.equals("femtio")) {
                sum += 50;
            }
            else if(part.equals("sextio")) {
                sum += 60;
            }
            else if(part.equals("sjuttio")) {
                sum += 70;
            }
            else if(part.equals("åttio")) {
                sum += 80;
            }
            else if(part.equals("nittio")) {
                sum += 90;
            }
            else if(part.equals("hundra")) {
                sum *= 100;
            }
            else if(part.equals("tusen")) {
                sum *= 1000;
                finalSum += sum;
                sum=0;
            }
            else if(part.equals("miljoner")) {
                sum *= 1000000;
                finalSum += sum;
                sum=0;
            }
            else if(part.equals("miljon")) {
                sum *= 1000000;
                finalSum += sum;
                sum=0;
            }
            else if(part.equals("miljarder")) {
                sum *= 1000000000;
                finalSum += sum;
                sum=0;
            }
            else if(part.equals("miljard")) {
                sum *= 1000000000;
                finalSum += sum;
                sum=0;
            }
		}
		
		finalSum += sum;
		sum = 0;
		System.out.println(finalSum);
		scan.close();
	}
}