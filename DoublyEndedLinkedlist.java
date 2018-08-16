
public class DoublyEndedLinkedlist {

	Neighbor firstLink;
	Neighbor lastLink;
	
	public boolean isEmpty() {
		return (firstLink == null);
	}
	
	public void insertFirst(String name, int num) {
		Neighbor newLink = new Neighbor(name,num);
		
		if(isEmpty()) {
			lastLink =  newLink;
			
		}else {
			firstLink.previous = newLink;
		}
		newLink.next = firstLink;
		firstLink = newLink;
	}
	
	public void insertLast(String name, int num) {
		Neighbor newLink = new Neighbor(name,num);

		if(isEmpty()) {
			firstLink =  newLink;
			
		} else {
			lastLink.next = newLink;
			
			newLink.previous = lastLink;
			
		}
		lastLink = newLink;
	}
	
	public boolean insertAfterKey(String name, int num, int key) {
		Neighbor newLink = new Neighbor(name,num);
		
		Neighbor current = firstLink;
		
		while(current.houseNumber != key) {
			current = current.next;
			
			if(current == null) {
				return false;
			}
		}
		
		if(current == lastLink) {
			newLink.next = null;
			lastLink = newLink;
		}else {
			newLink.next = current.next;
			current.next.previous = newLink;
		}
		
		//doubly linked previous and next of inserted object to previous object
		newLink.previous = current;
		current.next = newLink;
		return true;
	}
	
	public void insertInOrder(String name, int num) {
		Neighbor newLink = new Neighbor(name,num);
		
		Neighbor previous = null;
		Neighbor current = firstLink;
		
		while(current != null && (num > current.houseNumber)) {
			
			previous = current;
			current = current.next;
		}
		
		if(previous == null) {
			firstLink = newLink;
		}else {
			previous.next = newLink;
		}
		
		newLink.next = current;
	}
	
	public static void main(String[] args) {
		DoublyEndedLinkedlist list = new DoublyEndedLinkedlist();
		/*
		list.insertFirst("Mody", 141);
		list.insertFirst("Antonio", 142);
		list.insertFirst("Hawton", 143);
		
		list.display();
		*/
		list.insertInOrder("Mody", 143);
		list.insertInOrder("Antonio", 142);
		list.insertInOrder("Hawton", 141);
		
		//list.display();
		
		//Using list iterator
		Iterator neighbors = new Iterator(list);
		neighbors.current.display();
		neighbors.next();//move to next object
		neighbors.current.display();

	}
	
	public void display() {
		Neighbor current = firstLink;
		
		while(current != null) {
			current.display();
			System.out.println("Next Link is " + current.next);
			current = current.next;
		}
	}

}


class Neighbor {
	public String homeOwnerName;
	public int houseNumber;
	
	public Neighbor next;
	public Neighbor previous;
	
	public Neighbor(String name, int num) {
		this.homeOwnerName = name;
		this.houseNumber = num;
	}
	
	public void display() {
		System.out.println(homeOwnerName + ": " + houseNumber + " Benlea Drive");
	}
	
	public String toString() {
		return homeOwnerName;
	}
}

class Iterator{
	
	Neighbor current;
	Neighbor previous;
	
	DoublyEndedLinkedlist link;
	
	Iterator(DoublyEndedLinkedlist link){
		this.link = link;
		current = link.firstLink;
		previous = link.lastLink;
	}
	
	public boolean hasNext() {
		if(current.next != null) {
			return true;
		}
		return false;
	}
	
	public Neighbor next() {
		if(hasNext()) {
			previous = current;
			current = current.next;
			
			return current;
		}
		return null;
	}
	
	public void remove() {
		if(previous != null) {
			link.firstLink = current.next;
		} else {
			previous.next = current;
			
			if(current.next == null) {
				current = link.firstLink;
				previous = null;
			} else {
				current = current.next;
			}
		}
	}
	
}
