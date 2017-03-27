import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Collections;

public class Dekompression {

    static String[] inputArray;
    static int previousPosition;

    private static int numOpenGroups = 0;

    public static void main( String[] args ){
        String result;

        // runTests();

        Scanner scan = new Scanner(System.in);

        String in = scan.nextLine();
        scan.close();

        inputArray = splitString(in);
        result = parseExpression(0);
        System.out.println(result);

        
    }

    private static String parseExpression( int pos ) {
        previousPosition = pos;
        String result = "";
        String str;
        int strMultiplier = 1;
        String currentSymbol = inputArray[pos];
        boolean hasNext = inputArray.length - 1 > pos ? true : false;

        try {
            int num = Integer.parseInt(currentSymbol);
            strMultiplier = num;
            // we have a number
            // System.out.println("nummer (strMultiplier är nu): " + num);

            // is a group following this number?
            if(peek(pos + 1).equals("(")){
                // System.out.println("-------------");
                str = parseGroupExpression(pos + 1);
                // System.out.println("Fick tillbaka grupp: " + str);
                previousPosition++;
                result = result.join("", Collections.nCopies(strMultiplier, str));
                // System.out.println("group multiplicerad med " + strMultiplier + " och blev: " + result + "\n-------------");
            } else{
                // next char has to be either 'a' or 'b' or 'ab'/'ba'
                str = parseExpression(pos + 1);

                // str will be 'a', 'b' or 'ab'/'ba', so we only repeat the first character
                result = result.join("", Collections.nCopies(strMultiplier, str.substring(0, 1)));
                // System.out.println("Har nu: " + result + ", lägger till: " + str.substring(1));
                result += str.substring(1);
            }


            // System.out.println("aer vi klara? previousPosition+1 = " + (previousPosition + 1) + " inputArray.length = " + inputArray.length );

            if((previousPosition + 1 == inputArray.length) || peek(previousPosition + 1).equals(")")){
                // we're done
                // System.out.println("japp, avslutar");
                return result;
            } else{
                // we need to parse more expressions
                // System.out.println("nepp, fortsaetter pos " + (previousPosition + 1) + ". result = " + result);
                if(peek(previousPosition + 1).equals(")") && (previousPosition + 2 < inputArray.length)){
                    return result + parseExpression(previousPosition + 2);
                } else{
                    return result + parseExpression(previousPosition + 1);
                }
            }            

        } catch (NumberFormatException e) {
            // System.out.println("inte en siffra: " + currentSymbol);

            // we have a letter or a parenthesis
            if(currentSymbol.equals(")")){
                // System.out.println("gruppavslut på pos " + pos + ": " + currentSymbol);
                return "";
            } else if(currentSymbol.equals("(")){
                str = parseGroupExpression(pos + 1);

                // str could be 'a', 'b' or 'ab'/'ba', so we only repeat the first character
                result = result.join("", Collections.nCopies(strMultiplier, str.substring(0, 1)));

                result += str.substring(1);

                return result;
            }
            else{
                if((hasNext && ((previousPosition + 1) < inputArray.length)) && !peek(previousPosition + 1).equals(")")){
                    // System.out.println("här: " + peek(previousPosition + 1));
                    return currentSymbol + parseExpression(pos + 1);
                } else{
                    return currentSymbol;
                }
            }
        }
    }

    private static String parseGroupExpression( int pos ) {
        previousPosition = pos;
        String str = "";
        String currentSymbol = inputArray[pos];
        boolean hasNext = inputArray.length - 1 > pos ? true : false;

        // we have a parenthesis
        if(currentSymbol.equals("(")){
            // System.out.println("Börjar parsa gruppinnehåll..");
            return parseExpression(pos + 1);
        } else if(currentSymbol.equals(")")){
            // System.out.println("gruppavslut: " + currentSymbol);
            return "";
        }
        else{
            return currentSymbol;
        }
    }

    private static String peek( int pos ) {
        if(pos < inputArray.length){
            return inputArray[pos];
        } else{
            return "";
        }
    }

    private static String[] splitString(String str) {
        String[] arr;
        // split the string on letters ("a", "b"), numbers (1-99) and parenthesis ("(", ")")
        arr = str.split("(?<=\\d)(?=\\()|(?<=\\))(?=\\D)|(?<=\\()(?=\\D)|(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)|(?<=[a-z]+)(?=\\)+)");

        for (String s : arr){
            // System.out.println(s);
        }
        
        return arr;
    }
    
