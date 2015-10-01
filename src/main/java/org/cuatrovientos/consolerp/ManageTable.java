/**
 * 
 */
package org.cuatrovientos.consolerp;

/**
 * Interface that management code must implement
 * @author user
 *
 */
public class ManageTable {
	public void manage () {
		
	}
	
	/**
	 * shows menu for a given entity
	 */
	protected void showMenu(String entity) {
		System.out.println("Enter option");
		System.out.println("1.- Select all");
		System.out.println("2.- Select by Id");
		System.out.println("3.- Insert " + entity);
		System.out.println("4.- Update " + entity);
		System.out.println("5.- Delete " + entity);
		System.out.println("6. Exit");
	}
}
