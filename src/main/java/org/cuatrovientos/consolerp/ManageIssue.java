/**
 * 
 */
package org.cuatrovientos.consolerp;

import java.util.Scanner;
import java.util.Vector;

import org.cuatrovientos.consolerp.dao.IssueDAO;
import org.cuatrovientos.consolerp.model.Issue;


/**
 * @author Irene
 *
 */
public class ManageIssue extends ManageTable{
	
	private IssueDAO issueDAO;
	private Scanner reader;

	/**
	 * constructor
	 * @return 
	 */
	public ManageIssue (Scanner reader) {
		issueDAO = new IssueDAO();
		this.reader = reader;
	}

	@Override
	public void manage() {
		String option;
		String name;
		String description;
		Issue issue;
		int id = 0;
		do {
			showMenu("Issue");

			option = reader.nextLine();

			switch (option) {
			case "1":
				Vector<Issue> result = issueDAO.selectAll();
				System.out.println(result.toString());
				break;
			case "2":
				System.out.println("Enter an Id");
				id = Integer.parseInt(reader.nextLine());
				issue = issueDAO.selectById(id);
				System.out.println(issue.toString());
				break;
			case "3":
				System.out.println("Enter an Id");
				id = Integer.parseInt(reader.nextLine());
				System.out.println("Enter a name");
				name = reader.nextLine();
				System.out.println("Enter a description");
				description = reader.nextLine();
				issue = new Issue(id, name, description);
				issueDAO.insert(issue);
				break;
			case "4":
				System.out.println("Enter existing Id");
				id = Integer.parseInt(reader.nextLine());
				System.out.println("Enter a name");
				name = reader.nextLine();
				System.out.println("Enter a description");
				description = reader.nextLine();
				issue = new Issue(id, name, description);
				issueDAO.update(issue);
				break;
			case "5":
				System.out.println("Enter existing Id");
				id = Integer.parseInt(reader.nextLine());
				issueDAO.delete(id);
				break;
			default:
				System.out.println("Ok, see you around");
				break;
			}
		} while (!option.equals("6"));
	}

}
