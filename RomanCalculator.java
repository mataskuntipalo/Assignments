import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class RomanCalculator {
	public static void main (String[] args) {
		
		String leftNumber,operation,rightNumber;
    	
    	File text = new File("roman.txt");

        try {

            Scanner scanner = new Scanner(text);
            Format change = new Format();

            while (scanner.hasNextLine()) {
            	leftNumber = scanner.next();
                operation = scanner.next();
                rightNumber = scanner.next();
                
                int left = change.parse(leftNumber);
                int right = change.parse(rightNumber);
                int total = 0;
                
                switch (operation) {
                case "+":  
                	total = left+right;
                    break;
                case "-":
                	total = left-right;
                	break;
                case "*":
                	total = left*right;
                	break;
                case "/":
                	total = left/right;
                	break;
                default:
                	System.out.println("Error"); 
                break;
                }
                
                System.out.println(change.format(total)); 
            }
            scanner.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
}
