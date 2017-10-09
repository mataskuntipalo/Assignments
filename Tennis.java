import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tennis {
	private static int A = 0;
	private static int B = 0;
	
	public static void printScore(int point,String s){
		if(point == 1){
			System.out.println(" 15");
		}else if(point == 2){
			System.out.println(" 30");
		}else if(point == 3){
			System.out.println(" 40");
			
		}else if(point > 3){
			if(s.equals("a")){
				if(A-B > 1){
					System.out.println(" WIN");
				}else{
					System.out.println(" ADV");
				}
			}else if(s.equals("b")){
				if(B-A > 1){
					System.out.println(" WIN");
				}else{
					System.out.println(" ADV");
				}
			}
		}
	}
	
	
	public static void main (String[] args) {
		
			File text = new File("tennis.txt");
    	
        try {
            Scanner scanner = new Scanner(text);
            int count = 0;
            while (scanner.hasNextLine()) {
            	A = 0;
            	B = 0;
            	count++;
            	System.out.println("Game" + count);
            	String[] cut = scanner.nextLine().split(":");
            	System.out.println("String is " + cut[1]);
            	Scanner inLine = new Scanner(cut[1]);
            	
            	
            	while(inLine.hasNext()){
            		 if(inLine.next().equals("A")){
            			 A++;
            			 System.out.print("A:");
            			 printScore(A,"a");
          			 
            		 }else{
            			 B++;
            			 System.out.print("B:");
            			 printScore(B,"b");
            		 }
            		 
        			 if(A==B && A>=3 && B>=3){
        				 System.out.println("DUCE"); 
        			 }
            		 
            	}
            	inLine.close();
            }
            scanner.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
}
