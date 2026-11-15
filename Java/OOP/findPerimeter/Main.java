import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = checkDouble(scanner);
        double y1 = checkDouble(scanner);

        double x2 = checkDouble(scanner);
        double y2 = checkDouble(scanner);

        double x3 = checkDouble(scanner);
        double y3 = checkDouble(scanner);

        if((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1) == 0){
            System.out.println("It's not a triangle");
        } else {
            double ab = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            double bc = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
            double ca = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
            double perimeter = ab + bc + ca;

            System.out.printf("Perimeter: %.3f", perimeter);
        }
        scanner.close();
    }
    private static double checkDouble(Scanner scanner){
        while(true){
            if(scanner.hasNextDouble()){
                return scanner.nextDouble();
            } else {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
    }

}
