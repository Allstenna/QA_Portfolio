public class Cat extends Animal implements Omnivore{
    public String hunt(){
        return "I can hunt for mice";
    }

    public Cat(String name, int age){
        super(name, age);
    }

    public String toString(){
        return "Cat name = " + getName() + ", age = " + getAge() + ". " + hunt();
    }
}