/**
 * 
 */
package org.cuatrovientos.consolerp;

/**
 * Interface that management code must implement
 * @author oskar
 *
 *
 *
 */
public class ManageTable {
	public void manage () {
		
	}
	
	/**
	 * shows menu for a given entity
	 * 
	 */
	protected void showMenu(String entity) {
		System.out.println("Enter option");
		System.out.println("1.- Select all");
		System.out.println("2.- Select by Id");

		System.out.println("3.- Insert " + entity);
		System.out.println("4.- Update " + entity);
		System.out.println("5.- Delete " + entity);
		System.out.println("6.-Select by login");
		System.out.println("7. Exit");

		System.out.println("3.- Select by Name");
		System.out.println("4.- Insert " + entity);
		System.out.println("5.- Update " + entity);
		System.out.println("6.- Delete " + entity);
		System.out.println("7.- Import CSV");
		System.out.println("8.- Export CSV");
		System.out.println("9. Exit");

	}
}
