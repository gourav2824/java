import java.util.ArrayList;

public class HashMap<K, V> {

	private class HMNode {

		K key;
		V value;

		public HMNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	Linked_List<HMNode>[] buckets;
	private int size;

	public HashMap() {

		buckets = new Linked_List[4];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new Linked_List<>();
		}
	}

	public boolean containsKey(K key) {

		int bi = hashFunction(key);
		HMNode hmnode = findWithinBucket(bi, key);

		if (hmnode == null) {
			return false;
		}

		else {
			return true;
		}
	}

	public V get(K key) {

		int bi = hashFunction(key);
		HMNode hmnode = findWithinBucket(bi, key);

		if (hmnode == null) {
			return null;
		}

		else {
			return hmnode.value;
		}
	}

	public V remove(K key) {

		int bi = hashFunction(key);
		HMNode hmnode = findWithinBucket(bi, key);

		if (hmnode == null) {
			return null;
		}

		else {
			removeFromBucket(bi, key);
			size--;
			return hmnode.value;
		}
	}

	public void put(K key, V value) {

		int bi = hashFunction(key);
		HMNode hmnode = findWithinBucket(bi, key);

		if (hmnode == null) {

			hmnode = new HMNode(key, value);
			buckets[bi].addLast(hmnode);
			size++;
		}

		else {
			hmnode.value = value;
		}
	}

	public ArrayList<K> keySet() {

	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {

	}

	public void display() {

	}

	private int hashFunction(K key) {

		int hc = key.hashCode();
		return Math.abs(hc) % buckets.length;
	}

	private HMNode findWithinBucket(int bi, K key) {

		for (int di = 0; di < buckets[bi].size(); di++) {

			HMNode hmnode = buckets[bi].getAt(di);
			if (hmnode.key.equals(key)) {
				return hmnode;
			}
		}

		return null;
	}

	private void removeFromBucket(int bi, K key) {

		for (int di = 0; di < buckets[bi].size(); di++) {

			HMNode hmnode = buckets[bi].getAt(di);
			if (hmnode.key.equals(key)) {
				buckets[bi].removeAt(di);
				return;
			}
		}
	}
}