
public class HashFunction {

	String[] theArray;
	int size;
	int itemsArray = 0;
	
	HashFunction(int size){
		this.size = size;
		theArray = new String[size];
	}
	
	public static void main(String[] args) {
		HashFunction hash = new HashFunction(30); 
		
		/*
		String[] elementsToAdd = {"1", "5", "17", "21", "26"};
		hash.hashFunction1(elementsToAdd, hash.theArray); 
		//basically this is an example of input the number same as the index
		//eg. input "1" converted to integer: 1, then interger: 1 is placed at index 1
		
		for(int i = 0; i < 30; i++)
		System.out.println("Array " + i + " : " + hash.theArray[i]); 
		*/
		
		String[] elementsToAdd2 = { "100", "510", "170", "214", "268", "398",
                "235", "802", "900", "723", "699", "1", "16", "999", "890",
                "725", "998", "978", "988", "990", "989", "984", "320", "321",
                "400", "415", "450", "50", "660", "624" };
		
		hash.hashFunction2(elementsToAdd2, hash.theArray);
		hash.findKey("100");
	}
	
	//Hash function 1 (a bad one)
	public void hashFunction1(String[] stringsArray, String[] theArray) {
		for(int i = 0; i < stringsArray.length; i++) {
			
			String newElement = stringsArray[i];
			theArray[Integer.parseInt(newElement)] = newElement; // ** line for hash function
		}
	}
	
	//Hash function 2 (reduce small collision-> 
	//meaning array is full and not available for insertion)
	public void hashFunction2(String[] stringsArray, String[] theArray) {
		
		for(int i = 0; i < stringsArray.length; i++) {
			
			String newElement = stringsArray[i];
			
			int newIndex = Integer.parseInt(newElement) % 29;
			//index to store the value in
			
			System.out.println("Modulus Index = " + newIndex + " for " + newElement);
			
			//cycle array to find empty slot
			while(theArray[newIndex] != null) {
				++newIndex;
				
				System.out.println("Collision Try " + newIndex + " Instead");
				
				newIndex %= size;
				//make sure newIndex doesn't exceed array size
			}
			
			theArray[newIndex] = newElement;
		}
	}
	
	public String findKey(String key) {
		
		int hashIndex = Integer.parseInt(key) % 29;
		int notFound = hashIndex;
		
		while(theArray[hashIndex] != null) {
			
			if(theArray[hashIndex] == key) {
				System.out.println(key + " was found in index " + hashIndex);
				
				return theArray[hashIndex];
			}
			
			++hashIndex;
			
			hashIndex %= size;
			
			//solution for infinite loop bug =)
			if(hashIndex == notFound)
				break;
			
		}
		
		System.out.println("Key Not Found...");
		return null;
	}
}
