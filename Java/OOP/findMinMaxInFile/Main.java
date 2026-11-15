import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = checkPath(scanner);
        int size = checkSize(filePath, scanner);
        if (size == -1) {
            scanner.close();
            return;
        }
        double[] array = readArray(filePath, size);
        if (array == null) {
            scanner.close();
            return;
        }
        double max = findMax(array);
        double min = findMin(array);
        printArray(array);
        saveResult(max, min);

        scanner.close();
    }

    static String checkPath(Scanner scanner) {
        while (true) {
            try {
                String filePath = scanner.nextLine();
                File file = new File(filePath);
                if (file.exists())
                    return filePath;
                else
                    System.out.println("Input error. File doesn't exist");
            } catch (Exception e) {
                System.out.println("Input error. File doesn't exist");
            }
        }
    }

    static int checkSize(String filePath, Scanner scanner) {
        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);

            if (!fileScanner.hasNextInt()) {
                System.out.println("Input error. File doesn't contain size value");
                fileScanner.close();
                return -1;
            }

            int size = fileScanner.nextInt();
            fileScanner.close();

            if (size > 0) {
                return size;
            } else {
                System.out.println("Input error. Size <= 0");
                return -1;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input error. File doesn't exist");
            return -1;
        }
    }

    static double[] readArray(String filePath, int size) {
        double[] array = new double[size];
        int count = 0;

        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);

            if (fileScanner.hasNextInt()) {
                fileScanner.nextInt();
            }

            while (count < size && fileScanner.hasNext()) {
                if (fileScanner.hasNextDouble()) {
                    array[count] = fileScanner.nextDouble();
                    count++;
                } else {
                    fileScanner.next();
                }
            }

            fileScanner.close();

            if (count < size) {
                System.out.println("Input error. Insufficient number of elements");
                return null;
            }
            return array;

        } catch (FileNotFoundException e) {
            System.out.println("Input error. File doesn't exist");
            return null;
        }
    }

    static double findMax(double[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    static double findMin(double[] array) {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    static void printArray(double [] array) {
        System.out.println(array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    static void saveResult(double max, double min) {
        try {
            FileWriter writer = new FileWriter("result.txt");
            writer.write(String.format("%.1f %.1f", min, max));
            writer.close();
            System.out.println("Saving min and max values in file");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}