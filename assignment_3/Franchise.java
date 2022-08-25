/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 3
 * Due Date: 02/14/2022
 * Date Submitted: 02/14/2022
 */

package assignment_3;

public class Franchise {
	// Declares variable
	private Store stores[];
	
	// Constructor
	public Franchise(int num) {
		stores = new Store[num];
	}
	
	// Get a store
	public Store getStores(int i) {
		return stores[i];
	}

	// Set a store
	public void setStores(Store stores, int i) {
		this.stores[i] = stores;
	}
	
	// Get number of stores
	public int numberofstores()
	{
		return stores.length;
	}
	
	// Do calculation for all stores
	public void calc() {
		for(int i = 0; i < stores.length; i++) {
			stores[i].analyzeresult();
		}
	}
}

