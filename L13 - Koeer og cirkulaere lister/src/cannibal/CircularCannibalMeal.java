package cannibal;

public class CircularCannibalMeal {
    private int size;
    private Node head;
    private Node tail;

    public CircularCannibalMeal() {
        this.head = null;
        this.tail = null;
    }

    void addPerson(Person person) {
        Node newNode = new Node(person);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        tail.next = head;
        size++;
    }

    Person eatRandomPerson() {
        return eatNextPerson((int) (Math.random() * size));
    }

    Person eatNextPerson(int count) {
        if (isEmpty()) {
            throw new IllegalStateException("No people left to eat!");
        }

        if (count == 0) {
            return head.person;
        }

        for (int i = 0; i < count - 1; i++) {
            head = head.next;
        }

        Node current = head.next;

        if (current == head) {
            head = null;
        } else {
            head.next = current.next;
        }
        current.next = null;
        size--;

        return current.person;
    }

    public void printPersons() {
        if (isEmpty()) {
            System.out.println("No people left to eat!");
            return;
        }

        Node current = head;
        do {
            System.out.println(current.person.getName());
            current = current.next;
        } while (current != head);
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        public Person person;
        public Node next;

        public Node(Person person) {
            this.person = person;
            this.next = null;
        }
    }
}
