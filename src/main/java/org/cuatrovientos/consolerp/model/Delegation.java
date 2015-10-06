/**
 * 
 */
package org.cuatrovientos.consolerp.model;

/**
 * @author Dani
 *
 */
public class Delegation {
	private int clave;
	private String name;
	private String description;
	
	public Delegation() {
		
	}

	public Delegation(int clave, String name, String description) {
		super();
		this.clave = clave;
		this.name = name;
		this.description = description;
	}

	/**
	 * @return the clave
	 */
	public int getClave() {
		return clave;
	}

	/**
	 * @param clave the clave to set
	 */
	public void setClave(int clave) {
		this.clave = clave;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Delegation [clave=" + clave + ", name=" + name + ", description=" + description + "]";
	}
	

}
