package amazon;

import java.util.*;

public class MathParser {
  Stack<Integer> numberStack = new Stack<Integer>();
  Stack<Operator> operatorStack = new Stack<Operator>

  public MathParser() {
  
  }

  int processMathString(String input) {
     
     for (int i=0; i<cleanString.length; i++) {
     
       int nextNum = parseNextNumber(input, i);
       
       
       Operator currentOp = parseNextOperator(input, i);
       
       // Look at the current operator on the stack
       Operator previousOp = operatorStack.peek(); 
       if (currentOp.priority() <= previousOp.priority()) {
          // Process the previousOp 
          previousOp = operatorStack.pop(); 
          int previousNum = numberStack.pop(); 
          int result = doOperation(previousNum, previousOp, nextNum);
          // push the result on the number stack
          numberStack.add(result); 
       }                                           
  }
  
  int doOperation(int a, Operator op, int b) throw InvalidArgumentException {
    if (op == Operator.ADD) { return a + b;}
    else if (op == Operator.SUBTRACT) { return a-b;}
    else if (op == Operator.MULTIPLY) {return a*b;}
    else if (op == Operator.DIVIDE} { return a/b;}
    else {
      throw InvalidArgumentException("Unknown operator");
    }
  
  }
  // Get the priority of an operator
  int priority(Enun operator) {
    if ((operator == Operator.ADD) || (operator == Operator.SUBTRACT)) {
      return 1; 
    } else {
      return 2; 
    }
  }
  
  int parseNextNumber(String input, int i) {
    StringBuilder sb = new StringBuilder();
    while (i<input.length) {
        char next = input.charAt(i);
        if (Character.isDigit(next)) {
           sb.add(next);
           i++;
        } else { // out of digits
           return Integer.parseInt(sb.toString()); 
        }
    }
  
  }
  
  private class Enum Operator {
       ADD, SUBTRACT, MULTIPLY, DIVIDE
  }
  
  public static void main(String[] args) {
  
     if (args.length < 1) {
       System.out.println("Help..");
     } else {
       String input = args[0];
       int result = processMathString(input);
       System.out.println("The answer is " + result);
     }
    
  
  }
}
