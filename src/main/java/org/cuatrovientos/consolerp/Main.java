package org.cuatrovientos.consolerp;

import java.util.Scanner;
import java.util.Vector;

import org.cuatrovientos.consolerp.dao.CustomerDAO;
import org.cuatrovientos.consolerp.model.Customer;
import org.cuatrovientos.consolerp.model.State;

/**
 * Main entrypoint for consolerp project
 * 
 * @author 2DAM
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("Hello DAM");
		String option = "0";
		int id = 0;
		String name = "";
		Customer customer = null;
		State state = null;
		Scanner reader = new Scanner(System.in);
		
		// Interface for table management
		ManageTable tableManager;

		do {
			System.out.println("Please, select a table or exit:");
			System.out.println("customer");
			System.out.println("state");

			option = reader.nextLine();

			switch (option) {
			case "customer":
				tableManager = new ManageCustomer(reader);
				tableManager.manage();
				break;
			case "state":
				tableManager = new ManageState(reader);
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
	private static void manageState(Scanner reader, CustomerDAO bd) {
		

	}


}
