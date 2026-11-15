public class Dog extends Animal implements Omnivore{
    public String hunt(){
        return "I can hunt for robbers";
    }

    public Dog(String name, int age){
        super(name, age);
    }

    public String toString(){
        return "Dog name = " + getName() + ", age = " + getAge() + ". " + hunt();
    }
}