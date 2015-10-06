/**
 * 
 */
package org.cuatrovientos.consolerp;

import java.util.Scanner;
import java.util.Vector;

import org.cuatrovientos.consolerp.dao.StockDAO;
import org.cuatrovientos.consolerp.model.Stock;

/**
 * @author Julen
 *
 */
public class ManageStock 
	extends ManageTable {
		
		private StockDAO stockDAO;
		private Scanner reader;

		/**
		 * constructor
		 */
		public ManageStock (Scanner reader) {
			stockDAO = new StockDAO();
			this.reader = reader;
		}
		
		@Override
		public void manage() {
			String option;
			String description;
			int rack = 0;
			Stock stock;
			int id = 0;
			do {
				showMenu("Stock");

				option = reader.nextLine();

				switch (option) {
				case "1":
					Vector<Stock> result = stockDAO.selectAll();
					System.out.println(result.toString());
					break;
				case "2":
					System.out.println("Enter an Id");
					id = Integer.parseInt(reader.nextLine());
					stock = stockDAO.selectById(id);
					System.out.println(stock.toString());
					break;
				case "3":
					System.out.println("Enter an Id");
					id = Integer.parseInt(reader.nextLine());
					System.out.println("Enter a rack");
					rack = Integer.parseInt(reader.nextLine());
					System.out.println("Enter a description");
					description = reader.nextLine();
					stock = new Stock(id, rack, description);
					stockDAO.insert(stock);
					break;
				case "4":
					System.out.println("Enter existing Id");
					id = Integer.parseInt(reader.nextLine());
					System.out.println("Enter a rack");
					rack = Integer.parseInt(reader.nextLine());
					System.out.println("Enter a description");
					description = reader.nextLine();
					stock = new Stock(id, rack, description);
					stockDAO.update(stock);
					break;
				case "5":
					System.out.println("Enter existing Id");
					id = Integer.parseInt(reader.nextLine());
					stockDAO.delete(id);
					break;
				default:
					System.out.println("Byeeee, byeeeee");
					break;
				}
			} while (!option.equals("6"));
		}
}
