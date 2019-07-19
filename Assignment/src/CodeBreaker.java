import java.util.Scanner;

public class CodeBreaker {
	
	public static void main(String[] args) {
		
		String encryptedCode = "";
		int count=0; 
		
		int RandomNo =100 + (int) (Math.random()*(999 - 100)); 		//...Generate Random number
		//System.out.println(RandomNo);    //...Uncomment this line to check randomly generated number
		
		 
		String RandomStr= ""+RandomNo;    //...Convert it To String
		String Status=null;               //... To set Status as X= Not present, P= Present but not in correct position, M= Present in correct position
		
		Scanner sc = new Scanner(System.in);
		
		while(!encryptedCode.equalsIgnoreCase("MMM")) {
			count++;
			encryptedCode="";
			
			System.out.print("\tGuess "+count+" : ");
			int userGuess = sc.nextInt();           	//...To get user guess
			String userGuessStr = ""+userGuess;			//...Convert it To String	
			
			
			for(int i = 0 ;i<userGuessStr .length();i++) {
				Status=null;
				for(int j = 0;j<RandomStr.length();j++) {
					if(userGuessStr.charAt(i)==RandomStr.charAt(j)) {
						Status="P";
						if(i==j) {
							Status="M";
							break;
						}
					}
				}
				if(Status==null) {
					if(encryptedCode == null) {
						encryptedCode = "X";
					}
					else {
						encryptedCode = encryptedCode + "X";
					}
				}
				else {
					if(encryptedCode == null) {
						encryptedCode = Status;
					}
					else {
						encryptedCode = encryptedCode + Status;
					}
				}
			}
			System.out.println("\tEncrypted Message : "+ encryptedCode);
		}
		System.out.println("\nFinal Output: "+count);
		System.out.println("\nSecurity Code is: " + RandomNo);
		sc.close();
	}
}
