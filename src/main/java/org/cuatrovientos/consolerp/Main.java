package org.cuatrovientos.consolerp;

import java.util.Scanner;


import org.cuatrovientos.consolerp.dao.CustomerDAO;


/**
 * Main entrypoint for consolerp project
 * 
 * @author 2DAM
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("Hello DAM");
		String option = "0";
		Scanner reader = new Scanner(System.in);
		
		// Interface for table management
		ManageTable tableManager;

		do {
			System.out.println("Please, select a table or exit:");
			System.out.println("customer, supplier");

			option = reader.nextLine();

			switch (option) {
			case "customer":
				tableManager = new ManageCustomer(reader);
				tableManager.manage();
				break;
			case "supplier":
				tableManager = new ManageSupplier(reader);
				tableManager.manage();
				break;
			case "exit":
				System.out.println("Bye!");
				break;
			default:
				System.err.println("Unknown table");
				break;

			}
		} while (!option.equals("exit"));
	}

	/**
	 * Manage Customer
	 * 
	 * @param id
	 * @param reader
	 * @param bd
	 * @return
	 */
	private static void manageCustomer(Scanner reader, CustomerDAO bd) {
		

	}


}