     private static void runTests(){
        String check;
        String result;

        inputArray = splitString("4(ab)");
        result = parseExpression(0);
        if(result.equals("abababab")){check = "pass";} else{check = "fail";}; 
        System.out.println("4(ab): " + check);

        inputArray = splitString("11ab");
        result = parseExpression(0);
        if(result.equals("aaaaaaaaaaab")){check = "pass";} else{check = "fail";}; 
        System.out.println("11ab: " + check);

        inputArray = splitString("2(3b3(ab))");
        result = parseExpression(0);
        if(result.equals("bbbabababbbbababab")){check = "pass";} else{check = "fail";}; 
        System.out.println("2(3b3(ab)): " + check);
        
        inputArray = splitString("2(a)2(b)");
        result = parseExpression(0);
        if(result.equals("aabb")){check = "pass";} else{check = "fail";}; 
        System.out.println("2(a)2(b): " + check);
        
        inputArray = splitString("3b3(ab)10b3(ab)");
        result = parseExpression(0);
        if(result.equals("bbbabababbbbbbbbbbbababab")){check = "pass";} else{check = "fail";}; 
        System.out.println("3b3(ab)10b3(ab): " + check);
        
        inputArray = splitString("a2b");
        result = parseExpression(0);
        if(result.equals("abb")){check = "pass";} else{check = "fail";}; 
        System.out.println("a2b: " + check);
        
        inputArray = splitString("4(ab)4(ab)");
        result = parseExpression(0);
        if(result.equals("abababababababab")){check = "pass";} else{check = "fail";}; 
        System.out.println("4(ab)4(ab): " + check);
        
        inputArray = splitString("3b3(ab)3b3(ab)2(a)2(b)");
        result = parseExpression(0);
        if(result.equals("bbbabababbbbabababaabb")){check = "pass";} else{check = "fail";}; 
        System.out.println("3b3(ab)3b3(ab)2(a)2(b): " + check);
        System.out.println("4(ab)4(ab): " + check);
        
        inputArray = splitString("3b3(ab)3b3(ab)2(a)2(b)2(3b3(ab))");
        result = parseExpression(0);
        if(result.equals("bbbabababbbbabababaabbbbbabababbbbababab")){check = "pass";} else{check = "fail";}; 
        System.out.println("3b3(ab)3b3(ab)2(a)2(b)2(3b3(ab)): " + check);
        
        inputArray = splitString("2(abb2(ab2a))");
        result = parseExpression(0);
        if(result.equals("abbabaaabaaabbabaaabaa")){check = "pass";} else{check = "fail";}; 
        System.out.println("2(abb2(ab2a)): " + check);
        
        inputArray = splitString("11ab4(ab)2(3b3(ab))");
        result = parseExpression(0);
        if(result.equals("aaaaaaaaaaabababababbbbabababbbbababab")){check = "pass";} else{check = "fail";}; 
        System.out.println("11ab4(ab)2(3b3(ab)): " + check);
        
        inputArray = splitString("a2(a2(b)2a)");
        result = parseExpression(0);
        if(result.equals("aabbaaabbaa")){check = "pass";} else{check = "fail";}; 
        System.out.println("a2(a2(b)2a): " + check);
        
        inputArray = splitString("2(ab2(ab)a)");
        result = parseExpression(0);
        if(result.equals("abababaabababa")){check = "pass";} else{check = "fail";}; 
        System.out.println("2(ab2(ab)a): " + check);
        
        inputArray = splitString("2a2(2(ba)b3(bba)a)");
        result = parseExpression(0);
        if(result.equals("aabababbbabbabbaabababbbabbabbaa")){check = "pass";} else{check = "fail";}; 
        System.out.println("2a2(2(ba)b3(bba)a): " + check);
        
        inputArray = splitString("2(2abb2(bb)a)b");
        result = parseExpression(0);
        if(result.equals("aabbbbbbaaabbbbbbab")){check = "pass";} else{check = "fail";}; 
        System.out.println("2(2abb2(bb)a)b: " + check); 
        
        inputArray = splitString("2(2a2(b)a)b");
        result = parseExpression(0);
        if(result.equals("aabbaaabbab")){check = "pass";} else{check = "fail";}; 
        System.out.println("2(2a2(b)a)b: " + check); 
        
        inputArray = splitString("2(2a2b)b");
        result = parseExpression(0);
        if(result.equals("aabbaabbb")){check = "pass";} else{check = "fail";}; 
        System.out.println("2(2a2b)b: " + check); 
        
        inputArray = splitString("2(a2b)a");
        result = parseExpression(0);
        if(result.equals("abbabba")){check = "pass";} else{check = "fail";}; 
        System.out.println("2(a2b)a: " + check); 
    }
}