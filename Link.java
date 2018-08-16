
public class Link {
	public String bookName;
	public int millionsSold;
	public Link next;
	
	public Link(String name, int sold) {
		this.bookName = name;
		this.millionsSold = sold;
	}
	
	public void display() {
		System.out.println(bookName + " sales: " + millionsSold +",000,000");
	}
	
	public String toString()
	{
		return bookName;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		System.out.println(list.isEmpty());
		list.insert("Elon Musk", 1);
		list.insert("Currency War", 5);
		list.insert("How to Win Friends", 20);
		System.out.println(list.isEmpty());
		
		list.display();
		
		//list.removeFirst();
		//list.display();
		
		//System.out.println(list.find("Currency"));
		list.reverse();		
		list.display();

		//System.out.println("Total sales: " + totalSales());


		
		

	}

}

class LinkedList {
	Link head;
	
	LinkedList(){
		head = null;
	}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public void insert(String name, int sold) {
		Link newLink = new Link(name,sold);
		Link temp = null;
		/*
		if(head == null) {
			head = new Link(name,sold);
		} else {
			temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Link(name,sold);
		}
		*/
		
		//Backward linked list
		newLink.next = head;
		
		head= newLink;
	}
	
	public Link removeFirst() {
		Link linkRef = head;
		
		if(!isEmpty()) {
			head = head.next; 
		}else {
			System.out.println("Empty List...");
		}
		
		return linkRef;
	}
	
	public void display() {
		Link theLinks = head;
		
		while(theLinks != null) {
			theLinks.display();
			theLinks = theLinks.next;
		}
	}
	
	public Link find(String name) {
		Link theLink = head;
		
		while(theLink.bookName != name) {
			if(theLink.next == null) {
				return null;
			}else {
				theLink = theLink.next;
			}
		}
		
		return theLink;
	}
	
	public Link removeLink(String name) {
		
		Link current = head;
		Link previous = head;
		
		while(current.bookName != name) {
			if(current.next == null) {
				return null;
			}else {
				previous = current;
				current = current.next;
			}
		}
		
		//a match at first link
		if(current == head) {
			 head = head.next;
		} else {
			previous.next = current.next;
		}
		
		return current; // return the removed element
	}
	
	public void reverse() {
		Link current = head;
		Link previous = null;
		
		while(current != null) {
			current = current.next;
			head.next = previous;
			previous = head;
			head = current;
		}
		head = previous;
		
		
	}
	
}