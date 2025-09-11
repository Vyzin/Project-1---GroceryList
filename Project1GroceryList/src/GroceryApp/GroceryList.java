package GroceryApp;
import java.util.Arrays;

public class GroceryList {
	
	private String[] items;
	private boolean[] checkedOffItems;
	private int numberOfItems;
	
	public GroceryList() {
		items = new String[50];
		checkedOffItems = new boolean[50];
		numberOfItems = 0;
	}
	
	public void addItem(String item) {
//		If the item already exists in the array don't put it in again
		if(checkIfItemInList(item)) {
			System.out.println("Item already exists in list!");
		} else {
			items[numberOfItems] = item;
			checkedOffItems[numberOfItems] = false;
			numberOfItems++;
		}
	}
	
	public void removeItem(String item) {
		if(checkIfItemInList(item)) {
			int index = getIndexFromInput(item);
			for (int i = index; i < numberOfItems - 1; i++) {
	            items[i] = items[i + 1];
	            checkedOffItems[i] = checkedOffItems[i + 1];
	        }
	        items[numberOfItems - 1] = null;
	        checkedOffItems[numberOfItems - 1] = false;
	        numberOfItems--;
		} else {
			System.out.println("Item doesn't exist in list!");
		}
		
	}
	
//  Helpers
	private boolean checkIfItemInList(String item) {
		for (int i = 0; i < numberOfItems; i++) {
            if (items[i].equalsIgnoreCase(item)) {
                return true;
            }
        }
		return false;
	}
	
	private int getIndexFromInput(String input) {
		if(isInteger(input)) {
			return Integer.parseInt(input);
		} else {
			for (int i = 0; i < numberOfItems; i++) {
	            if (items[i].equalsIgnoreCase(input)) {
	                return i;
	            }
	        }
		}
		return -1;
	}
	
	private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
}
