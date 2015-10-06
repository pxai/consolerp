package org.cuatrovientos.consolerp;

import java.util.Scanner;
import java.util.Vector;

import org.cuatrovientos.consolerp.dao.DelegationDAO;
import org.cuatrovientos.consolerp.model.Delegation;

public class ManageDelegation extends ManageTable {
	private DelegationDAO delegationDAO;
	private Scanner reader;

	/**
	 * constructor
	 */
	public ManageDelegation (Scanner reader) {
		delegationDAO = new DelegationDAO();
		this.reader = reader;
	}
	
	@Override
	public void manage() {
		String option;
		String name;
		String description;
		Delegation delegation;
		int clave = 0;
		do {
			showMenu("Delegation");

			option = reader.nextLine();

			switch (option) {
			case "1":
				Vector<Delegation> result = delegationDAO.selectAll();
				System.out.println(result.toString());
				break;
			case "2":
				System.out.println("Enter an Id");
				clave = Integer.parseInt(reader.nextLine());
				delegation = delegationDAO.selectById(clave);
				System.out.println(delegation.toString());
				break;
			case "3":
				System.out.println("Enter an Id");
				clave = Integer.parseInt(reader.nextLine());
				System.out.println("Enter a name");
				name = reader.nextLine();
				System.out.println("Enter a description");
				description = reader.nextLine();
				delegation = new Delegation(clave, name, description);
				delegationDAO.insert(delegation);
				break;
			case "4":
				System.out.println("Enter existing Id");
				clave = Integer.parseInt(reader.nextLine());
				System.out.println("Enter a name");
				name = reader.nextLine();
				System.out.println("Enter a description");
				description = reader.nextLine();
				delegation = new Delegation(clave, name, description);
				delegationDAO.update(delegation);
				break;
			case "5":
				System.out.println("Enter existing Id");
				clave = Integer.parseInt(reader.nextLine());
				delegationDAO.delete(clave);
				break;
			default:
				System.out.println("Ok, see you around");
				break;
			}
		} while (!option.equals("6"));
	}


}
