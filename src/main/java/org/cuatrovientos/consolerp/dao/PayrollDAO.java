
	package org.cuatrovientos.consolerp.dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Vector;

	import org.cuatrovientos.consolerp.datasource.DataSource;
	import org.cuatrovientos.consolerp.model.Payroll;

	public class PayrollDAO {

		private Connection connection;

		public PayrollDAO() {
			connection = new DataSource().getConnection();
		}

		/**
		 * select all payrolls
		 * @return
		 */
		public Vector<Payroll> selectAll() {
			Vector<Payroll> payrolls = new Vector<Payroll>();
			String select = "select * from payroll ";
			Statement statement;
			try {
				statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(select);

				while (resultSet.next()) {
					Payroll payroll = new Payroll(resultSet.getInt("id"), resultSet.getString("description"), resultSet.getFloat("gross"));
					payrolls.addElement(payroll);
				}
			} catch (SQLException e) {
				System.err.println("Exception " + e.getMessage());
				e.printStackTrace();
			}
			return payrolls;
		}

		/**
		 * select one Payroll
		 * @param id
		 * @return
		 */
		public Payroll selectById(int id) {
			Payroll payroll = new Payroll();
			try {
				PreparedStatement preparedStatement =
						connection.prepareStatement("select * from payroll where id = ? ");

				preparedStatement.setInt(1, 2);
				preparedStatement.addBatch();
				
				ResultSet resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
				 payroll = new Payroll(resultSet.getInt("id"),resultSet.getString("description"), resultSet.getFloat("gross"));
				
				}
			} catch (SQLException e) {
				System.err.println("Exception " + e.getMessage());
				e.printStackTrace();
			}
			return payroll;
		}

		/**
		 * insert new payroll
		 * @param customer
		 * @return
		 */
		public int insert(Payroll payroll) {
			int[] result;
			try {
				PreparedStatement preparedStatement =
						connection.prepareStatement("insert into payroll values (?,?)");

				preparedStatement.setInt(1, payroll.getId());
				preparedStatement.setString(2, payroll.getDescription());
				preparedStatement.setFloat(3, payroll.getGross());
				preparedStatement.addBatch();
				
				result = preparedStatement.executeBatch();

			} catch (SQLException e) {
				System.err.println("Exception " + e.getMessage());
				e.printStackTrace();
				return -1;
			} 
			return result[0];
		}

		/**
		 * updates a Customer
		 * @param customer
		 * @return
		 */
		public int update(Payroll payroll) {
			int[] result;
			try {
				PreparedStatement preparedStatement =
						connection.prepareStatement("update payroll set name=? where id=?");

				preparedStatement.setString(1, payroll.getDescription());
				preparedStatement.setInt(2, payroll.getId());
				preparedStatement.addBatch();
				
				result = preparedStatement.executeBatch();

			} catch (SQLException e) {
				System.err.println("Exception " + e.getMessage());
				e.printStackTrace();
				return -1;
			} 
			return result[0];
		}

		/**
		 * delete one customer
		 * @return
		 */
		public int delete(int id) {
			int[] result;
			try {
				PreparedStatement preparedStatement =
						connection.prepareStatement("delete from payroll where id=?");

				preparedStatement.setInt(1, id);
				preparedStatement.addBatch();
				
				result = preparedStatement.executeBatch();

			} catch (SQLException e) {
				System.err.println("Exception " + e.getMessage());
				e.printStackTrace();
				return -1;
			} 
			return result[0];
		}

	

		
	}


