package dictionaryelev;

public class DictionaryLinked<K, V> implements Dictionary<K, V> {

    private Node start;
    private int size;

    /**
     * HashingMap constructor comment.
     */

    public DictionaryLinked() {
        // Sentinel (tomt listehoved - der ikke indeholder data)
        start = new Node();
        size = 0;
    }

    @Override
    public V get(K key) {
        Node current = start.next;
        for (int i = 1; i < size; i++) {
            if (current.key.equals(key)) return current.value;
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Indsætter objektet value med nøgle key I dictionary. Hvis key allerede
     * eksisterer overskrives value hoerende til key vaerdi og den gamle value
     * returneres. Hvis key ikke er der returneres null. Hverken key eller value
     * maa vaere null
     */
    @Override
    public V put(K key, V value) {
        //TODO blev ikke helt færdig med det her.
        if (key == null || value == null) return null;
        V rValue = null;
        int i = 1;
        Node current = start.next;
        while (i < size && rValue == null) {
            System.out.println(i + " "+ size);
            System.out.println(current + " " + i);
            if (current.key.equals(key)) {
                rValue = current.value;
                current.value = value;
            }
            System.out.println(current);
            current = current.next;
            i++;
        }
        if (rValue == null) {
            current = new Node();
            current.key = key;
            current.value = value;
            size++;
        }
        return rValue;
    }

    @Override
    public V remove(K key) {
        Node current = start.next;
        int i = 1;
        V found = null;
        while (i < size && found == null) {
            if (current.key.equals(key)) {
                found = current.value;
                current.key = current.next.key;
                current.value = current.next.value;
                size--;
            }
            current = current.next;
            i++;
        }
        return found;
    }

    @Override
    public int size() {
        return size;
    }

    private class Node {
        Node next;
        K key;
        V value;
    }

}
