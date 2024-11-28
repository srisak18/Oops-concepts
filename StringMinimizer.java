package April_24;

import java.util.Scanner;

public class StringMinimizer {

	public static int minimizeStringLength(String s) {
        StringBuilder sb = new StringBuilder(s);

        boolean canMinimize = true;

        while (canMinimize) {
            canMinimize = false;

            // Check for non-empty prefix where all characters are the same
            int prefixLength = 0;
            char prefixChar = sb.charAt(0);
            while (prefixLength < sb.length() && sb.charAt(prefixLength) == prefixChar) {
                prefixLength++;
            }

            // Check for non-empty suffix where all characters are the same
            int suffixLength = 0;
            char suffixChar = sb.charAt(sb.length() - 1);
            while (suffixLength < sb.length() && sb.charAt(sb.length() - 1 - suffixLength) == suffixChar) {
                suffixLength++;
            }

            // Ensure the prefix and suffix do not intersect
            if (prefixLength > 0 && suffixLength > 0 && prefixLength + suffixLength <= sb.length()) {
                sb.delete(0, prefixLength);
                sb.delete(sb.length() - suffixLength, sb.length());
                canMinimize = true;
            }
        }

        // Count occurrences of 'a', 'b', and 'c' in the minimized string
        int countA = 0;
        int countB = 0;
        int countC = 0;
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch == 'a') countA++;
            else if (ch == 'b') countB++;
            else if (ch == 'c') countC++;
        }

        // Return the sum of counts of 'a', 'b', and 'c'
        return countA + countB + countC;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String input = scanner.nextLine();
        
        scanner.close();

        int result = minimizeStringLength(input);

        System.out.println("Output: " + result);
    }
}
