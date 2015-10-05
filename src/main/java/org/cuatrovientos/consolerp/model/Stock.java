package org.cuatrovientos.consolerp.model;

/**
 * Class POJO of Stock
 * @author Julen
 *
 */
public class Stock {
	private int id;
	private int rack;
	private String description;
	
	public Stock () {
		
	}
	
	/**
	 * @param id
	 * @param name
	 */
	public Stock(int id, int rack, String description) {
		this.id = id;
		this.rack = rack;
		this.description = description;
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
	 * @return the rack
	 */
	public int getRack() {
		return rack;
	}

	/**
	 * @param rack the rack to set
	 */
	public void setRack(int rack) {
		this.rack = rack;
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
		return "Stock [id=" + id + ", rack=" + rack + ", description=" + description + "]";
	}
	
}
