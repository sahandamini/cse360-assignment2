package cse360assign2;

public class SimpleList { // class declaring list and count variables
	int[] list;
	int count;


public SimpleList() { // constructor method initializing list and count variables
	list = new int[10];
	count = 0;
}

public void add(int parameter) {
	for(int index = count - 1; index >= 0; index--) { // shifts values in array right by 1
		if (index != list.length-1) { // ensures last value does not go out of bounds 
			list[index + 1] = list[index];
		}
	}
	if (count < 10) { // ensures count does not exceed array size
		count++;
	}
	
	list[0] = parameter; // adds parameter at index 0
}

public void remove(int parameter) {
	int location = search(parameter); // finds location of parameter to be removed
	
	if (location != -1) { // ensures parameter is in array
		count--;
		int index = location;
		while(index < list.length - 1) { // shifts elements to left by 1
			list[index] = list[index+1];
			index++;
		}
	}
}

public int count() { // returns count value
	return count;
}

public String toString() {
	String stringArray = "";
	
	for(int index = 0; index < list.length; index++) { // concatenates array into string
		stringArray += list[index] + " ";
	}
	
	return stringArray.trim(); // trims final whitespace and returns string of array
}

public int search(int number) {
	int location = -1;
	
	for (int index = 0; index < count; index++) { // loops through array until it finds value
		if (list[index] == number) {
			location = index;
		}
	}
	
	return location; // returns location of value in array
}

}
