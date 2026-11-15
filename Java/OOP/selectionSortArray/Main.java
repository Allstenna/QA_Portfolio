import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = checkSize(scanner);
        double[] nums = fillArray(len, scanner);
        selectionSort(nums);
        printResult(nums);
        scanner.close();
    }

    static int checkSize(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                if (n > 0) return n;
                System.out.println("Input error. Size <= 0");
            } else {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
    }

    static double[] fillArray(int len, Scanner scanner) {
        double[] array = new double[len];
        for (int i = 0; i < len; i++) {
            while (true) {
                if (scanner.hasNextDouble()) {
                    array[i] = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("Could not parse a number. Please, try again");
                    scanner.next();
                }
            }
        }
        return array;
    }

    static void selectionSort(double[] nums) {
        for (int i = 0; i < nums.length - 1; i++){
            int min = i;
            for (int j = i + 1; j < nums.length; j++){
                if(nums[j] < nums[min])
                    min = j;
            }
            double temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;

        }
    }

    static void printResult(double[] new_array) {
        for (int i = 0; i < new_array.length; i++) {
            System.out.print(new_array[i]);
            if (i < new_array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}