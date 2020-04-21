public class HashMap<K,V> 
{
	private Entry<K, V>[] buckets;
	private int capacity;
	private int size = 0;
	
	private double lf = 0.75;
	
	public HashMap() {
		this.capacity = 16;
	}
	
	public HashMap(int capacity) {
		this.capacity = capacity;
		this.buckets = new Entry[this.capacity];
	}
	
	public void put(K key, V value) 
	{
		if (size == lf * capacity) {
			// rehash
			Entry<K, V>[] old = buckets;
			
			capacity *= 2;
			size = 0;
			buckets = new Entry[capacity];
			
			for (Entry<K, V> e: old) 
			{
				while (e!= null) 
				{
					put(e.key, e.value);
					e = e.next;
				}
			}
		}
		
		Entry<K, V> entry = new Entry<>(key, value, null);
		
		int bucket = hash(key) % getBucketSize();
		
		Entry<K, V> existing = buckets[bucket];
		if (existing == null) {
			buckets[bucket] = entry;
			size++;
		} else {
			// compare the keys see if key already exists
			while (existing.next != null) {
				if (existing.key.equals(key)) {
					existing.value = value;
					return;
				} 
				existing = existing.next;
			}
			
			if (existing.key.equals(key)) {
				existing.value = value;
			} else {
				existing.next = entry;
				size++;
			}
		}
	}
	
	public V get(K key) {
		Entry<K, V> bucket = buckets[hash(key) % getBucketSize()];
		
		while (bucket != null) {
			if (key == bucket.key) {
				return bucket.value;
			}
			bucket = bucket.next;	
		}
		
		return null;
	}
	
	public int size() {
		return size;
	}

	private int hash(K key) {
		return key == null ? 0: Math.abs(key.hashCode());
	}
	
	private int getBucketSize() {
		return buckets.length;
	}
}

class Entry<K, V> 
{
	final K key;
	V value;
	Entry<K,V> next;
	
	public Entry(K key, V value, Entry<K, V> next) 
	{
		this.key = key;
		this.value = value;
		this.next = next;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Entry<K, V> getNext() {
		return next;
	}

	public void setNext(Entry<K, V> next) {
		this.next = next;
	}

	public K getKey() {
		return key;
	}
	
	@Override
	public int hashCode() {
		int hash = 13;
		hash = 17 * hash + ((key == null) ? 0: key.hashCode());
		hash = 17 * hash + ((value == null)? 0: value.hashCode());
		return hash;
	}
	
	@Override
	public String toString() {
		return "{" + key + ", " + value + "}";
	}

}

