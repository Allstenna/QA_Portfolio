import java.util.ArrayList;

public class AnimalIterator<T> implements BaseIterator<T>{
    private ArrayList<T> animalsList;
    private int index;

    public AnimalIterator(ArrayList<T> animalsList) {
        this.animalsList = animalsList;
        this.index = 0;
    }
    public T next(){
        if (!hasNext()) {
            return null;
        }
        T animal = animalsList.get(index);
        index++;
        return animal;
    }
    public boolean hasNext(){
        return index < animalsList.size();
    }
    public void reset(){
        index = 0;
    }
}