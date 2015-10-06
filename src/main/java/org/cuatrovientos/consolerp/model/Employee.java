/**
 * 
 */
package org.cuatrovientos.consolerp.model;

/**
 * POJO Employee
 * @author Bego Lopez
 *
 */
public class Employee {
	private int id;
	private String name;
	private String phone;
	
	/**
	 * void constructor
	 */
	public Employee (){
		
	}
	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 * @param phone
	 */
	public Employee(int id, String name, String phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	
	

}
