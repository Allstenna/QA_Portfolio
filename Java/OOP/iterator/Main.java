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
        while (true) {
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                scanner.nextLine();
                if (n > 0) return n;
                System.out.println("Input error. Size <= 0");
            } else {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
    }


    static ArrayList<Animal> fillArrayList(int len, Scanner scanner) {
        ArrayList<Animal> pets = new ArrayList<>();
        int addedAnimals = 0;

        while (addedAnimals < len) {
            String animal = scanner.nextLine().trim().toLowerCase();
            addedAnimals++;

            if (animal.isEmpty()) {
                System.out.println("Could not parse a string. Please, try again");
                continue;
            }
            if (!animal.equals("dog") && !animal.equals("cat")) {
                System.out.println("Incorrect input. Unsupported pet type");
                continue;
            }

            String name = scanner.nextLine().trim();

            while (!scanner.hasNextInt()) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
            int age = scanner.nextInt();
            scanner.nextLine();

            if (age <= 0) {
                System.out.println("Incorrect input. Age <= 0");
                continue;
            }

            if (animal.equals("dog"))
                pets.add(new Dog(name, age));
            else
                pets.add(new Cat(name, age));

        }
        return pets;
    }

    static void printResult(ArrayList<Animal> pets) {
        AnimalIterator<Animal> iterator = new AnimalIterator<>(pets);
        iterator.reset();
        while(iterator.hasNext()){
            Animal pet = iterator.next();
            System.out.println(pet);
        }
    }
}