package hw1;

import java.util.ArrayList;

public class third_hw {
    public static void main(String[] args) {
        Box box = new Box();
        Fruit apple = new Apple();
        box.addFruit(apple);
        Fruit neworange = new Orange();
        box.addFruit(neworange);

        Box box2 = new Box();
        box2.changeBoxes(box);
        for (int i = 0; i < box2.list.size(); i++) {
            System.out.println(box2.getNameOfFruit(i));
        }
    }
}class Fruit{
    private float weight;
    private String name;
    public float getWeight(){
        return weight;
    }
    public void setName(String str){
        this.name = str;
    }
    public String getName(){
        return name;
    }


}
class Apple extends Fruit{
    Apple(){
        setName("apple");
    }
    @Override
    public float getWeight() {
        return super.getWeight();
    }
}class Orange extends Fruit{
    Orange(){
        setName("orange");
    }
    @Override
    public float getWeight() {
        return super.getWeight();
    }
}class Box <T extends Fruit> {
    public ArrayList<T> list;
    public Box(){
        list = new ArrayList<>();
    }
    public <T extends Fruit> boolean compare(T fruit1,T fruit2){
        return fruit1.getWeight() > fruit2.getWeight();
    }

    public void changeBoxes(Box oldbox){
        for (Object fruit : oldbox.list) {
            this.addFruit((T) fruit);
        }
    }
    public void addFruit(T fruit){
        if (list.size() == 0){
            list.add(fruit);
        }else{
            if (list.get(list.size() - 1) == fruit){
                list.add(fruit);
            }
        }
    }
    public String getNameOfFruit(int index){
        return list.get(index).getName();
    }



}

