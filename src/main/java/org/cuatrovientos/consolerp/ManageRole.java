package org.cuatrovientos.consolerp;

import java.util.Scanner;
import java.util.Vector;

import org.cuatrovientos.consolerp.dao.RoleDAO;
import org.cuatrovientos.consolerp.model.Role;


public class ManageRole extends ManageTable {

private RoleDAO roleDAO;
private Scanner reader;

/**
 * constructor
 */
public ManageRole (Scanner reader) {
	roleDAO = new RoleDAO();
	this.reader = reader;
}

@Override
public void manage() {
	String option;
	String name;
	String description;
	Role role;
	int id = 0;
	do {
		showMenu("Role");

		option = reader.nextLine();

		switch (option) {
		case "1":
			Vector<Role> result = roleDAO.selectAll();
			System.out.println(result.toString());
			break;
		case "2":
			System.out.println("Enter an Id");
			id = Integer.parseInt(reader.nextLine());
			role = roleDAO.selectById(id);
			System.out.println(role.toString());
			break;
		case "3":
			System.out.println("Enter an Id");
			id = Integer.parseInt(reader.nextLine());
			System.out.println("Enter a name");
			name = reader.nextLine();
			System.out.println("Enter a description");
			description = reader.nextLine();
			role = new Role(id, name, description);
			roleDAO.insert(role);
			break;
		case "4":
			System.out.println("Enter existing Id");
			id = Integer.parseInt(reader.nextLine());
			System.out.println("Enter a name");
			name = reader.nextLine();
			System.out.println("Enter a description");
			description = reader.nextLine();
			role = new Role(id, name, description);
			roleDAO.update(role);
			break;
		case "5":
			System.out.println("Enter existing Id");
			id = Integer.parseInt(reader.nextLine());
			roleDAO.delete(id);
			break;
		default:
			System.out.println("Ok, see you around");
			break;
		}
	} while (!option.equals("6"));
}

}

