import java.util.Scanner;

public class Solution {
    // Method to determine the type of triangle
    public static String triangleType(int[] nums) {
        if (nums.length != 3) {
            return "none"; // Invalid input size
        }

        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        // Check if the sides can form a valid triangle using the triangle inequality theorem
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "none";
        }

        // Determine the type of triangle
        if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || b == c || a == c) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompting user for input
        System.out.println("Enter the sides of the triangle (3 integers separated by spaces): ");
        int[] nums = new int[3];

        for (int i = 0; i < 3; i++) {
            nums[i] = scanner.nextInt();
        }

        // Display the result
        System.out.println("Triangle Type: " + triangleType(nums));

        scanner.close();
    }
}
