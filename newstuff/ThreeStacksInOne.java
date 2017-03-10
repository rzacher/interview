package newstuff;
// stacks and queues problem 3.1 Cracking the coding interview

public class ThreeStacksInOne {
    public static int NUM_STACKS = 3; 
    public static int STACK_SIZE = 100;

    int[] stackPointer = {-1,-1,-1};

    int[] buffer = new int[STACK_SIZE * NUM_STACKS];
     
	public static void main(String[] args) {
		ThreeStacksInOne ts = new ThreeStacksInOne();
		ts.test();
    }

    public void test() {
      push(1, 1);
      push(1, 2);
      push(1, 3);
      pop(1); 
      printStack(1);  // expecting [1,2];
    }
    
    public void printStack(int stack) {
         if (stackPointer[stack] < 0) {
             System.out.println("Stack is empty");
             return;
         }

         for (int i=stack * STACK_SIZE; i<=stack * STACK_SIZE + stackPointer[stack]; i++) {
             System.out.print(buffer[i] + " "); 
         }
         System.out.println("");
         return; 
    }

    public void push(int stack, int value) throws IndexOutOfBoundsException {
       if ((stack >= NUM_STACKS) || (stackPointer[stack] + 1 >= STACK_SIZE) || ((stack * STACK_SIZE + stackPointer[stack] + 1) >= NUM_STACKS*STACK_SIZE)) {
          throw new IndexOutOfBoundsException();
       }

       // get the last absolute index
       int index = stack * STACK_SIZE + stackPointer[stack];
       int newIndex = index + 1;
       System.out.println("Add " + value + " at index " + newIndex); 
       stackPointer[stack]++;
       buffer[newIndex] = value;
    }

    public int pop(int stack) throws IllegalStateException {
       // calc the absolute index
       int index = stack * STACK_SIZE + stackPointer[stack];
       // check bounds on index 
       if ((index < 0) || (index >= NUM_STACKS * STACK_SIZE) || (stack >= NUM_STACKS)) {
          throw new IllegalStateException(); 
       }
        
       int value = buffer[index];
       // Now decrement the stackPointer
       stackPointer[stack]--;
       return value;
    }

}
