import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        checkSeq(scanner);
        scanner.close();
    }

    static int checkSeq(Scanner scanner) {
        int current = 0, last = 0, counter = 0;
        boolean hasNumbers = false;

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                current = scanner.nextInt();
                counter++;
                hasNumbers = true;

                if (counter == 1) {
                    last = current;
                } else {
                    if (last > current) {
                        System.out.printf("The sequence is not ordered from the ordinal number of the number %d", counter - 1);
                        return counter;
                    }
                    last = current;
                }
            } else {
                if (hasNumbers) {
                    System.out.println("The sequence is ordered in ascending order");
                    return 0;
                } else {
                    System.out.println("Input error");
                    return -1;
                }
            }
        }

        if (!hasNumbers) {
            System.out.println("Input error");
            return -1;
        }

        System.out.println("The sequence is ordered in ascending order");
        return 0;
    }
}