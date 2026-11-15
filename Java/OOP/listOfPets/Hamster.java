public class Hamster extends Animal implements Herbivore{
    public String chill(){
        return "I can chill for 8 hours";
    }

    public Hamster(String name, int age){
        super(name, age);
    }

    public String toString(){
        return "Hamster name = " + getName() + ", age = " + getAge() + ". " + chill();
    }
}