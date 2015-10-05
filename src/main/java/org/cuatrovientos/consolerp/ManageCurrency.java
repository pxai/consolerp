/**
 * 
 */
package org.cuatrovientos.consolerp;

import java.util.Scanner;
import java.util.Vector;

import org.cuatrovientos.consolerp.dao.CurrencyDAO;
import org.cuatrovientos.consolerp.dao.CustomerDAO;
import org.cuatrovientos.consolerp.model.Currency;
import org.cuatrovientos.consolerp.model.Customer;

/**
 * @author segoitz-guibert
 *
 */
public class ManageCurrency 
	extends ManageTable {
		
		private CurrencyDAO currencyDAO;
		private Scanner reader;

		/**
		 * constructor
		 */
		public ManageCurrency(Scanner reader) {
			currencyDAO = new CurrencyDAO();
			this.reader = reader;
		}
		
		@Override
		public void manage() {
			String option;
			String name;
			String abbreviation;
			Currency currency;
			int id = 0;
			do {
				showMenu("Customer");

				option = reader.nextLine();

				switch (option) {
				case "1":
					Vector<Currency> result = currencyDAO.selectAll();
					System.out.println(result.toString());
					break;
				case "2":
					System.out.println("Enter an Id");
					id = Integer.parseInt(reader.nextLine());
					currency = currencyDAO.selectById(id);
					System.out.println(currency.toString());
					break;
				case "3":
					System.out.println("Enter an Id");
					id = Integer.parseInt(reader.nextLine());
					System.out.println("Enter a name");
					name = reader.nextLine();
					System.out.println("Enter an abbreviation");
					abbreviation = reader.nextLine();
					currency = new Currency(id, name,abbreviation);
					currencyDAO.insert(currency);
					break;
				case "4":
					System.out.println("Enter existing Id");
					id = Integer.parseInt(reader.nextLine());
					System.out.println("Enter a name");
					name = reader.nextLine();
					System.out.println("Enter an abbreviation");
					abbreviation = reader.nextLine();
					currency = new Currency(id, name,abbreviation);
					currencyDAO.update(currency);
					break;
				case "5":
					System.out.println("Enter existing Id");
					id = Integer.parseInt(reader.nextLine());
					currencyDAO.delete(id);
					break;
				default:
					System.out.println("Ok, see you around");
					break;
				}
			} while (!option.equals("6"));
		}

	}


