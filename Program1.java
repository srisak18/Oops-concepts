package April_24;

public class Program1 {
	    public static boolean areSimilar(int[] arr1, int[] arr2) {
	        if (arr1.length != arr2.length) {
	            return false;
	        }

	        int n = arr1.length;
	        int firstDiffIndex = -1;
	        int secondDiffIndex = -1;

	        // Find indices where elements differ
	        for (int i = 0; i < n; i++) {
	            if (arr1[i] != arr2[i]) {
	                if (firstDiffIndex == -1) {
	                    firstDiffIndex = i;
	                } else if (secondDiffIndex == -1) {
	                    secondDiffIndex = i;
	                } else {
	                    // More than two differences
	                    return false;
	                }
	            }
	        }

	        // If no differences, arrays are already similar
	        if (firstDiffIndex == -1) {
	            return true;
	        }

	        // If exactly two differences, check if swapping resolves it
	        if (secondDiffIndex != -1) {
	            return arr1[firstDiffIndex] == arr2[secondDiffIndex] &&
	                   arr1[secondDiffIndex] == arr2[firstDiffIndex];
	        }

	        // If exactly one difference, swapping cannot resolve it
	        return false;
	    }

	    public static void main(String[] args) {
	        int[] arr1 = {1, 2, 3, 4};
	        int[] arr2 = {1, 3, 2, 4};

	        if (areSimilar(arr1, arr2)) {
	            System.out.println("The arrays are similar.");
	        } else {
	            System.out.println("The arrays are not similar.");
	        }
	    }
	}


