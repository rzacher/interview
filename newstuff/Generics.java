package newstuff;

public class Generics<K, V extends Number> {
	K key;
	V value;
	
	public Generics(K k, V v) {
		this.key = k;
		this.value = v;
	}
	
	public K getKey() { return key;}
	
	public V getValue() { return value;}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Generics<Integer, Double> generic = new Generics<>(1, 2.5);
		System.out.println("key is " + generic.getKey());
		System.out.println("value is " + generic.getValue());
	
	}

}
