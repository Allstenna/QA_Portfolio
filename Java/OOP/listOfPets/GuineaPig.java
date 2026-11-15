public class GuineaPig extends Animal implements Herbivore{
    public String chill(){
        return "I can chill for 12 hours";
    }

    public GuineaPig(String name, int age){
        super(name, age);
    }

    public String toString(){
        return "GuineaPig name = " + getName() + ", age = " + getAge() + ". " + chill();
    }
}