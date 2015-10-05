package org.cuatrovientos.consolerp;

import java.util.Scanner;
import java.util.Vector;

import org.cuatrovientos.consolerp.dao.CustomerDAO;
import org.cuatrovientos.consolerp.dao.UserDAO;
import org.cuatrovientos.consolerp.model.Customer;
import org.cuatrovientos.consolerp.model.User;

public class ManageUser extends ManageTable {
private UserDAO userDAO;
private Scanner reader;

public ManageUser (Scanner reader) {
	userDAO = new UserDAO();
	this.reader = reader;
}

@Override
public void manage() {
	String option;
	String login;
	String password;
	
	User user;
	int id = 0;
	do {
		showMenu("Customer");

		option = reader.nextLine();

		switch (option) {
		case "1":
			Vector<User> result = userDAO.selectAll();
			System.out.println(result.toString());
			break;
		case "2":
			System.out.println("Enter an Id");
			id = Integer.parseInt(reader.nextLine());
			user = userDAO.selectById(id);
			System.out.println(user.toString());
			break;
		case "3":
			System.out.println("Enter an Id");
			id = Integer.parseInt(reader.nextLine());
			System.out.println("Enter a login");
			login = reader.nextLine();
			System.out.println("Enter a password");
			password = reader.nextLine();
			
			user = new User(id, login,password);
			userDAO.insert(user);
			break;
		case "4":
			System.out.println("Enter existing Id");
			id = Integer.parseInt(reader.nextLine());
			System.out.println("Enter a name");
			login = reader.nextLine();
			System.out.println("Enter a password");
			password= reader.nextLine();
			user = new User(id, login,password);
			userDAO.update(user);
			break;
		case "5":
			System.out.println("Enter existing Id");
			id = Integer.parseInt(reader.nextLine());
			userDAO.delete(id);
			break;
		case "6":
			System.out.println("Enter a login");
			login = reader.nextLine();
			user = userDAO.selectByLogin(login);
			System.out.println(user.toString());
			
		default:
			System.out.println("Ok, see you around");
			break;
		}
	} while (!option.equals("7"));
}

}
