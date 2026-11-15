import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = checkInput(scanner);
        String result = calcTime(number);
        printResult(result);

        scanner.close();
    }

    static int checkInput(Scanner scanner){
        while(true){
            if(scanner.hasNextInt()){
                int input = scanner.nextInt();
                if(input > 0) {
                    return input;
                } else {
                    System.out.println("Incorrect time");
                }
            } else {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
    }
    static String calcTime(int number){
        int hours = number / 3600 % 24;
        int minutes = number % 3600 / 60;
        int seconds = number % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    static void printResult(String result){
        System.out.print(result);
    }
}