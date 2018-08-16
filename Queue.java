//The first value served first

public class Queue {
	private String[] queueArray;
	private int size;
	private int front, back, numberOfItem = 0;
	
	public Queue(int size) {
		this.size = size;
		this.queueArray = new String[size];
	}
	
	public void insert(String input) {
		if(numberOfItem < size) {
			queueArray[back] = input;
			numberOfItem++;
			back++;
			System.out.println("Insert: " + input + " is added...");
		}else {
			System.out.println("Not enough space...");
		}
	}
	
	public void remove() {
		if(numberOfItem > 0) {
			System.out.println("Remove: " + queueArray[front] + " is removed...");
			queueArray[front] = "-1";
			front++;
			numberOfItem--;
		} else {
			System.out.println("Empty Queue...");
		}
	}

	public void peek() {
		if(numberOfItem > 0) {
			System.out.println("The first element is: " + queueArray[front]);
		} else {
			System.out.println("Empty queue...");
		}
	}
	public static void main(String[] args) {
		
		Queue lineUp = new Queue(5);
		
		lineUp.peek();
		
		for(int i = 0; i < 5; i++) {
			lineUp.insert("Eugene " + i);
		}
		lineUp.insert("Eugene " + 5);
		lineUp.peek();
		lineUp.remove();
		lineUp.peek();
		
	}

}
