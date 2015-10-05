package org.cuatrovientos.consolerp;

import java.util.Scanner;
import java.util.Vector;

import org.cuatrovientos.consolerp.dao.CustomerDAO;
import org.cuatrovientos.consolerp.model.Customer;

public class ManageCustomer 
	extends ManageTable {
	
	private CustomerDAO customerDAO;
	private Scanner reader;

	/**
	 * constructor
	 */
	public ManageCustomer (Scanner reader) {
		customerDAO = new CustomerDAO();
		this.reader = reader;
	}
	
	@Override
	public void manage() {
		String option;
		String name;
		Customer customer;
		int id = 0;
		do {
			showMenu("Customer");

			option = reader.nextLine();

			switch (option) {
			case "1":
				Vector<Customer> result = customerDAO.selectAll();
				System.out.println(result.toString());
				break;
			case "2":
				System.out.println("Enter an Id");
				id = Integer.parseInt(reader.nextLine());
				customer = customerDAO.selectById(id);
				System.out.println(customer.toString());
				break;
			case "3":
				System.out.println("Enter a name");
				name = reader.nextLine();
				customer = customerDAO.selectByName(name);
				System.out.println(customer.toString());
				break;
			case "4":
				System.out.println("Enter an Id");
				id = Integer.parseInt(reader.nextLine());
				System.out.println("Enter a name");
				name = reader.nextLine();
				customer = new Customer(id, name);
				customerDAO.insert(customer);
				break;
			case "5":
				System.out.println("Enter existing Id");
				id = Integer.parseInt(reader.nextLine());
				System.out.println("Enter a name");
				name = reader.nextLine();
				customer = new Customer(id, name);
				customerDAO.update(customer);
				break;
			case "6":
				System.out.println("Enter existing Id");
				id = Integer.parseInt(reader.nextLine());
				customerDAO.delete(id);
				break;
			case "7":
				System.out.println("Enter a CSV filename to Import");
				name = reader.nextLine();
				customerDAO.importCSV(name);
				break;
			case "8":
				System.out.println("Enter a CSV filename to Export");
				name = reader.nextLine();
				customerDAO.exportCSV(name);
				break;
			default:
				System.out.println("Ok, see you around");
				break;
			}

		} while (!option.equals("9"));
	}

}
