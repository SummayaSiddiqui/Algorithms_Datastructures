package Queues;

import java.util.LinkedList;
import java.util.Queue;

// Animal Shelter Class
//class AnimalShelter {
//    private Queue<Dog> dogs;
//    private Queue<Cat> cats;
//    private int order;
//
//    public AnimalShelter() {
//        dogs = new LinkedList<>();
//        cats = new LinkedList<>();
//        order = 1;
//    }
//
//    public void enqueue(Animal animal) {
//        animal.setOrder(order++);
//        if (animal instanceof Dog) {
//            dogs.add((Dog) animal);
//        } else if (animal instanceof Cat) {
//            cats.add((Cat) animal);
//        }
//    }
//    public void enqueue(Animal animal) {
//        animal.setOrder(order);
//        System.out.println(animal.getName() + " is registered to the shelter with entry number: " + order);
//        order++;
//
//        if (animal instanceof Dog) {
//            dogs.add((Dog) animal);
//        } else if (animal instanceof Cat) {
//            cats.add((Cat) animal);
//        }
//    }
//    public Animal dequeueAny() {
//        if (dogs.isEmpty()) {
//            return dequeueCat();
//        } else if (cats.isEmpty()) {
//            return dequeueDog();
//        }
//
//        Dog oldestDog = dogs.peek();
//        Cat oldestCat = cats.peek();
//
//        if (oldestDog.isOlderThan(oldestCat)) {
//            return dogs.poll();
//        } else {
//            return cats.poll();
//        }
//    }
//
//    public Dog dequeueDog() {
//        return dogs.poll();
//    }
//
//    public Cat dequeueCat() {
//        return cats.poll();
//    }
//}
public class AnimalShelter {
    private Animal[] animals;
    private int front;
    private int rear;
    private int size;
    private int order;

    public AnimalShelter(int capacity) {
        this.animals = new Animal[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.order = 0;
        System.out.println("Animal Shelter initialized with capacity: " + capacity);
    }

    public boolean isFull() {
        return size == animals.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(Animal animal) {
        if (isFull()) {
            System.out.println("Shelter is full!");
            return;
        }
        animal.setOrder(order++);
        rear = (rear + 1) % animals.length;
        animals[rear] = animal;
        size++;
        System.out.println(animal.getName() + " is added to the shelter with entry number: " + animal.getOrder());
    }

    public Animal dequeueAny() {
        if (isEmpty()) {
            System.out.println("No animals available for adoption.");
            return null;
        }
        Animal oldest = animals[front];
        front = (front + 1) % animals.length;
        size--;
        return oldest;
    }

    public Dog dequeueDog() {
        return (Dog) dequeueSpecific(Dog.class);
    }

    public Cat dequeueCat() {
        return (Cat) dequeueSpecific(Cat.class);
    }

    private Animal dequeueSpecific(Class<? extends Animal> type) {
        if (isEmpty()) {
            System.out.println("No animals available.");
            return null;
        }

        for (int i = 0; i < size; i++) {
            int index = (front + i) % animals.length;
            if (type.isInstance(animals[index])) {
                Animal adopted = animals[index];

                for (int j = index; j != rear; j = (j + 1) % animals.length) {
                    animals[j] = animals[(j + 1) % animals.length];
                }

                rear = (rear - 1 + animals.length) % animals.length;
                size--;
                return adopted;
            }
        }

        System.out.println("No " + type.getSimpleName() + " available.");
        return null;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("All animals are adopted");
        } else {
            System.out.print("Animals in shelter: ");
            for (int i = 0; i < size; i++) {
                int index = (front + i) % animals.length;
                System.out.print(animals[index].getName() + " ");
            }
            System.out.println();
        }
    }
}