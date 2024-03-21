/**
 * This class implements a hash set using separate chaining.
 */
public class HashSetLinearProbing {
	private Object[] buckets;
	private int currentSize;
	private static final String DELETED = "DELETED";

	/**
	 * Constructs a hash table.
	 *
	 * @param bucketsLength
	 *            the length of the buckets array
	 */
	public HashSetLinearProbing(int bucketsLength) {
		buckets = new Object[bucketsLength];
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
		int index = findIndex(x);
		return index != -1 && buckets[index] != null;
	}

	/**
	 * Adds an element to this set.
	 *
	 * @param x
	 *            an object
	 * @return true if x is a new object, false if x was already in the set
	 */
	public boolean add(Object x) {
		if (contains(x)) return false;
		int index = findIndex(x);
		buckets[index] = x;
		currentSize++;
		return true;
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
		int index = findIndex(x);
		if (index != -1 && buckets[index] != null) {
			buckets[index] = DELETED;
			currentSize--;
			return true;
		}
		return false;
	}

	/**
	 * Gets the number of elements in this set.
	 *
	 * @return the number of elements
	 */
	public int size() {
		return currentSize;
	}

	/**
	 * Computes the hash code of an object.
	 *
	 * @param x
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

	// method only for test purpose
	public void writeOut() {
		for (int i = 0; i < buckets.length; i++) {
			System.out.println(i + "\t" + buckets[i]);
		}
	}

	/**
	 * Finds an object in the hash table.
	 *
	 * @param x
	 * @return the index of the object in the hash table or -1 if the object is
	 */
	private int findIndex(Object x) {
		int index = hashValue(x);
		int initialIndex = index;
		while (buckets[index] != null && !buckets[index].equals(x)) {
			index = (index + 1) % buckets.length;
			if (index == initialIndex) {
				return -1;
			}
		}
		return index;
	}
}
