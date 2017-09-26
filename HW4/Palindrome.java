import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Palindrome {
	
    public static void main(final String[] args) {
		String again = "Y";		
		Scanner input = new Scanner(System.in);
        
		do {
			System.out.print("Input a String: ");
			final Scanner scanner = new Scanner(System.in);
			final String inputString = scanner.nextLine();
			if(inputString != null && !inputString.isEmpty()) {
				char[] charArray = inputString.toCharArray();
				if(Palindrome.isPalindrome(charArray)) {
					System.out.println(inputString + " is a Palindrome!");
				}
				else {
					System.out.println(inputString + " is NOT a Palindrome!");
				}
			}
			else {
				System.out.println("Invalid input!");
			}
			System.out.println("Check another string? Y or N?");
			again = input.nextLine();
						
		} while(!again.equalsIgnoreCase("N"));
    }
    
    private static boolean isPalindrome(final char[] charArray) {
        if(charArray == null || charArray.length == 0) {
            return false;
        }
        else if(charArray.length == 1) {
            return true;
        }
        else if (charArray.length == 2) {
            return charArray[0] == charArray[1];
        }
        else {
            final int arrayLength = charArray.length;
            // Compare the first and last element
            if(charArray[0] != charArray[arrayLength - 1]) {
                return false;
            }
            
            // Strip the array of the first and last element and continue
            return isPalindrome(Arrays.copyOfRange(charArray, 1, arrayLength - 1));
        }
    }
}
