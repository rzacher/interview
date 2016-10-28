package newstuff;

public class Box<T> {
	 private T t = null; 

	 public void set(T t) {
		 this.t = t;
	 }
	 
	 public T get() {
		 return t; 
	 }
	 
	 public static void main(String args[]) {
		 Box<Integer> box = new Box<Integer>();
		 box.set(5);
		 System.out.println("Box =" + box.get());
		 
		 Box<Double> boxDouble = new Box<Double>();
		 boxDouble.set(3.5);
		 System.out.println("BoxDouble =" + boxDouble.get());
	 }
}
