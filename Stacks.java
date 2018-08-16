import java.util.Arrays;

//The last value served first

public class Stacks {

	private String[] stackArray;
	private int stackSize;
	private int top = -1; //array starts at 0, so top is -1 when there is nothing
	
	public Stacks(int size) {
		this.stackSize = size;
		this.stackArray = new String[size];
		
		Arrays.fill(stackArray, "-1");
		
	}
	
	public void push(String input) {
		if(top+1 < stackSize) {
			top++;
			
			stackArray[top] = input;
			
			System.out.println("Push: " + stackArray[top] + " is added to the stack...");
		} else {
			System.out.println("Not enough space! OKAY?");
		}
	}
	
	public String pop() {
		if(top >= 0) {
			System.out.println("Pop: " + stackArray[top] + " is removed from the stack");
			stackArray[top] = null;
			top--;
			return stackArray[top];
		}else {
			System.out.println("The whole stack is empty...");
			return "-1";
		}
	}
	
	public String peek() {
		if(top > 0) {
			System.out.println("The top of the stack: " + stackArray[top]);
			return stackArray[top];
		} else {
			System.out.println("Stacks are empty...");
			return "-1";
		}
	}
	
	public static void main(String[] args) {
		//testing by adding stacks
		Stacks bricks = new Stacks(5); //5 blocks
		
		bricks.peek();
		
		for(int i = 0; i < 5; i++) {
			bricks.push("Eugene "+i);
		}
		bricks.push("Eugene "+5);
		bricks.pop();
		bricks.push("Eugene "+5);
		bricks.peek();
		
	}

}
