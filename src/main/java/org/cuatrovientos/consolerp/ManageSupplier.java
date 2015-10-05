package org.cuatrovientos.consolerp;

import java.util.Scanner;
import java.util.Vector;

import org.cuatrovientos.consolerp.dao.SupplierDAO;
import org.cuatrovientos.consolerp.model.Supplier;

public class ManageSupplier 
	extends ManageTable {
	
	private SupplierDAO supplierDAO;
	private Scanner reader;

	/**
	 * constructor
	 */
	public ManageSupplier (Scanner reader) {
		supplierDAO = new SupplierDAO();
		this.reader = reader;
	}
	
	@Override
	public void manage() {
		String option;
		String name;
		String phone;
		Supplier supplier;
		int id = 0;
		do {
			showMenu("Supplier");

			option = reader.nextLine();

			switch (option) {
			case "1":
				Vector<Supplier> result = supplierDAO.selectAll();
				System.out.println(result.toString());
				break;
			case "2":
				System.out.println("Enter an Id");
				id = Integer.parseInt(reader.nextLine());
				supplier = supplierDAO.selectById(id);
				System.out.println(supplier.toString());
				break;
			case "3":
				System.out.println("Enter a name");
				name = reader.nextLine();
				supplier = supplierDAO.selectByName(name);
				System.out.println(supplier.toString());
				break;
			case "4":
				System.out.println("Enter an Id");
				id = Integer.parseInt(reader.nextLine());
				System.out.println("Enter a name");
				name = reader.nextLine();
				System.out.println("Enter a phone");
				phone = reader.nextLine();
				supplier = new Supplier(id, name, phone);
				supplierDAO.insert(supplier);
				break;
			case "5":
				System.out.println("Enter existing Id");
				id = Integer.parseInt(reader.nextLine());
				System.out.println("Enter a name");
				name = reader.nextLine();
				System.out.println("Enter a phone");
				phone = reader.nextLine();
				supplier = new Supplier(id, name, phone);
				supplierDAO.update(supplier);
				break;
			case "6":
				System.out.println("Enter existing Id");
				id = Integer.parseInt(reader.nextLine());
				supplierDAO.delete(id);
				break;
			case "7":
				System.out.println("Enter a CSV filename to Import");
				name = reader.nextLine();
				supplierDAO.importCSV(name);
				break;
			case "8":
				System.out.println("Enter a CSV filename to Export");
				name = reader.nextLine();
				supplierDAO.exportCSV(name);
				break;
			default:
				System.out.println("Ok, see you around");
				break;
			}
		} while (!option.equals("9"));
	}

}
