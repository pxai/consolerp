package org.cuatrovientos.consolerp;

import java.util.Scanner;

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
			System.out.println("customer");

			System.out.println("currency");


			System.out.println("stock");
			System.out.println("city");
			System.out.println("role");
			System.out.println("employee");
			System.out.println("payroll");
			

			option = reader.nextLine();

			switch (option) {
			case "customer":
				tableManager = new ManageCustomer(reader);
				tableManager.manage();
				break;
			case "stock":
				tableManager = new ManageStock(reader);
				tableManager.manage();
			case "employee":
				tableManager = new ManageEmployee(reader);
				tableManager.manage();
				break;
			case "role":
				tableManager = new ManageRole(reader);
				tableManager.manage();
				break;
			case "city":
				tableManager = new ManageCity(reader);
				tableManager.manage();
				break;
			case "payroll":
				tableManager = new ManagePayroll(reader);
				tableManager.manage();
				break;
			case "currency":
				tableManager = new ManageCurrency(reader);
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
}
