package Queues;

public class Main {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter(6);

        shelter.enqueue(new Dog("Buddy"));
        shelter.enqueue(new Cat("Whiskers"));
        shelter.enqueue(new Cat("Molly"));
        shelter.enqueue(new Dog("Bella"));
        shelter.enqueue(new Dog("Rex"));
//        shelter.enqueue(new Cat("Lola"));
//        shelter.enqueue(new Cat("Mittens"));

        shelter.printQueue();

        Animal adopted1 = shelter.dequeueAny();
        if (adopted1 != null) {
            System.out.println("Adopted: " + adopted1.getName());
        }

        Animal adopted2 = shelter.dequeueAny();
        if (adopted2 != null) {
            System.out.println("Adopted: " + adopted2.getName());
        }

        Animal adopted3 = shelter.dequeueCat();
        if (adopted3 != null) {
            System.out.println("Adopted: " + adopted3.getName());
        }

        Animal adopted4 = shelter.dequeueCat();
        if (adopted4 != null) {
            System.out.println("Adopted: " + adopted4.getName());
        }

        Animal adopted5 = shelter.dequeueDog();
        if (adopted5 != null) {
            System.out.println("Adopted: " + adopted5.getName());
        }

        Animal adopted6 = shelter.dequeueDog();
        if (adopted6 != null) {
            System.out.println("Adopted: " + adopted6.getName());
        }

        shelter.printQueue();
    }
}
