import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = checkSize(scanner);
        ArrayList<Animal> pets = fillArrayList(len, scanner);
        printResult(pets);
        scanner.close();
    }

    static int checkSize(Scanner scanner) {
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            if (n > 0) return n;
            System.out.println("Input error. Size <= 0");
            return checkSize(scanner);
        } else {
            System.out.println("Could not parse a number. Please, try again");
            scanner.next();
            return checkSize(scanner);
        }
    }

    static ArrayList<Animal> fillArrayList(int len, Scanner scanner) {
        ArrayList<Animal> pets = new ArrayList<>();
        int addedAnimals = 0;
        return fillRecursive(len, scanner, pets, addedAnimals);
    }

    private static ArrayList<Animal> fillRecursive(int len, Scanner scanner, ArrayList<Animal> pets, int addedAnimals) {
        if (addedAnimals >= len) return pets;

        String animal = scanner.nextLine().trim().toLowerCase();
        addedAnimals++;

        if (animal.isEmpty()) {
            System.out.println("Could not parse a string. Please, try again");
            return fillRecursive(len, scanner, pets, addedAnimals);
        }
        if (!animal.equals("dog") && !animal.equals("cat")) {
            System.out.println("Incorrect input. Unsupported pet type");
            return fillRecursive(len, scanner, pets, addedAnimals);
        }

        String name = scanner.nextLine().trim();
        int age = readAge(scanner);

        if (age <= 0) {
            System.out.println("Incorrect input. Age <= 0");
            return fillRecursive(len, scanner, pets, addedAnimals);
        }

        if (animal.equals("dog"))
            pets.add(new Dog(name, age));
        else
            pets.add(new Cat(name, age));

        return fillRecursive(len, scanner, pets, addedAnimals);
    }

    private static int readAge(Scanner scanner) {
        if (scanner.hasNextInt()) {
            int age = scanner.nextInt();
            scanner.nextLine();
            return age > 10 ? age + 1 : age;
        } else {
            System.out.println("Could not parse a number. Please, try again");
            scanner.next();
            return readAge(scanner);
        }
    }

    static void printResult(ArrayList<Animal> pets) {
        pets.stream().forEach(System.out::println);
    }
}