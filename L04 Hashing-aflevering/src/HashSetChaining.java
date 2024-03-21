/**
 * This class implements a hash set using separate chaining.
 */
public class HashSetChaining {
	private Node[] buckets;
	private int currentSize;

	/**
	 * Constructs a hash table.
	 *
	 * @param bucketsLength
	 *            the length of the buckets array
	 */
	public HashSetChaining(int bucketsLength) {
		buckets = new Node[bucketsLength];
		currentSize = 0;
	}

	/**
	 * Tests for set membership.
	 *
	 * @param x
	 *            an object
	 * @return true if x is an element of this set
	 */
	public boolean contains(Object x) {
		int h = hashValue(x);
		Node current = buckets[h];
		boolean found = false;
		while (!found && current != null) {
			if (current.data.equals(x)) {
				found = true;
			} else {
				current = current.next;
			}
		}
		return found;
	}

	/**
	 * Adds an element to this set.
	 *
	 * @param x
	 *            an object
	 * @return true if x is a new object, false if x was already in the set
	 */
	public boolean add(Object x) {
		int h = hashValue(x);

		// load factor >= 0.75 then go for rehashing
		if (currentSize >= 0.75 * buckets.length) {
			rehash();
			h = hashValue(x);
		}

		Node current = buckets[h];
		boolean found = false;
		while (!found && current != null) {
			if (current.data.equals(x)) {
				found = true;
				// Already in the set
			} else {
				current = current.next;
			}

		}
		if (!found) {
			Node newNode = new Node();
			newNode.data = x;
			newNode.next = buckets[h];
			buckets[h] = newNode;
			currentSize++;
		}
		return !found;
	}

	/**
	 * Removes an object from this set.
	 *
	 * @param x
	 *            an object
	 * @return true if x was removed from this set, false if x was not an
	 *         element of this set
	 */
	public boolean remove(Object x) {
		int h = hashValue(x);
		Node current = buckets[h];
		Node previous = null;
		boolean found = false;
		while (!found && current != null) {
			if (current.data.equals(x)) {
				found = true;
				if (previous == null) {
					buckets[h] = current.next;
				} else {
					previous.next = current.next;
				}
				currentSize--;
			} else {
				previous = current;
				current = current.next;
			}
		}
		return found;
	}

	/**
	 * Computes the hash code of the given object.
	 *
	 * @param x
	 *            an object
	 * @return the hash code
	 */
	private int hashValue(Object x) {
		int h = x.hashCode();
		if (h < 0) {
			h = -h;
		}
		h = h % buckets.length;
		return h;
	}

	/**
	 * Gets the number of elements in this set.
	 *
	 * @return the number of elements
	 */
	public int size() {
		return currentSize;
	}

	// method only for test purpose
	void writeOut() {
		for (int i = 0; i < buckets.length; i++) {
			Node temp = buckets[i];
			if (temp != null) {
				System.out.print(i + "\t");
				while (temp != null) {
					System.out.print(temp.data + "\t");
					temp = temp.next;
				}
				System.out.println();
			}
		}
	}

	/**
	 * Rehashes the set so that it has twice the number of buckets.
	 */
	public void rehash() {
		Node[] old = buckets;
		buckets = new Node[2 * old.length + 1];
        for (Node node : old) {
            Node current = node;
            while (current != null) {
                Object x = current.data;
                int h = hashValue(x);
                Node newNode = new Node();
                newNode.data = x;
                newNode.next = buckets[h];
                buckets[h] = newNode;
                current = current.next;
            }
        }
	}

	class Node {
		public Object data;
		public Node next;
	}

}
