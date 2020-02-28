package cse360assign2;

import java.util.*;
import java.lang.Math;

public class SimpleList { // class declaring list and count variables
	int[] list;
	int count;


public SimpleList() { // constructor method initializing list and count variables
	list = new int[10];
	count = 0;
}

public void add(int parameter) {
	int arraySize = list.length;
	if (count < arraySize) { // ensures count does not exceed array size
		count++;
	}
	else {
		int newSize = (int) Math.floor(list.length * 1.5); // if no room in array, makes new array 50% larger
		arraySize = newSize;
		int[] newList = Arrays.copyOf(list, arraySize); // copies elements into new array
		list = newList; // uses new array with padding
		count++;
	}
	
	for(int index = count - 1; index >= 0; index--) { // shifts values in array right by 1
		if (index != list.length-1) { // ensures last value does not go out of bounds 
			list[index + 1] = list[index];
		}
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
	
	list[count] = 0; // sets last element to zero
	
	if (count <= ((int) Math.floor(list.length * 0.75))) { // resizes array if more than 25% empty elements
		int[] newList = Arrays.copyOf(list, count); // copies elements into truncated array
		list = newList;
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

public void append(int parameter) {
	if (count < list.length) { // adds parameter to array if array has room
		list[count] = parameter;
	}
	else {
		int newSize = (int) Math.floor(list.length * 1.5); // if no room in array, makes new array 50% larger
		int[] newList = Arrays.copyOf(list, newSize); // copies elements into new array
		list = newList; // uses new array with padding
		list[count] = parameter; // adds parameter to new array
	}
	count++; // increments count
}

public int first() { // returns first element in array
	return list[0];
}

public int size() { // returns number of empty elements in array
	return list.length-count;
}

}
