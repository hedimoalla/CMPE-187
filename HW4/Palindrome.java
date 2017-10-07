/* 
	CMPE 187 GROUP 15 
	Branden Caasi - Hedi Moalla - Linh Phan - Josue Ramirez
*/
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

class Palindrome {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String tryAgain;
        System.out.print("Welcome!\nThis Program checks whether an input string is a palindrome\n");
        do {
            System.out.print("Enter any string: ");
            
            Scanner in = new Scanner(System.in);
            String inputString = in.nextLine();
            System.out.println("# of characters in the string: " + inputString.length());
            Queue queue = new LinkedList();

            for (int i = inputString.length() - 1; i >= 0; i--) {
                queue.add(inputString.charAt(i));
            }

            String reverseString = "";

            while (!queue.isEmpty()) {
                reverseString = reverseString + queue.remove();
            }
            if (inputString.equals(reverseString)) {
                System.out.println("Yes, the input String IS a palindrome.");
            } else {
                System.out.println("No, the input String is NOT a palindrome.");
            }
            System.out.println("Try again? Enter Y for Yes.");
            tryAgain = input.nextLine();

        } while (tryAgain.toUpperCase().equals("Y"));
    }
}
